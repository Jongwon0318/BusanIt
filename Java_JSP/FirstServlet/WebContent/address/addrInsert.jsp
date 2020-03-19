<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>addrInsert</title>
	<script>
		function zipfinder(){
			window.open("zip.do","","width=900 height=400");
		}
	</script>
	</head>
<body>
	<form action="insert.do" method="post" >
			<div align="right"><a href="list.do">전체보기</a></div>
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
					<td><input type="text" name="zip" id="zip"
						> <input type="button" value="검색"
						onclick="zipfinder()"></td>
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
					<td colspan="2"><input type="submit" value="등록" id="#btn"
						> <input type="reset" value="취소"></td>
				</tr>
		</table>
	</form>
</body>
</html>