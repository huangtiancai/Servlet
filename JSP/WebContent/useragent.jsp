<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.StringTokenizer" %>
<%@ page import="java.net.InetAddress" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserAgent分析</title>

<!-- 引入网站地址栏头像favicon:Favorites Icon -->
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
</head>

<body>
当前时间: <%= (new java.util.Date()).toLocaleString()%>
</br>

<%
	String ua = request.getHeader("User-Agent");
    out.println("您的UserAgent : "+ua); 
	

%>
</br>

<%
	StringTokenizer st = new StringTokenizer(ua,";");

%>


</br>
<!-- 注意：
	  	0:0:0:0:0:0:0:1是ipv6的表现形式，对应ipv4来说相当于127.0.0.1，这两个都代表本机
	  	0:0:0:0:0:0:0:1-ipv6
	  	127.0.0.1      -ipv4
	  	
	  	客户端和服务器在同一台电脑上（java项目部署在本机）才会出现（例如用localhost访问的时候才会出现），用getRemoteAddr()获得的IP为0:0:0:0:0:0:0:1
	  	本机访问的时候用127.0.0.1或本机ip:172.30.32.67代替localhost即可解决
	  	http://localhost:8080/JSP/useragent.jsp    - 获取的 主机地址:0:0:0:0:0:0:0:1  0:0:0:0:0:0:0:1 
	  	http://127.0.0.1:8080/JSP/useragent.jsp    - 获取的 主机地址:172.30.32.67     ip:127.0.0.1
	  	http://172.30.32.67:8080/JSP/useragent.jsp - 获取的 主机地址:172.30.32.67     ip:172.30.32.67
	    
	            注意：
	        172.30.32.67是内网IP地址，由路由器或者调制解调器直接分配
	        153.37.197.2外网IP地址，由网络供应商直接分配
-->

<%
	InetAddress addr = InetAddress.getLocalHost();
	out.println("你的主机名:"+addr.getHostName());
%>
</br>
<%
	out.println("你的主机地址:"+addr.getHostAddress());
%>
</br>

<%	
	out.println("你的IP地址为:"+request.getRemoteAddr());
%>
</br>

<%	
	if(request.getHeader("x-forwarded-for") == null){ 
		out.println("您的真实的IP地址为:"+request.getRemoteAddr());
	 }
	else{
		out.println("您的真实的IP地址为:"+request.getHeader("x-forwarded-for"));	
	}
	 
%>




</body>
</html>