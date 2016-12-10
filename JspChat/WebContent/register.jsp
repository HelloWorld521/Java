<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册处理</title>
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
try{
	s=con.createStatement();
	String use=new String(request.getParameter("user").getBytes("ISO-8859-1"),"utf-8");
	String pass=new String(request.getParameter("password").getBytes("ISO-8859-1"),"utf-8");
	String num=new String(request.getParameter("number").getBytes("ISO-8859-1"),"utf-8");
 
 	 String sql="insert into register values('"+use+"','"+pass+"','"+num+"')";
	s.executeUpdate(sql);
	response.getWriter().write("<script>alert('恭喜你注册成功！!')</script>");
		response.setHeader("Refresh","0;url=login.jsp");
con.close();
s.close();

}
catch(SQLException er)
{
	response.getWriter().write("<script>alert('用户名已存在！!')</script>");
		//response.setHeader("Refresh","0;url=login.jsp");
	response.setHeader("Refresh","0;url=register.html");	
	}

%>
</body>
</html>