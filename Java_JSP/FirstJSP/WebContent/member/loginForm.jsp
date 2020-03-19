<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="member.js"></script>
</head>

<body>
	<div align="center">
	<h1>로그인</h1>
	<form id="frm" method="post" action="loginPro.jsp">
		<table style="padding-bottom : 20px">
			<tr>
				<td align="center">
					아이디
				</td>
				<td style="padding-left : 10px">
					<input type="text" name="userid1" id="userid1" >
				</td>
			</tr>
			<tr>
				<td align="center">
					비밀번호
				</td>
				<td style="padding-left : 10px">
					<input type="password" name="pwd1" id="pwd1">
				</td>
			</tr>		
		</table>
			<input type="button" id="loginBtn" value="로그인"> 
			<input type="button" id="signUpBtn" value="회원가입">
			<!-- input에 onclick을 선언하여 바로 넘어가게 만들 수 있음 -->
	</form>
	</div>
</body>
</html>