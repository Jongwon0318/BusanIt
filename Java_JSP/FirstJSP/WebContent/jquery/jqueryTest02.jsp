<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>jqueryTest</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
		$(function(){
			$("#btn").click(function(){
				//jqueryResult.jsp?name=load방식 & status=ajaxload 방식
				/*$("#result").load( 
						"jqueryResult.jsp", 
						{"name" : "load방식","status":"ajaxload 방식"}, 
						function(str){
							alert(str);
							$("#result").html(str);
				}); //load*/
				
				//get방식
				/*$.get("jqueryResult.jsp",
						{"name" : "get방식","status":"ajaxload 방식"},
						function(str){
							alert(str);
							$("#result").html(str);
				}) //$.get*/
				
				//post방식
				/*$.post("jqueryResult.jsp",
						{"name" : "post방식","status":"ajaxload 방식"},
						function(str){
							$("#result").html(str);
				})//$.post*/
				//ajax-post방식
				$.ajax({
					type : "POST",
					url : "jqueryResult.jsp",
					data : {"name" : "ajax방식","status":"ajax 방식"},
					success : function(d){
						$("#result").html(d);
					},
					error : function(e){
						alert("error"+e);
					}
				});//$.ajax
			}) //click
		}); //document
	</script>
</head>
<body>
	<button id="btn">결과</button><br><br>
	<div id="result"></div>
</body>
</html>