package com.briup.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author Chen
 * jdbc连接数据库简单封住
 * */
public class DBUtils{
	private static Connection connection=null;
	private static String driverName;
	/**
	 * 获取Connection对象
	 * */
	public static Connection getConnection(String url,String user,String password){
		try {
			driverName = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driverName);
			connection=
				DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	/**
	 * 关闭资源
	 * */
	public static void close(ResultSet set,Statement statement,Connection conn){
		try {
			if(set!=null) set.close();
			if(statement!=null) statement.close();
			if(conn!=null)conn.close();
		} catch (Exception e) {
		}
	}
}
