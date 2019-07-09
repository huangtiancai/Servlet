<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ page import="java.util.Date,java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP内置对象—out的使用</title> 
</head>
<body>
<!-- out它主要是用来把数据输出到页面（相当于response.getWriter()） -->
<% out.write("haha"); %><br>
<% response.getWriter().write("heihei<br>"); %><br>
<% out.write("haha"); %><br>
</body>
</html>