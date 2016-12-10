<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript">
	var i=0;
	function exit() {
		window.location.href = "Exit.jsp?backurl=" + window.location.href;
	}
	function arrowleft() {
		var element=document.getElementById("bidy");
		var arr=new Array();
		i++;
		if(i==5){
			i=0;
		}
		arr[0]="images/bg1.jpg";
		arr[1]="images/bg2.jpg";
		arr[2]="images/bg3.jpg";
		arr[3]="images/bg4.jpg";
		arr[4]="images/bg5.jpg";
		element.background=arr[i];
		}
	function arrowright() {
		var element=document.getElementById("bidy");
		var arr=new Array();
		i--;
		if(i==-1){
			i=4;
		}
		arr[0]="images/bg1.jpg";
		arr[1]="images/bg2.jpg";
		arr[2]="images/bg3.jpg";
		arr[3]="images/bg4.jpg";
		arr[4]="images/bg5.jpg";
		element.background=arr[i];
		}
</script>
<style type="text/css">
body {
	background-size: cover;
	color: #000;
	font-family: "Helvetica Neue", Helvetica, "Hiragino Sans GB",
		"Microsoft YaHei", "Œ¢»Ì—≈∫⁄", Arial, sans-serif;
	height: 100%;
}

.aa {
	height: 50px;
	width: 1200px;
	float: left;
}

.button {
	width: 20px;
	float: right;
}

.a {
	background: none repeat scroll 0 0;
	height: 100%;
	margin: 0 auto;
	width: 1000px;
	overflow: auto;
}

.b {
	float: left;
	height: 70%;
	width: 280px;
	border-radius: 6px;
	filter: alpha(opacity = 10);
}

.c {
	float: left;
	height: 60%;
	position: relative;
	border-radius: 6px;
	width: 500px;
}

.d {
	float: left;
	width: 500px;
	height: 80px;
	border-radius: 6px;
	filter: alpha(opacity = 10);
}

.arrowright {
	width: 20px;
	height: 20px;
	margin-left:20px;
}
.arrowright:horver{
	background:url(images/arrowright1.png)
}
.arrowleft {
	width: 20px;
	height: 20px;
}
.arrowleft:horver{
	background:url(images/arrowleft1.png)
}

.title {
	width:800px;
	font-size: 30px;
	text-align: center;
	float:right;
}
img{
float:left;
}
autio{margin-left:50px;margin-top:10px;color:#666;}
</style>
<title>JSP¡ƒÃÏ “</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>
<body id="bidy" background=images/bg2.jpg>
	<div class="aa"></div>
	<div class="button">
		<img onclick="exit()" src="images/botton.png" />
	</div>
	<div style="clear:both;"></div>
		
	<div class="a">
	<% String s2=(String)session.getAttribute("tx");
	out.print("<img src=\"images/"+s2+".jpg\">");
	out.print("’À∫≈£∫"+session.getAttribute("user"));
	%>
		<div class="title">¡ƒÃÏƒ⁄»›</div>
		<iframe src="right.jsp" name="right" width="280px" height="480px"
			class="b" scrolling="no"></iframe>

		<iframe src="left.jsp" name="left" width="500px" height="385px"
			class="c" scrolling="no"></iframe>

		<iframe src="bottom.jsp" class="d" scrolling="no"></iframe>

		<div class="arrowleft" >
			<img id="left"  src="images/arrowleft.png" onclick="arrowleft()">
		</div>
		<div class="arrowright">
			<img id="right" src="images/arrowright.png" onclick="arrowright()"/>
		</div>
		<audio controls="ture" src="images/music.mp3"></audio>
	</div>
</body>
</html>
