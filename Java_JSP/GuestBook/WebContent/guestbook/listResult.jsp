<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">총 게시물 수 : ${count }</div>
<br><br>
<table align="center" width="580px">
	<tr>
		<th>NO</th>
		<th>이름</th>
		<th>내용</th>
		<th>평가</th>
		<th>날짜</th>
		<th>IP주소</th>
	</tr>
	<c:forEach items="${lists }" var="vr" varStatus="st">
		<tr align="center">
			<td>${vr.num}</td>
			<td><a href="javascript:fview(${vr.num })">${vr.name}</a></td>
			<td>${vr.content}</td>
			<td>${vr.grade}</td>
			<td>${vr.created}</td>
			<td>${vr.ipaddr}</td>
		</tr>
	</c:forEach>
</table>
