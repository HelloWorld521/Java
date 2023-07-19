package com.hjy.util;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

//模拟浏览器发送请求给服务器
public class GetParm {
	private Map<String, String> map = new HashMap<String, String>() ;
	public GetParm() {}
	
	public Map<String,String> getParm(String property){
		String[] split3 = property.split("&");
		
		for (int i = 0; i < split3.length; i++) {
			String[] split4 = split3[i].split("=");
			map.put(split4[0], URLDecoder.decode(split4[1]));
		}
		System.out.println(map);
		return map;
	}
}
