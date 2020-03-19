<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>addrView</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
		$(function(){
			$("#delBtn").click(function(){
				//정말삭제할까요? yes->delete.do
				if(confirm("정말삭제할까요?")){
					location.href="delete.do?delnum=${adto.num }";
				}
			});
		})
	</script>
</head>
<body>
	<form action="update.do">
		<table>
				<tr>
					<th>
						번호
					</th>
					<td>
						<input type="text" value="${adto.num }" disabled="disabled">
						<input type="hidden" value="${adto.num }" name="num">
					</td>
				</tr>
				<tr>
					<th>
						이름
					</th>
					<td>
						<input type="text" name="name" value="${adto.name }">
					</td>
				</tr>
				<tr>
					<th>
						우편번호
					</th>
					<td>
						<input type="text" name="zipcode" value="${adto.zipcode }">
					</td>
				</tr>
				<tr>
					<th>
						주소
					</th>
					<td>
						<input type="text" name="addr" value="${adto.addr }">
					</td>
				</tr>
				<tr>
					<th>
						전화번호
					</th>
					<td>
						<input type="text" name="tel" value="${adto.tel }">
					</td>
				</tr>
		</table>
		<input type="submit" value="수정하기">&nbsp;
		<input type="button" id="delBtn" value="삭제하기">&nbsp;
		<a href="list.do">리스트로 돌아가기</a>&nbsp;
		</form>
</body>
</html>