<%@ page language="java" import="java.util.*" import="java.io.*" import="javax.servlet.http.*" import="javax.servlet.*" pageEncoding="utf-8" import="javax.swing.JButton"%>
<html><head><title>upFile</title></head>
<body bgcolor="#ffffff">
<%
//定义上载文件的最大字节
int MAX_SIZE = 102400 * 102400;
// 创建根路径的保存变量
String rootPath;
//声明文件读入类
DataInputStream in = null;
FileOutputStream fileOut = null;
//取得客户端的网络地址
String remoteAddr = request.getRemoteAddr();
//获得服务器的名字
String serverName = request.getServerName();

//取得互联网程序的绝对地址
//String realPath = request.getRealPath(serverName);
//realPath = realPath.substring(0,realPath.lastIndexOf("\\"));
//创建文件的保存目录
String Ph="D:/java/workspace1/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/document/";
rootPath = Ph + "\\qqtext1\\";
//取得客户端上传的数据类型
String contentType = request.getContentType();
try{
if(contentType.indexOf("multipart/form-data") >= 0){
//读入上传的数据
in = new DataInputStream(request.getInputStream());
int formDataLength = request.getContentLength();
if(formDataLength > MAX_SIZE){
response.getWriter().write("<script>alert('上传的文件字节数不能超过10M！!')</script>");

response.setHeader("Refresh","0;url=document.jsp");
}
//保存上传文件的数据
byte dataBytes[] = new byte[formDataLength];
int byteRead = 0;
int totalBytesRead = 0;
//上传的数据保存在byte数组
while(totalBytesRead < formDataLength){
byteRead = in.read(dataBytes,totalBytesRead,formDataLength);
totalBytesRead += byteRead;
}
//根据byte数组创建字符串
String file = new String(dataBytes);
//out.println(file);
//取得上传的数据的文件名
String saveFile = file.substring(file.indexOf("filename=\"") + 10);
saveFile = saveFile.substring(0,saveFile.indexOf("\n"));
saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
int lastIndex = contentType.lastIndexOf("=");
//取得数据的分隔字符串
String boundary = contentType.substring(lastIndex + 1,contentType.length());
//创建保存路径的文件名
String fileName = rootPath + saveFile;
//out.print(saveFile);
int pos;
pos = file.indexOf("filename=\"");
pos = file.indexOf("\n",pos) + 1;
pos = file.indexOf("\n",pos) + 1;
pos = file.indexOf("\n",pos) + 1;
int boundaryLocation = file.indexOf(boundary,pos) - 4;
//out.println(boundaryLocation);
//取得文件数据的开始的位置
int startPos = ((file.substring(0,pos)).getBytes()).length;
//out.println(startPos);
//取得文件数据的结束的位置
int endPos = ((file.substring(0,boundaryLocation)).getBytes()).length;
//out.println(endPos);
//检查上载文件是否存在
File checkFile = new File(fileName);
/* if(checkFile.exists()){


} */
//检查上载文件的目录是否存在
File fileDir = new File(rootPath);
if(!fileDir.exists()){
fileDir.mkdirs();
}
//创建文件的写出类
fileOut = new FileOutputStream(fileName);
//保存文件的数据
fileOut.write(dataBytes,startPos,(endPos - startPos));
fileOut.close();
response.getWriter().write("<script>alert('文件已上传！!')</script>");
application.setAttribute("document",saveFile);
String str=(String)session.getAttribute("user");
application.setAttribute("documentuser",str);
response.setHeader("Refresh","0;url=documentList.jsp");
}
else{
String content = request.getContentType();
response.getWriter().write("<script>alert('请上传.txt文件！!')</script>");
response.setHeader("Refresh","0;url=documentList.jsp");
}
}
catch(Exception ex){
	response.getWriter().write("<script>alert('请上传.txt文件！!')</script>");
	//application.setAttribute("document",null);
	//String str=(String)session.getAttribute("user");
	//application.setAttribute("documentuser",null);
	response.setHeader("Refresh","0;url=document.jsp");
}
%>
</body>
</html>