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
			<c:forEach items="${list }" var="person">
 				<tr>
					<td>
						<a href="pDetail.mb?id=${person.id }">${person.id }</a>
					</td>
					<td>
						${person.name }
					</td>
					<td>
						${person.job }
					</td>
					<td>
						${person.gender }
					</td>
					<td>
						<a href="pDelete.mb?id=${person.id }">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<input type="button"  value="등록" onclick="location.href='pInsert.mb'">
	</div>
</body>
</html>