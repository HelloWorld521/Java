package com.briup.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Chen
 * 封装成BIDR对象
 * */
public class BIDR implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * AAA用户名
	 * */
	private String aaaLoginName;
	/**
	 * 用户ip
	 * */
	private String loginIp;
	/**
	 * 登录时间
	 * */
	private Date loginDate;
	/**
	 * 退出时间
	 * */
	private Date logoutDate;
	
	/**
	 * NAS服务器ip
	 * */
	private String nasIp;
	
	/**
	 * 在线时长
	 * */
	private long timeDuration;
	public String getAaaLoginName() {
		return aaaLoginName;
	}
	public void setAaaLoginName(String aaaLoginName) {
		this.aaaLoginName = aaaLoginName;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public Date getLogoutDate() {
		return logoutDate;
	}
	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}
	public String getNasIp() {
		return nasIp;
	}
	public void setNasIp(String nasIp) {
		this.nasIp = nasIp;
	}
	public long getTimeDuration() {
		return timeDuration;
	}
	public void setTimeDuration(long timeDuration) {
		this.timeDuration = timeDuration;
	}
	@Override
	public String toString() {
		return "BIDR [aaaLoginName=" + aaaLoginName + ", loginIp=" + loginIp
				+ ", loginDate=" + loginDate + ", logoutDate=" + logoutDate
				+ ", nasIp=" + nasIp + ", timeDuration=" + timeDuration + "]";
	}
	
}
