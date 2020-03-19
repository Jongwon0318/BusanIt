<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PersonList</title>
</head>
<body>
	<div align="center">
		<table>
			<tr>
				<th>
					ID
				</th>
				<th>
					NAME
				</th>
				<th>
					JOB
				</th>
				<th>
					GENDER
				</th>
				<th>
					Delete
				</th>
			</tr>
			<c:forEach items="${list }" var="user">
 				<tr>
					<td>
						<a href="personView.sp?id=${user.id }">${user.id }</a>
					</td>
					<td>
						${user.name }
					</td>
					<td>
						${user.job }
					</td>
					<td>
						${user.gender }
					</td>
					<td>
						<a href="personDelete.sp?id=${user.id }">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<input type="button"  value="등록" onclick="location.href='personForm.sp'">
	</div>
</body>
</html>