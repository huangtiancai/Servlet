<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jspObject</title>
</head>
<body>

<%
//页面jsp2.jsp发生异常（int i = 1/0），会跳转500.jsp页面
//int i = 1/0;
%>

<%
String param = request.getParameter("param");
System.out.println(param);
%>

<!-- 脚本片段，即使分开书写，也能最终组合在一起 -->
<%
	if(param.equals("1")){
%>
	<h1><font color="red">参数1</font></h1>
<%
	}
%>

<%
	if(param.equals("2")){
%>
	<h1><font color="red">参数2</font></h1>
<%
	}
%>

<%
	if(param.equals("3")){
%>
	<h1><font color="red">参数3</font></h1>
<%
	}
%>


<%-- --%>
</body>
</html>