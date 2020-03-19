<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PersonList</title>
</head>
<body>
	<div align="right">
		<p>총 사람 수 : ${count }</p>
		<a href="/person">메인으로</a> <a href="pInsert">등록화면</a>
	</div>
	<div align="left">
		<form action="pList">
			<select name="field">
				<option>선택하세요</option>
				<option value="name">이름</option>
				<option value="job">직업</option>
			</select> <input type="text" name="word"> <input type="submit"
				value="검색">
		</form>
	</div>
	<div align="center">
		<table>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>JOB</th>
				<th>GENDER</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${list }" var="person" varStatus="status">
				<tr>
					<td><a href="pView?id=${person.id }">${person.id }</a></td>
					<td>${person.name }</td>
					<td>${person.job }</td>
					<td>${person.gender }</td>
					<td><a href="pDelete?id=${person.id }">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div align="center">
		
	</div>


</body>
</html>