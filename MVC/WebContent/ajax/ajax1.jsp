<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
</head>
<body>
	<div><input type="search" id="search" placeholder="请输入关键字"></div>
	<div id="result">
		
	</div>
</body>
<script>
//ajax传递中文需要二次编码，后台解码
	$(function(){
		$("#search").blur(function(){
			//实时搜索
			$key = $(this).val();
			
			//发送异步请求
			/*  $.getJSON("${pageContext.request.contextPath }/topic.action",

					{"keyword":$key,"method":"getJson1"}, //区别：请求getJson2方法
					function(data){//json
						//alert(data)
						 if(data.length>0)
						{
							for(var i in data)
							{
								$div = $("<div class='topic'></div>");
								$span1 = $("<span>"+data[i].title+"</span>");
								$span2 = $("<span>"+data[i].content+"</span>");
								$span3 = $("<span>"+data[i].username+"</span>");
								$span4 = $("<span>"+data[i].publishTime+"</span>");
								
								$div.append($span1);
								$div.append($span2);
								$div.append($span3);
								$div.append($span4);
								
								$("#result").append($div);
								
							}
							
						} 
						
						
					}
					
			)  */

			
			
			//请求getJson2方法，跳转页面的方式
			$.get("${pageContext.request.contextPath }/topic.action",
					{"keyword":$key,"method":"getJson2"},
					function(data){
						$("#result").html(data);
			})
		})
		
	})
</script>
</html>