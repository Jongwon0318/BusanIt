<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>SignUpPage</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="member.js"></script>
</head>

<body>

	<div align="center">

	<h1>
		회원가입
	</h1>
	<span>'*'표시 항목은 필수 입력 항목입니다.</span>
	<br><br>
	
	<form id="frm" method="post" action="memberPro.jsp">
		<table>
			<tr>
				<td width=100px align=center>
					이름
				</td>
				<td>
					<input type="text" name="name" id="name" width=100px>*
				</td>
			</tr>
			<tr>
				<td width=100px align=center>
					아이디
				</td>
				<td>
					<input type="text" name="vid" id="vid" width=100px disabled>*
				</td>
				<td>
					<input type="hidden" name="userid" id="userid" size="20">
					<input type="button" value="중복 체크" id="idBtn">
				</td>
			</tr>
			<tr>
				<td width=100px align=center>
					암호
				</td>
				<td>
					<input type="password" name="pwd" id="pwd" width=100px>*
				</td>
			</tr>
			<tr>
				<td width=100px align=center>
					암호확인
				</td>
				<td>
					<input type="password" name="pwd_check" id="pwd_check" width=100px>*
				</td>
			</tr>
			<tr>
				<td width=100px align=center>
					이메일
				</td>
				<td>
					<input type="email" name="email" id="email" width=100px>
				</td>
			</tr>
			<tr>
				<td width=100px align=center>
					전화번호
				</td>
				<td>
					<input type="text" name="phone" id="phone" width=100px>
				</td>
			</tr>
			<tr>
				<td width=100px align=center>
					등급
				</td>
				<td>
					<input type="radio" name="admin" value="0" checked="checked">일반회원
					<input type="radio" name="admin" value="1">관리자
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td height="50px">
					&nbsp;&nbsp;&nbsp;
					<input type="button" value="확인" id="send">&nbsp;&nbsp;
					<input type="button" value="로그인 화면" id="back" >
				</td>
			</tr>
		</table>
	</form>
	</div>
	
</body>
</html>