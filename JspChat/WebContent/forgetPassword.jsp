<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
byte b[]=request.getParameter("user").getBytes("ISO-8859-1");
String s1=new String(b);
String s2=new String(request.getParameter("number").getBytes("ISO-8859-1"),"utf-8");
	
try
{
	Statement stm=con.createStatement();
	ResultSet result;//=stm.executeQuery("select count(*) from register");
	result=stm.executeQuery("SELECT password FROM register WHERE (user='"+s1+"'and telephone='"+s2+"')");
   if(result.next())
   {
	   result.close();
		stm.close();
		con.close();
		session.setAttribute("userReset",s1);
		response.sendRedirect("resetPassword.html");
   }
   else{
	   response.getWriter().write("<script>alert('用户名或电话错误！!')</script>");
		result.close();
	stm.close();
	con.close();
	response.setHeader("Refresh","0;url=forgetPassword.html");
 
 }
}
  catch (SQLException e) {
	// TODO Auto-generated catch block
		
	e.printStackTrace();
}
%>
</body>
</html>