<html><head>
    <base href="http://localhost:8080/webqq/">
    <style type="text/css">

body {
    background-size: cover;
    color: #666666;
    font-family: "Helvetica Neue",Helvetica,"Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
    height: 100%;
}
.a {
    background: #cf3 none repeat scroll 0 0;
    height: 100%;
    margin: 0 auto;
    width: 1000px;
}
.b {
    float: left;
    height: 80%;
    margin: 20px;
    width: 280px;
}
.c {
    float: left;
    height: 60%;
    margin: 20px;
    position: relative;
    width: 500px;
}
.d {
    float: left;
    margin-left: 20px;
    margin-right: 20px;
    margin-top: 20px;
    width: 500px;
}
    </style>
    <title>JSP聊天室</title>
	<meta content="no-cache" http-equiv="pragma"> 
	<meta content="no-cache" http-equiv="cache-control">
	<meta content="0" http-equiv="expires">   
	<meta content="keyword1,keyword2,keyword3" http-equiv="keywords">
	<meta content="This is my page" http-equiv="description">

<!-- <link rel="stylesheet" type="text/css" href="styles.css"> -->
  </head>
<!--   <frameset rows="70%,30%"> -->
<!--     <frameset cols="80%,20%"> -->
<!--        <frame src="left.jsp" name="left" class="left"/> -->
<!-- 	   <frame src="right.jsp" name="right" class="right"/> -->
<!-- 	</frameset> -->
<!--    <frame src="bottom.jsp" class="bottom"/> -->
<!--  </frameset> -->
  <body>
  <div class="a">
   <div class="b">
   <iframe name="right" src="right.jsp"></iframe>
   </div>
   <div class="c">
 	<iframe name="left" src="left.jsp"></iframe>
	</div>
   <div class="d">
   <iframe src="bottom.jsp"></iframe>
   </div>
   </div>
  

</body></html>