<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<title>Why are you late?</title>
</head>
<body>
	<div align="center">
		<h2>지각 횟수 </h2>
		<h2 id="count" style="color:red"></h2>
		<Button id="btn1" >I'm late</Button>
		<h2>남은 이용권 </h2>
		<h2 id="ticket" style="color:red"></h2>
		<hr>
		<br>
		<Button id="btn2">Chance!</Button>
		<h2>김창현 찬스</h2>
		<h2 id="chance" style="color:red"></h2>
	</div>
	
</body>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/66b8d2e32b.js" crossorigin="anonymous"></script>
    
    <script>
    	var latecount=0;
    	var ticket=11;
    	var chance=0;
    		
    	$("#count").text(latecount);
    	$("#ticket").text(ticket);
    	$("#chance").text(chance);
    	
    	$("#btn1").click(function(){
    		alert("왜 지각했어");
    		latecount+=1;
    		ticket-=1;
    		$("#count").text(latecount);
    		$("#ticket").text(ticket);
    	})
    	
    	$("#btn2").click(function(){
    		alert("택시비가 더 싼 김창현 찬스 획득!")
    		chance+=1;
    		$("#chance").text(chance);    		
    	})
    	
    </script>
</html>