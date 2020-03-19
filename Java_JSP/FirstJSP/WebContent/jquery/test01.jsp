<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>test01</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

	<script>
		$(function() {
		
			$("#loadbtn").click(function() {
				$("#result").load("test01Result.jsp",
						{"id":$("#id").val(), "pwd":$("#pwd").val(), "method":"load"},
						function(data){
							$("#result").html(data);
				})
			})
		
			$("#b2").click(function() {
				$.get("test01Result.jsp",
						{"id":$("#id").val(), "pwd":$("#pwd").val(), "method":"get"},
						function(data){
							$("#result").html(data);
				})
			})
		
			$("#postbtn").click(function() {
				$.post("test01Result.jsp",
						{"id":$("#id").val(), "pwd":$("#pwd").val(), "method":"post"},
						function(data){
							$("#result").html(data);
				})
			})
		
			$("#ajaxbtn").click(function(){
				$.ajax({
					type : "POST",
					url : "test01Result.jsp",
					data : {"id":$("#id").val(), "pwd":$("#pwd").val(), "method":"ajax-post"},
					success : function(d){
						$("#result").html(d);
					},
					error : function(e){
						alert("error"+e);
					}
				});
			})
		
			$("#ajaxbtn1").click(function(){
				$.ajax({
					type : "GET",
					url : "test01Result.jsp",
					data : {"id":$("#id").val(), "pwd":$("#pwd").val(), "method":"ajax-get"},
					success : function(d){
						$("#result").html(d);
					},
					error : function(e){
						alert("error"+e);
					}
				});
			})
		})
	</script>
</head>
<body>
	<form action="test01Result.jsp" name="frm" method="post">
		id : <input type="text" id="id" name="id"><br> 
		pwd : <input type="password" id="pwd" name="pwd"><br>
		<input type="button" id="loadbtn" value="load전송"><br> 
		<input type="button" id="b2" value="get전송"><br>
		<input type="button" id="postbtn" value="post전송"><br>
		<input type="button" id="ajaxbtn" value="ajax-post전송"><br>
		<input type="button" id="ajaxbtn1" value="ajax-get전송"><br>
		<br>
	</form>
	<div id="result">	</div>
</body>
</html>