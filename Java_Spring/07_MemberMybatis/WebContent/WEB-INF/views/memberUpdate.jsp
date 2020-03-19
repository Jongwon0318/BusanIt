<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
	<div align="center"  id="div">
		<h3>회원정보수정</h3>
		<hr>
		<br>
		<form action="memberUpdate.mb" method="post" >
			<input type="hidden" name="id" id="id" value=${user.id }>
			<table>
				<tr>
					<th>
						비밀번호
					</th>
					<td>
						<input type="text"  value=${user.pass } id="pass" name="pass">
					</td>
				</tr>
				<tr>
					<th>
						아이디
					</th>
					<td>
						<input type="text"  value=${user.id } readonly>
					</td>
				</tr>
				<tr>
					<th>
						성명
					</th>
					<td>
						<input type="text" id="name" name="name" value=${user.name }>
					</td>
				</tr>
				<tr>
					<th>
						주소
					</th>
					<td>
						<input type="text" id="addr" size="50" name="addr"
						value=${user.addr }>
					</td>
				</tr>
				<tr>
					<th>
						메모
					</th>
					<td>
						<textarea rows="15" cols="50" id="memo" name="memo">${user.memo }</textarea>
					</td>
				</tr>
			</table>
		<br>
		<hr>
		<br>
		<input type="submit" value="수정">
		</form>
	</div>
</body>
</html>