<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	import="java.sql.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'left.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Refresh" content="3;url=left.jsp">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
body {
	font-family: "Helvetica Neue", Helvetica, "Hiragino Sans GB",
		"Microsoft YaHei", "微软雅黑", Arial, sans-serif;
	height: 100%;
	-webkit-background-size: cover;
	background-size: cover;
	color: #000;
	filter: alpha(opacity = 10);
}
</style>
</head>
<body onload="scroll(0,99999)"><br>
	<%
	request.setCharacterEncoding("utf-8");
        //设置乱码
   	String touxiang = request.getParameter("touxiang");
        //取得发送的聊天信息
    String message=request.getParameter("mess");
    String textColor =request.getParameter("textColor");
    String ip=session.getAttribute("user").toString();
    String msg =(String) application.getAttribute("msg");
        //如果取不到，说明是第一次，直接把得到的信息放入容器中即可。
	if(message!=null){
        	if(touxiang!=null)
           {
           message=session.getAttribute("user")+"说：<font color='"+textColor+"'>"+message+"</font><image src='"+touxiang+"'>";
        	}
        	else message=session.getAttribute("user")+"说：<font color='"+textColor+"'>"+message+"</font>";
           if(msg==null){
            //向这个容器中装入数据
            application.setAttribute("msg",message);
           }else{
               msg=msg+"<br>"+message;
               application.setAttribute("msg",msg);
           } 
        }
        if(msg!=null)
       out.println(msg); 
  %>
</body>
</html>
