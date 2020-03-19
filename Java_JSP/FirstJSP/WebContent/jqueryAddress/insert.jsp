<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
		$(function(){
			$("#sendBtn").click(function(){
				$("#frm").submit();
			})
			
			$("#zipBtn").click(function(){
				window.open("zipCheck.jsp","","width=900, height=500");
			})
		})
	</script>
</head>
<body>
	<div align="right">
		<a href="list.jsp">전체보기</a>
	</div>
	<div align="center">
	<form action="insertPro.jsp" method="post" name="frm" id="frm">
		<!-- <input type="hidden" name="zipcode" id="zipcode"> -->
		<table border="6">
			<tr>
				<th colspan="2">주소록 등록하기</th>
			</tr>
			<tr>
				<td align="center">
					이름
				</td>
				<td>
					<input type="text" name="name" id="name"  size=30>
				</td>
			</tr>
			<tr>
				<td align="center">
					우편번호
				</td>
				<td>
					<input type="text" name="zipcode" id="zipcode"  size=30> 
					<input type="button" value="검색" id="zipBtn">
				</td>
			</tr>
			<tr>
				<td align="center">
					주소
				</td>
				<td>
					<input type="text" name="addr" id="addr" size=50>
				</td>
			</tr>
			<tr>
				<td align="center" width=100px>
					전화번호
				</td>
				<td>
					<input type="text" name="tel" id="tel" size=50>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="등록" id="sendBtn">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>