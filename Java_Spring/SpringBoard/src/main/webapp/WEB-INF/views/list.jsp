<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>List</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"></head>
	<style>
		<a
	</style>
</head>
<body>
	<div class="container">
	<br>
	<h1>게시판</h1>
	<br>
	<div align="right" class="mb-sm-3">
		<h5 class="display-5 mb-sm-3">게시글 수 : <span class="text-danger">${count }</span></h5>
		<input type="button" id="insert" value="글쓰기" class="btn btn-dark">
	</div>
	<table class="table table-stripped table-hover">
		<thead class="thead-dark text-center">
			<tr>
				<th>
					NO
				</th>
				<th>
					TITLE
				</th>
				<th>
					WRITER
				</th>
				<th>
					DATE
				</th>
				<th>
					HIT
				</th>	
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="board"  varStatus="st">
			<tr>
				<td width=100px align="center">
					${board.num }
				</td>
				<td width=350px>
					<a href="detail?num=${board.num }" class="text-dark">${board.title }</a>
				</td>
				<td width=60px align="center">
					${board.writer }
				</td>
				<td width=60px align="center">
					${board.regdate }
				</td>
				<td width=60px align="center">
					${board.hitcount }
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div align="center" class="text-dark">
		${pageHtml }
	</div>
	<div align="right">
		<form action="list">
			<select name="field" class="custom-select-sm">
				<option value="writer">작성자</option>
				<option value="title">제목</option>
			</select>		
			<input type="text" id="word" name="word" class="form-control-m">
			<input type="submit" class="btn-m btn-dark" value="검색">
		</form>
	</div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js" integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm" crossorigin="anonymous"></script>	
<script>
	$("#insert").click(function(){
		location.href="insert";
	})
</script>

</html>