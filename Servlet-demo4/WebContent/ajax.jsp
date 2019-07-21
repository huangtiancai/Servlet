<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>原生的ajax(javascript中的ajax引擎工作原理)</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/regist.action" onsubmit="return validate()">
		<p>用户名：<input type="text" name="username" id="username" onblur="sendAjax()"><span id="userError"></span></p>
		<p>密码：<input type="password" name="userpwd"></p>
		<p><input type="submit" value="注册"></p>
	</form>
</body>
<script type="text/javascript">
	//想实现  在填写完用户名后实时验证该用户名是否可用？ajax
	//步骤：1.判断事件
	//    2.创建ajax对象
	//    3.设置服务器发送请求的参数
	//    4.发送请求
	//该方法为发送ajax异步请求的方法
	//声明一个变量用于接受XMLHttpRequest:浏览器内置对象，用于ajax引擎
	var xmlhttp;
	function createXMLRequest()
	{
		
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }

	}
	createXMLRequest();
	
	//alert(xmlhttp);
	//用户名是否可用   true--可用   false--不可用
	var isUser=false;
	//onblur 事件会在对象失去焦点时发生。Onblur 经常用于Javascript验证代码，一般用于表单输入框。
	function sendAjax()
	{
		//获取页面中的用户名
		var username = document.getElementById("username").value;
		//第一个参数：请求的方式：GET/POST
		//第二个参数：请求的地址：get方式，则参数要写地址中。post方式则放在send方法体中。
		//第三个参数：是否是异步的true--异步   false-同步
		xmlhttp.open("GET","${pageContext.request.contextPath }/checkUser.action?username="+username,true);
		xmlhttp.send();
		
		//接受响应
		xmlhttp.onreadystatechange=function(){
			 //alert(xmlhttp.readyState+"---"+xmlhttp.status);
			 if(xmlhttp.readyState==4 && xmlhttp.status==200)
				{
					//解析响应的信息
					var result = xmlhttp.responseText;
					
					//存在就是true  false-就是不存在
					if(result)
					{
						//alert("该用户已经注册过，用户名不可用");	
						alert(result);
						document.getElementById("userError").innerHTML="<font color='red'>该用户已经注册过，用户名不可用</font>";
						isUser=false;
					}else{
						//alert("该用户名可用");
						alert(result);
						document.getElementById("userError").innerHTML="<font color='green'>该用户名可用</font>";
						isUser=true;
					}
				} 
			
		}
		
	}
	
	function validate()
	{
		alert(isUser);
		//验证页面中的所有信息，有一个不通过的都不允许提交表单
		if(!isUser)
		{
			return false;
		}
		//其余的判断是一样的
		return true;
	}
</script>
</html>