package com.briup.client.imp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.briup.client.Gather;
import com.briup.common.Backup;
import com.briup.common.Configuration;
import com.briup.common.ConfigurationAWare;
import com.briup.common.Log;
import com.briup.common.imp.BackupImp;
import com.briup.common.imp.ConfigurationImp;
import com.briup.common.imp.LogImp;
import com.briup.model.BIDR;

public class GatherImp implements Gather,ConfigurationAWare{
	private Backup back;
	private Log log;
	private Logger logger;
	private String gatherFileName;
	private String countFileName;
	private String path;
	@Override
	public void init(Properties properties) {
		gatherFileName = properties.getProperty("gatherFileName");
		countFileName = properties.getProperty("countFileName");
		path = properties.getProperty("path");
	}

	@Override
	public Collection<BIDR> gather() throws Exception {
		Map<String,BIDR> map = new HashMap<String,BIDR>();//不完整对象集合、
		//加载map数据
		Map<String,BIDR> map_old = (Map<String, BIDR>) back.load(gatherFileName);
		if(map_old!=null){
			map.putAll(map_old);
			back.deleteBackup(gatherFileName);
		}
		List<BIDR> logoutBidr = new ArrayList<BIDR>();//完整对象集合
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line = null;
		long skip = 0; 
		logger.info("开始采集数据");
		//读取备份的字符数
		Long skip_old =(Long) back.load(countFileName);
		if(skip_old != null){
			skip = skip_old;
			br.skip(skip);
			back.deleteBackup(countFileName);
		}
		logger.info("跳过字符数"+skip);
		while(br.ready()){
			line = br.readLine();
			skip = skip + line.length()+2;
			String[] split = line.split("[|]");
			if(split[2].equals("7")){
				BIDR bidr = new BIDR();
				String username = split[0].substring(1);
				String nasIp = split[1];
				Date loginDate = new Date(Long.parseLong(split[3])*1000);
				String loginIp = split[4];
				bidr.setAaaLoginName(username);
				bidr.setNasIp(nasIp);
				bidr.setLoginDate(loginDate);
				bidr.setLoginIp(loginIp);
				map.put(loginIp, bidr); //所有上线对象
			}else if(split[2].equals("8")){
				Date dateForLogout = new Date(Long.parseLong(split[3])*1000);//下线时间
				String loginIp=split[4];
				BIDR bidr = map.get(loginIp);
				//判断上线和下线时间   是否为同一天
				int logoutDay = dateForLogout.getDate();
				int loginDay = bidr.getLoginDate().getDate();
				if(logoutDay == loginDay){
					//同一天，添加下线时间和在线时长，map移出，list添加
					long timeDuration = 
							((Long.parseLong(split[3]))-(bidr.getLoginDate().getTime()/1000)); 
					bidr.setLogoutDate(dateForLogout);
					bidr.setTimeDuration(timeDuration);
					map.remove(loginIp);
					logoutBidr.add(bidr);
				}else{
					//不在同一天
					//下线时间设为后一天0:00
					dateForLogout.setHours(0);
					dateForLogout.setMinutes(0);
					dateForLogout.setSeconds(0);
					//补充map集合的不完整的BIDR对象
					bidr.setLogoutDate(dateForLogout);
					//下线时间-上线时间
					long timeDuration =
							((dateForLogout.getTime())-(bidr.getLoginDate().getTime()))/1000; 
					bidr.setTimeDuration(timeDuration);
					map.remove(loginIp);
					logoutBidr.add(bidr);
					
					//创建一个新的BIDR对象
					BIDR bidr2 = new BIDR();
					bidr2.setAaaLoginName(bidr.getAaaLoginName());
					bidr2.setLoginDate(dateForLogout);//上线时间为下线时间0:00
					bidr2.setLoginIp(bidr.getLoginIp());
					bidr2.setNasIp(bidr.getNasIp());
					Date dateForLogout2 = new Date(Long.parseLong(split[3])*1000);
					bidr2.setLogoutDate(dateForLogout2);//原下线时间
					timeDuration = ((dateForLogout2.getTime())-(dateForLogout.getTime()))/1000; 
					bidr2.setTimeDuration(timeDuration);
					logoutBidr.add(bidr2);
				}
			}
			
		}
		//保存已经读取的字符数
		logger.info("未采集数据大小:"+map.size());
		logger.info("采集完成数据大小:"+logoutBidr.size());
		logger.info("保存已读取的字符数"+skip);
		back.backup(countFileName, skip);
		logger.info("保存不完整map对象");
		back.backup(gatherFileName, map);
		if(br!=null){
			br.close(); 
		}
		return logoutBidr;
	}
//	public static void main(String[] args) {
//		GatherImp imp = new GatherImp();
//		try {
//			Collection<BIDR> gather = imp.gather();
////			for(BIDR bidr : gather){
////				System.out.println(bidr);
////			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	@Override
	public void setConfiguration(Configuration cfig) {
		back = cfig.getBackup();
		log = cfig.getLogger();
		logger = log.getClientLogger();
	}
}
