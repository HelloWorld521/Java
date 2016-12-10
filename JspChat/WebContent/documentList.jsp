<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
String str01=(String)application.getAttribute("document");
String str02=(String)application.getAttribute("documentuser");
List onlineDocumentList = (List)application.getAttribute("documentList");
List onlineDocumentUserList = (List)application.getAttribute("documentListuser");
if(onlineDocumentList == null){
	
	onlineDocumentList = new ArrayList();
	 application.setAttribute("documentList",onlineDocumentList);
}
if((onlineDocumentUserList==null))
{   onlineDocumentUserList = new ArrayList();
	 application.setAttribute("documentListuser",onlineDocumentUserList);
	}
onlineDocumentList.add(str01);
onlineDocumentUserList.add(str02);
application.setAttribute("documentList",onlineDocumentList);
application.setAttribute("documentListuser",onlineDocumentUserList);
response.setHeader("Refresh","0;url=document.jsp");
%>
</body>
</html>