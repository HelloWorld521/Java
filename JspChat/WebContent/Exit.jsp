<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
 //取得登录的用户名
 String username = (String) session.getAttribute("user");
 //销毁session
 session.invalidate();
 // 从在线列表中删除用户名
 List onlineUserList = (List) application.getAttribute("onlineUserList");
 onlineUserList.remove(username);	
 application.setAttribute("onlineUserList",onlineUserList);
 response.sendRedirect("login.jsp");
%>
	
<!-- 	<script type="text/javascript">
if(confim("你确定要退出系统吗"))
	{
	window.close();
	
	}

</script> -->
	
</body>
</html>