<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
</head>
<body>
	<table>
		<tr>
			<td>ID</td>
			<td>${user.id }</td>
		</tr>
		<tr>
			<td>NAME</td>
			<td>${user.name }</td>
		</tr>
		<tr>
			<td>ADDRESS</td>
			<td>${user.addr }</td>
		</tr>
		<tr>
			<td>MEMO</td>
			<td>${user.memo }</td>
		</tr>
		<tr>
			<td>
				<input type="button" value="수정하기"
				onclick="location.href='memberFormUpdate.me?id=${user.id }'">
				<input type="button" value="목록보기"
				onclick="location.href='memberList.me'">
			</td>
		</tr>
	</table>
</body>
</html>