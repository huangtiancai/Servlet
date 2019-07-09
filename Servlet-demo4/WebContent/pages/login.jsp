<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<!-- 引入网站地址栏头像favicon:Favorites Icon -->
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<style>
   table {
       /*table-layout: fixed;*/
       width: 450px;
       height: 300px;
       border: 1px solid black;
       border-collapse:collapse;
       margin-left: 700px;
       margin-top: 150px;
   }
   th{
   	   margin-left: 10px;

   }
</style>

</head>
<body>
<!-- 对于提交上了的用户名，爱好，我们必须获取后，才能处理，那么请求参数如何获取？
	   使用服务器给我提供的一个对象Request对象
 -->
 
 <!--      
 	   http://localhost:8080/Servlet-demo2/pages/login.html 访问表单页面
 	   
 	   1.action="/Servlet-demo2/loginServlet"
 	   2.表单参数  
 
 	         表单提交时通过url-pattern，访问指定的LoginServlet，同时表单参数会追加到url后
 	         
 	   例如：http://localhost:8080/Servlet-demo2/loginServlet?username=jack&password=1234&登录=提交
 -->


<form action="/Servlet-demo3/loginServlet" method="post"> 
      <table>
          <tr>
              <th>用户名:</td>
              <td><input type="text" name="username"/></td>
          </tr>
          <tr>
              <th>密码:</td>
              <td><input type="password" name="password"/></td>
          </tr>
         <tr>
         	 <th>验证码:</td>
         	 <td>
         	 	<input type="text" name="vcode" placeholder="请输入验证码" > 	
              </td>
              <td>
              	<img title="点击图片切换验证码" id="vcodeImg" src="../cpachaServlet?method=loginCapcha">
            	<a href="javascript:;" onclick="changeCode();">换一换</a>
              </td>
         </tr>
 
          <tr>
              <th></td>
              <td><input type="submit" name="登录"/></td>              
          </tr>			
      </table>
</form>
	<!-- 
		http://localhost:8080/Servlet-demo3/cpachaServlet?method=loginCapcha 返回一张图片
		<img title="点击图片切换验证码" id="vcodeImg" src="../cpachaServlet?method=loginCapcha">
	 -->

	<script type="text/javascript">
		function changeCode(){
			document.getElementById("vcodeImg").src="../cpachaServlet?method=loginCapcha&t="+new Date().getTime();	
		}
	</script>

	
</body>
</html>