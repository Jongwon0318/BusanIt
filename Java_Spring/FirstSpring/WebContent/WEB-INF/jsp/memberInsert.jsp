<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberInsert</title>
<style>
	#div{
		width:600px;
	}
	table th{
		text-align:center;
	}
</style>
</head>
<body>
	<div align="right">
		<a href="index.jsp">메인으로</a>
		<a href="member_list.do">목록보기</a>
	</div>
	<div align="center"  id="div">
		<h3>회원가입</h3>
		<hr>
		<br>
		<form action="member_insert.do" method="post" name="form1">
			<table>
				<tr>
					<th>
						아이디
					</th>
					<td>
						<input type="text" id="id" name="id">
					</td>
				</tr>
				<tr>
					<th>
						비밀번호
					</th>
					<td>
						<input type="password" id="pass" name="pass">
					</td>
				</tr>
				<tr>
					<th>
						성명
					</th>
					<td>
						<input type="text" id="name" name="name">
					</td>
				</tr>
				<tr>
					<th>
						주소
					</th>
					<td>
						<input type="text" id="addr" size="50" name="addr">
					</td>
				</tr>
				<tr>
					<th>
						메모
					</th>
					<td>
						<textarea rows="15" cols="50" id="memo" name="memo"></textarea>
					</td>
				</tr>
			</table>
		<br>
		<hr>
		<br>
		<input type="submit" value="가입">
		</form>
	</div>
</body>
</html>