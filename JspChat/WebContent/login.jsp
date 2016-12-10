<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="IE=Edge" charset="utf-8">
<title>登录界面</title>
<style type="text/css">
body{
	font-family: "Helvetica Neue",Helvetica,"Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
 	height: 100%;
    -webkit-background-size: cover;
    background-size: cover;
 	background:url(images/login.jpg);
    }
    .title{
        font-size: 60px;
        text-align: center;
        margin-top: 80px;
    }
    .conter{
    	text-align:center;
    	margin-top: 150px;
    }
    .man{
    	margin-left: 80%;
    	font-size: 10px;
        filter:alpha(opacity=50);
    }
    .form{
     	position:relative; 
    }
    .login{
     	margin-top: 10px;
        padding: 2px 15px;
        font-size: 20px;
        color:rgb(95,100,233);
        -webkit-transition: background 250ms ease-in, color 250ms ease-in;
        border-radius: 6px;
        text-decoration: none;
        filter:alpha(opacity=50);
    
    }
	 .login:hover{
        color: #fff;
        background:#BBD631;
    }
    .register{
    	font-size:15px;
    	color:rgb(95,100,200);
    }
    .image{
    	display: block;
    	position: absolute;
    	width: 100%;
    	height:100%;
    	top: 0;
    	left: 0;
    }
</style>
</head>
<body>
<div class="image">
<!-- <img class="image" src="image/20140723113608_JJRn2.jpeg"> -->
</div>
<div class="conter">
	<div class="title">欢迎登录</div>
	<form action="loginServlet" method="post" class="form">
	<table align="center">
	<tr><th>用户名:</th><td><input type="text" name="user" size=25>&nbsp;&nbsp;</td><td><a class="register" href="register.html">注册账号</a></td></tr><tr height="3px"></tr>
	<tr><th>密码:</th><td><input type="password" name="password" size=25>&nbsp;&nbsp;</td><td><a class="register" href="forgetPassword.html">找回密码</a></td></tr>
	<tr>
	<td align="center"  colspan="3"><input type="submit" value="登录" class="login"></td>
	</tr>
	</table>
</form>
</div>
</body>
</html>
