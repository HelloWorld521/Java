<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="check.jsp">
	<input type="text" placeholder="请输入验证码" name="code">
	<img alt="验证码" src="randomcode.jpg">
	<input type="submit" value="验证">
</form>
</body>
</html>