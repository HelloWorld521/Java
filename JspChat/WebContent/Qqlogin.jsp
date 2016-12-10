<%@  page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>正在登录..</title>
</head>
<body>
<%
Connection con=null; 
String JDriver="com.mysql.jdbc.Driver";
String username="root";
String userPasswd="123456";
String dbname="qq";
String conURL="jdbc:mysql://localhost:3306/"+dbname;
try
{
Class.forName(JDriver).newInstance();
con=DriverManager.getConnection(conURL,username,userPasswd);
}catch(Exception e)
{
	System.err.println(e.getMessage());
}
String s1=new String(request.getParameter("user").getBytes("ISO-8859-1"),"utf-8");
String s2=new String(request.getParameter("password").getBytes("ISO-8859-1"),"utf-8");
//System.out.println(s2);
try
{
	Statement stm=con.createStatement();
	ResultSet result=null;//=stm.executeQuery("select count(*) from register");
	String s11 = null;
	result=stm.executeQuery("SELECT password FROM register WHERE user='"+s1+"'");
   	while(result.next())
   	{
	 s11=result.getString("password");
   	}
	if (s2.equals(s11)) {
	int x;
		 java.util.Random r=new java.util.Random();
		 x=(r.nextInt() >>> 1) %10;
		session.setAttribute("user", s1);
		session.setAttribute("tx",Integer.toString(x));
		response.sendRedirect("main.jsp");
		}else{
		 response.getWriter().write("<script>alert('用户名或密码输入错误！!')</script>");
		response.setHeader("Refresh","0;url=login.jsp");
		
		}
	result.close();
	stm.close();
	con.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	response.getWriter().write("<script>alert('用户名错误！!')</script>");
	response.setHeader("Refresh","0;url=login.jsp");
}
%>
</body>
</html>