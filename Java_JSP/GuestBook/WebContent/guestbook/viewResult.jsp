<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table align="center" border="1">
	<tr>
		<th width="100px">NO</th>
		<td width="300px">${gdto.num }</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${gdto.name }</td>
	</tr>
	<tr>
	<th>내용</th>
	<td>${gdto.content }</td>
	</tr>
	<tr>
	<th>평가</th>
	<td>${gdto.grade }</td>
	</tr>
	<tr>
	<th>날짜</th>
	<td>${gdto.created }</td>
	</tr>
	<tr>
	<th>IP주소</th>
	<td>${gdto.ipaddr }</td>
	</tr>

</table>