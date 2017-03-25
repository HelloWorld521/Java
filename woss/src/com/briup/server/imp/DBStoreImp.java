package com.briup.server.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.briup.common.Backup;
import com.briup.common.Configuration;
import com.briup.common.ConfigurationAWare;
import com.briup.common.DBUtils;
import com.briup.common.Log;
import com.briup.common.imp.ConfigurationImp;
import com.briup.common.imp.LogImp;
import com.briup.model.BIDR;
import com.briup.server.DBStore;

public class DBStoreImp implements DBStore,ConfigurationAWare{
	private Backup back;
	private Log log;
	private Logger logger;
	private String url;
	private String user;
	private String password;
	private String driverName;
	private String bakFileName;
	@Override
	public void init(Properties properties) {
		driverName = properties.getProperty("driverName");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
		bakFileName = properties.getProperty("bakFileName");
	}

	@Override
	public void saveToDB(Collection<BIDR> collection) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Collection<BIDR> bidrs_old = (Collection<BIDR>) back.load(bakFileName);
			if(bidrs_old!=null){
				logger.info("加载备份入库数据..");
				collection.addAll(bidrs_old);
				back.deleteBackup(bakFileName);
			}
			// 获取连接
			logger.info("正在连接数据库...");
			conn = DBUtils.getConnection(url, user, password);
			conn.setAutoCommit(false);
			int count = 0;
			int day=0;
			logger.info("连接完成，正在插入数据...");
			for (BIDR bidr : collection) {
				count++;
				if(day != bidr.getLoginDate().getDate()){
					day = bidr.getLoginDate().getDate();
					// 创建PStmt对象
					if(pstmt!=null){
						pstmt.executeBatch();
						pstmt.close();
					}
					String sql = "insert into t_detail_" + day + " values(?,?,?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
				}
				pstmt.setString(1, bidr.getAaaLoginName());
				pstmt.setString(2, bidr.getLoginIp());
				long loginDate = bidr.getLoginDate().getTime();
				pstmt.setTimestamp(3, new Timestamp(loginDate));
				long logoutDate = bidr.getLogoutDate().getTime();
				pstmt.setTimestamp(4, new Timestamp(logoutDate));
				pstmt.setString(5, bidr.getNasIp());
				pstmt.setLong(6, bidr.getTimeDuration());
				pstmt.addBatch();
				if(count%2000==0||count==collection.size()){
					pstmt.executeBatch();
				}
			}
			conn.commit();
			logger.info("数据插入成功");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
				logger.info("插入数据异常，数据回滚");
			} catch (SQLException e1) {
				e1.printStackTrace();
				logger.info("数据回滚异常");
			}
			try {
				back.backup(bakFileName, collection);
				logger.error("数据入库出现异常，备份入库数据完成");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				pstmt.close();
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void setConfiguration(Configuration cfig) {
		back = cfig.getBackup();
		log = cfig.getLogger();
		logger = log.getServerLogger();
	}
}
