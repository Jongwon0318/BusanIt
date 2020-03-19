<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	function zipfinder() {
		window.open("zipCheck.jsp", "", "width=700 height=400");
	}
//$(document).ready(function() {
	$(function() {
		$("#btn").click(function() {
			if ($("#name").val() == "") {
				alert("이름을 입력하세요");
				return;
			}
			if ($("#zip").val() == "") {
				alert("우편번호를 입력하세요");
				return;
			}
			if ($("#addr").val() == "") {
				alert("주소를 입력하세요");
				return;
			}
			if ($("#tel").val() == "") {
				alert("전화번호를 입력하세요");
				return;
			}
			frm.submit();
		})
	})
</script>
</head>
<body>
	<form action="insertPro.jsp" method="post" name="frm" id="frm">
		<input type="hidden" name="zipcode" id="zipcode"> <a
			href="list.jsp">전체보기</a>
		<table border="6">
			<tr>
				<th colspan="2">주소록 등록하기</th>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td><input type="text" name="zip" id="zip" disabled="disabled">
					<input type="button" value="검색" onclick="zipfinder()"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" id="addr" size=50></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="tel" id="tel"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="등록" id="btn">
					<input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>