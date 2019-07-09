<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 使用标签代替java代码，使用这些标签需要使用taglib指令来引入标签库 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>taglib指令</title>
</head>
<body>
<%--
   1.c:if 条件判断
   2.c:choose
   3.c:forEach
   4.c:set
   5.c:out       
 --%>
 <c:out value="taglib指令-c:out"></c:out>
 <c:catch></c:catch>
 <c:if test=""></c:if>
 <c:choose></c:choose>


 <%
    session.setAttribute("loginUser", "admin");   
    session.setAttribute("score", 50);
 %>

<%--

 <h1>多重条件结构</h1>
  <c:if test="${not empity loginUser}">
      ${loginUser}
  </c:if>
  <c:if test="${empity loginUser} }">
      <p>游客</p>
  </c:if> 

 --%>
</body>
</html>