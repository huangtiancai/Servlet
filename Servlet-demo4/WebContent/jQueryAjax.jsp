<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jquery的Ajax</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
</head>
<body>
	<h1 class="boardId">9</h1>
	<div class="result"></div>
	
	<h1 class="boardId">10</h1>
	<div class="result"></div>
</body>
<script type="text/javascript">
	$(function(){
		$(".boardId").click(function(){
			var $obj = $(this);
			alert($obj.html());
			alert(typeof($obj.html()));
			$.ajax({
				type:"Get",
				url:"${pageContext.request.contextPath}/findTopic.action",
				data:{"boardId":$obj.html()},
				dataType:"html",
				succsee:function(data){
					alert("data:"+data);
					$obj.next().html(data);
				},
				error:function(xhr,msg,ex){
					alert(xhr+"--"+msg+"--"+ex);
				}
			});
			
		});
	})
</script>
</html>