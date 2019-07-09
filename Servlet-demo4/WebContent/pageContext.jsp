<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ page import="java.util.Date,java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP内置对象—PageContext使用</title> 
</head>
<body>

<%--获取其他八个内置对象的方法 --%>
<%=pageContext.getPage() %></br>
<%=pageContext.getRequest() %></br>
<%=pageContext.getResponse() %></br>
<%=pageContext.getSession() %></br>
<%=pageContext.getServletContext() %></br>
<%=pageContext.getServletConfig() %></br>
<%=pageContext.getOut() %></br>
<%=pageContext.getException() %></br>

<%--给其他4个域对象(page request session application )中的设置数据 --%>
存数据</br>
<%
pageContext.setAttribute("addr", "北京", pageContext.PAGE_SCOPE);
pageContext.setAttribute("addr", "上海", pageContext.REQUEST_SCOPE);
pageContext.setAttribute("addr", "深圳", pageContext.SESSION_SCOPE);
pageContext.setAttribute("addr", "广州", pageContext.APPLICATION_SCOPE);
%> 


取出数据 </br>
<%=pageContext.getAttribute("addr", pageContext.PAGE_SCOPE)%> </br>
<%=pageContext.getAttribute("addr", pageContext.REQUEST_SCOPE)%> </br>
<%=pageContext.getAttribute("addr", pageContext.SESSION_SCOPE)%> </br>
<%=pageContext.getAttribute("addr", pageContext.APPLICATION_SCOPE)%> </br>


</br>

获取项目根路径</br>
<%=request.hashCode()%></br>
<%=pageContext.getRequest().hashCode()%></br>

<%=request.getContextPath()%></br>
${pageContext.request.contextPath}


</body>
</html>