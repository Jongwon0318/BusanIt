<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bbsForm2</title>
</head>
<body>
	<h1>글쓰기</h1>
	<form action="bbs2" method="post">
		이름 : <input type="text" name="name"><br>
		제목 : <input type="text" name="title"><br>
		<textarea rows="5" cols="20" name="content"></textarea><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>