<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'right.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Refresh" content="3;url=right.jsp">
<!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->
<style>
body {
	font-family: "Helvetica Neue", Helvetica, "Hiragino Sans GB",
		"Microsoft YaHei", "微软雅黑", Arial, sans-serif;
	height: 100%;
	-webkit-background-size: cover;
	background-size: cover;
	color: #000;
}
</style>
</head>

<body>
	<% 
	
	out.print("<h3>在线人数</h3>");
	
		String userName = (String) session.getAttribute("user");
		List onlineUserList = (List) application.getAttribute("onlineUserList");

		if (onlineUserList == null) {
			onlineUserList = new ArrayList();
			application.setAttribute("onlineUserList", onlineUserList);
		}

		if (onlineUserList.indexOf(userName) == -1)
			onlineUserList.add(userName);
		application.setAttribute("onlineUserList", onlineUserList);

		List onlist = (List) application.getAttribute("onlineUserList");
		for (int i = 0; i < onlist.size(); i++) {
			String s = (String) onlist.get(i);
			if(s!=null)
			out.print(s+"<br>");
		}
	%>
</body>
</html>
