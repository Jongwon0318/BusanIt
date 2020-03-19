<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<div align="center" id="result">
		게시물 수 : ${count }
		<table>
			<tr>
				<th>이름</th>
				<th>내용</th>
				<th>등급</th>
				<th>날짜</th>
				<th>IP주소</th>
				<c:if test="${login!=null }">
					<th>삭제</th>
				</c:if>
			</tr>
			<c:forEach items="${guestlist}" var="gl" >
				<tr>
					<td>${gl.name }</td>
					<td><a href="javascript:fView(${gl.num })">${gl.content }</a></td>
					<td>${gl.grade }</td>
					<td>${gl.created }</td>
					<td>${gl.ipaddr }</td>
					<c:if test="${login!=null }">
						<td>
							<a href="javascript:fDelete(${gl.num },'${gl.name }')">
								삭제
							</a>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
		<!-- 페이지 처리기능 추가 -->
		<div align="center">
			${pageHtml }
		</div>
	</div>
</body>

</html>