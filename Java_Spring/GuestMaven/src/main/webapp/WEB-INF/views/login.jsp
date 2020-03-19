<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>LOGIN</title>
</head>
<body>
	<div align="center">
		방명록 주인장만 사용할 수 있는 페이지입니다.
		<br><br>
		<a href="gInsert">[홈으로 돌아가기]</a>
		<br><br>
		<form action="login" method="post">
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" id="id" name="id"></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="password" id="pwd" name="pwd"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<span style="color:red">${errMsg }</span>
					</td>
				</tr>
			</table>
			<input type="submit" value="로그인">
		</form>
	</div>
</body>

</html>