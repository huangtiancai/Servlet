<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ page import="java.util.Date,java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp的三种脚本</title>
</head>
<body>

<!-- 
jsp技术最终还是用java类，执行网页内容，jsp说到底还是一个Servlet.
既然是servlet，那么必然可以书写java代码;
因此，JSP中提供了书写java代码的三种定义格式：（为了区别页面上的html代码）



-->

<h3>脚本声明 </h3>
<%!
	int x = 5;
	//在生成的java代码中申明成员变量和成员方法
	public void method(){
		
	}
	String str = "abc";
%>


<!-- 
2.脚本表达式： 将java的表达式的结果输出到页面 通过out.print方法
可以将数据输出到页面-代码翻译在_jspService方法中，而且，被输出流输出
-->

<h3>脚本表达式</h3>
x=<%=x+10 %>
</br>
今天的日期是: <%= (new java.util.Date()).toLocaleString()%>
</br>

<h3>脚本片段</h3>
<%
++x;
System.out.println("x:"+x);//打印在控制台
%>
<%	
	//这里是java小脚本，生成java类时，不做任何翻译。  定义的所有的变量都是局部变量。存在于_jspService方法中
	out.write("这是脚本片段！");
	int y =10;
	System.out.println("y:"+y);//打印在控制台
%>

<h3>当前服务器系统时间</h3>
<%
	Date date = new Date();
	SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	String dateStr = format.format(date);
%>
<h3>时间date为:<%=date%></h3>
<h3>时间dateStr为:<%=dateStr%></h3>
</br>

</body>
</html>