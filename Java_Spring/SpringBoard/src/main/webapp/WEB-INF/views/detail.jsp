<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Detail</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"></head>
</head>
<body>
	<div class="container">
		<br>
		<h1>상세보기</h1>
		<br><br>
		<table class="table">
			<tr>
				<th>
					NO
				</th>
				<td>
					${detail.num }
				</td>
				<th>
					DATE
				</th>
				<td>
					${detail.regdate }					
				</td>
				<th>
					HIT
				</th>
				<td>
					${detail.hitcount }
				</td>
			</tr>
			<tr>
				<th>
					TITLE
				</th>
				<td colspan="3">
					${detail.title }
				</td>
				<th>
					WRITER
				</th>
				<td>
					${detail.writer }
				</td>
			</tr>
			<tr>
				<th>
					CONTENT
				</th>
				<td colspan="5">
					${detail.content }
				</td>
			</tr>
		</table>
		<br>
		<div align="right">
			<input class="btn btn-dark" type="button" value="Edit" id="edit">
			<input class="btn btn-dark" type="button" value="Delete" id="delete">
			<input class="btn btn-dark" type="button" value="List" id="list">
		</div>
		<hr>
	</div>
	<input type="hidden" id="num" value="${detail.num }">
</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js" integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm" crossorigin="anonymous"></script>	
<script>
	$("#list").click(function(){
		location.href="list";
	})
	
	$("#edit").click(function(){
		location.href="update?num=${detail.num }";
	})
	
	$("#delete").click(function(){
		window.open("delete","Delete","width=500,height=200");
	})
</script>
</html>