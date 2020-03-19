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
				$("#result").load("jquery.jsp" ,function(data,stu){
					if(stu=="success"){
						$("#result").html(data+"<b>성공입니다.!!!</b>")
					}else{
						alert("실패");
					}
				}); //load
			}); //click
		}); //document
	</script>
</head>
<body>
	<button id="btn">결과</button><br><br>
	<div id="result"></div>
</body>
</html>