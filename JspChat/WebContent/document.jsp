<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件管理</title>
</head>
<script type="text/javascript"> 
function tempClick(){ 
document.getElementById('main_img').click(); //调用main_img的onclick事件 

} 
function upload(path)
{
		
	document.forms[0].submit();
	}
</script> 
</head> 
<body background="images/document.jpg">
<center><p><b>文件上传</b></p> 
<form action="doUpload.jsp" name="selectfile" enctype="multipart/form-data" method="post">
<div><input type="file" style="position: absolute; filter: alpha(opacity = 0); opacity: 0; width: 30px;" size="1" id="main_img" name="main_img" onchange="upload()"></div> 
<div id="img_2" style="width:100px;height:100px;cursor:pointer; background-image: url('images/document.png');"title="文件上传" onclick="tempClick()"></div> 
</form> 
</center>
<br><br><br><center>文件下载
<table border= 1 bordercolor="ff9999"  width="87%">;
<tr height="6">
		<td width="210">
		<p align="center">文件</td>
		<td width="210">
		<p align="center">上传者</td>
		<td width="210">
		<p align="center">文件</td>
		<td width="210">
		<p align="center">上传者</td>
	</tr>
<%
  List onlist = (List)application.getAttribute("documentList");
  List onlistuser = (List)application.getAttribute("documentListuser"); 
 if(onlist==null){
	 onlist=new ArrayList();
	 application.setAttribute("documentList",onlist);
	}
 if(onlistuser==null){
	 onlistuser=new ArrayList();
	 application.setAttribute("documentListuser",onlistuser);
	}
 else
 {
 for(int i=0;i<onlist.size();)
 {
	 String s1=(String)onlist.get(i);
	 String s2=(String)onlistuser.get(i);
	 if(s1!=null||s2!=null){
	 if(i%2==0) out.print("<tr height=\"6\">");
	 out.print("<td width=210><p align=center><a href=Hjy?filename="+s1+">"+s1+"</a></p></td>");
	 out.print("<td width=\"210\"><p align=center>"+s2+"</p></td>");
      if(i%2==1) out.print("</tr>");
      i++;
	 }
 }
 out.print("</table></center>");
 }
%>
</body>
</html>