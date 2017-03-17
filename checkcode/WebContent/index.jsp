<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
function reloadcode(){
	var time = new Date().getTime();
	document.getElementById("imagecode").src="servlet/ImageCodeServlet?d="+time;
}


</script>
</head>
<body>
<form action="servlet/LoginServlet" method="get">
	验证码：<input type="text" name="checkcode">
	<img alt="验证码" src="servlet/ImageCodeServlet" id="imagecode">
	<a href="javascript:reloadcode();">看不清楚</a>
<input type="submit" value="验证">
</form> 
</body>
</html>