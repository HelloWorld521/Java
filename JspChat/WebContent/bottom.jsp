<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'bottom.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function aaa(){
		document.getElementById("small").style.zIndex=1;
		
	}
	function small(){
		document.getElementById("small").style.zIndex=3;
	}
	function resetRadio()
	{
		for(i=0;i<5;i++)
			document.form1.radiobutton[i].checked=false	
		
	}
	function sendMsg() {
		if (formms.message.value == ""&&formms.touxiang.value=="") {
			alert("不能发送空消息！");
			return false;
		}
		formms.mess.value = formms.message.value;
		formms.message.value = "";
		
		window.location.href=window.location.href;  
			}
		
</script>
<style type="text/css">
body {
	font-family: "Helvetica Neue", Helvetica, "Hiragino Sans GB",
		"Microsoft YaHei", "微软雅黑", Arial, sans-serif;
	height: 100%;
	-webkit-background-size: cover;
	background-size: cover;
	color: #000;

	position:relative;
}

.login {
	padding: 2px 15px;
	font-size: 15px;
	color: rgb(0, 100, 233);
	-webkit-transition: background 250ms ease-in, color 250ms ease-in;
	border-radius: 6px;
	text-decoration: none;
}

.login:hover {
	color: #fff;
	background: #BBD631;
}

.doc {
	display: inline-block;
}

.doc:hover {
	border: 1px;
}
#small{
	position:absolute;
	z-index:1;
}
#send{
	position:absolute;
	z-index:2;
}

</style>
</head>

<body>
	<form action="left.jsp" target="left" method="post" name="formms"
		onsubmit="return sendMsg()">
		字体颜色：<select name="textColor">
			<option value="black">黑色</option>
			<option value="red">红色</option>
			<option value="green">绿色</option>
			<option value="blue">蓝色</option>
		</select> 
		&nbsp;&nbsp;文件管理:&nbsp;&nbsp;<a class="doc" href="document.jsp" target="_blank"><img
			alt="文件管理" title="文件上传下载" src="images/documentMessage.png"></a> 
			&nbsp;&nbsp;选择表情：&nbsp;&nbsp;<img alt="表情"
			title="发送表情" src="images/small1.png" onclick="small()">
		<div id="small" name="small">
			 <input type="radio" name="touxiang" value="images/f01.gif" onclick="aaa()"><img src="images/f01.gif"> 
			 <input type="radio" name="touxiang" value="images/f02.gif" onclick="aaa()"><img src="images/f02.gif">
			 <input type="radio" name="touxiang" value="images/f03.gif" onclick="aaa()"><img src="images/f03.gif"> 
			 <input type="radio" name="touxiang" value="images/f04.gif" onclick="aaa()"><img src="images/f04.gif">
		</div>
		 <div id="send"><input type="text" name="message"
			style="width: 300px; height: 30px;"> <input type="submit"
			value="发送" class="login"> <input type="hidden" name="mess">
		</div>
	</form>
</body>
</html>
