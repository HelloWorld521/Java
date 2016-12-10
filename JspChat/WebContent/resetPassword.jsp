<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String driverName="com.mysql.jdbc.Driver";
String username="root";
String userpassword="123456";
String dbname="qq";
String tablename="register";
String url="jdbc:mysql://localhost:3306/"+dbname;
Connection con=null;
Statement s=null;
ResultSet rs;
try
{
	Class.forName(driverName).newInstance();
}
catch(ClassNotFoundException e)
{
	System.out.print("Error loading Driver,不能加载驱动");
}
try
{
	con=DriverManager.getConnection(url,username,userpassword);
	}
catch(SQLException er)
{
	System.out.print("Error getConnection,不能连接数据库");
	}
String s1=new String(request.getParameter("pass1").getBytes("ISO-8859-1"),"utf-8");
String s2=(String)session.getAttribute("userReset");
	
try
{
	Statement stm=con.createStatement();
	String sql="update register set password='"+s1+"' where user='"+s2+"'"; 
	stm.executeUpdate(sql);
	
	
	response.getWriter().write("<script>alert('修改成功！!')</script>");
	stm.close();
	con.close();
	response.setHeader("Refresh","0;url=login.jsp");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	
response.getWriter().write("<script>alert('用户名输入错误！!')</script>");
	response.setHeader("Refresh","0;url=resetPassword.html");
	
}
%>
</body>
</html>