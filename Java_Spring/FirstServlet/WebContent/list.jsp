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
		<a href="memberInsert.jsp">등록하기</a>
	</div>
	<div align="center">
		<table>
			<tr align="center">
				<th>ID</th>
				<th>Name</th>
				<th>Addr</th>
				<th>Memo</th>
			</tr>
			<c:forEach var="item" items="${list }">
			<tr>
				<td>${item.id }</td>
				<td>${item.name }</td>
				<td>${item.addr }</td>
				<td>${item.memo }</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>