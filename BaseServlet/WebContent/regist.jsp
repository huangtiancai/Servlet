<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 注册表单提交过程中上传文件错误返回信息 -->
	${uploadMessage}
	
	<!-- 注册表单内容 -->
	<form action="${pageContext.request.contextPath}/userServlet?method=regist" 
			method="post" 
			enctype="multipart/form-data">
  	          用户名<input type="text" name="username"><br>
  	  	密码<input type="password" name="pwd"><br>
  	 	头像<input type="file" name="files" /><br>
  	 	<input type="submit" value="注册" />
  	</form>
</body>
</html>