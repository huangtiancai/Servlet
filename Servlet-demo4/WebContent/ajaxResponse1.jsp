<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax</title>
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
			$.get(
				"${pageContext.request.contextPath}/findTopic.action",
				{"boardId":$obj.html()},
				function(data){
					alert(data);
					$obj.next().html(data);
				},
				"html"
			);
			console.log("test");
		});
	})
</script>
</html>