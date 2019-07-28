<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
</head>
<body>
	${uploadMessage}
  	<form action="${pageContext.request.contextPath}/fileUploadServlet?method=upload" method="post" enctype="multipart/form-data">
  	 	<input type="file" name="files" /><br>
  	 	<input type="submit" value="提交" />
  	</form>
  	
  	
  	<p>
       <label for="">进度条:</label>
       <progress id="pro" max="1" value=""></progress>
    </p>
  	
  	<script type="text/javascript">
	  	//$(function(){
	  		//$("#btn").click(function(){
	  			//alert("1");
	  			//$.ajax({
	  				//type:'post',
	               // async:true,
	                //url:'${pageContext.request.contextPath}/fileUploadServlet',
	                //success:function(result,status,xhr){//请求成功后的回调函数
	                     //alert('数据：'+result+'\n状态：'+status+'\nxhr:'+xhr);
	                    // alert(result);
	                     //$("#pro").val(result);
	               // }	
	  			//})
	  		//});
	  	//})
  	</script>
</body>
</html>