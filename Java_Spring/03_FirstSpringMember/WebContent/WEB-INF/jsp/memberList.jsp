<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
	<div align="right">
		<a href="index.jsp">메인으로</a>
		<a href="memberFormInsert.me">등록화면</a>
	</div>
	<div align="center">
		<table>
			<tr align="center">
				<th>ID</th>
				<th>Name</th>
				<th>Addr</th>
				<th>Memo</th>
				<th>삭제하기</th>
			</tr>
			<c:forEach var="item" items="${list }">
			<tr>
				<td>${item.id }</td>
				<td><a href="memberView.me?id=${item.id }">${item.name }</a></td>
				<td>${item.addr }</td>
				<td>${item.memo }</td>
				<td><input type="button" value="삭제" onclick="location.href='memberDelete.me?id=${item.id }'"></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>