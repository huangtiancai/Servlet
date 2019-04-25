<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.net.InetAddress" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.println("this is printed by out.println");
	System.out.println("this is printed by System.out.println");
%>
</br>

<%
	InetAddress addr = InetAddress.getLocalHost();
	out.println("你的主机地址:"+addr.getHostAddress());
	out.println("你的主机名:"+addr.getHostName());
%>

</br>

今天的日期是: <%= (new java.util.Date()).toLocaleString()%>


</body>
</html>