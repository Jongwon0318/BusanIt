<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addrList</title>
</head>
<body>
	<div align="right">
	<form action="search.do">
		<table>
			<tr>
				<th>
					<select name="option">
						<option value="addr">주소</option>
						<option value="name">이름</option>
						<option  value="tel">전화번호</option>
					</select>
				</th>
				<td>
					&nbsp;<input type="text" name="addr" id="addr">&nbsp;&nbsp;
				</td>
				<td>
					<input type="submit"  id="searchBtn" value="검색하기" >
				</td>
			</tr>
			</table>
		</form>
	</div>
	<hr>
	<br>
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>우편번호</th>
			<th>주소</th>
			<th>전화번호</th>
		</tr>
	<c:forEach items="${arrList }" var="addr" varStatus="st">
		<tr>
			<td>${addr.num }</td>
			<td><a href="view.do?num=${addr.num }">${addr.name }</a></td>
			<td>${addr.zipcode }</td>
			<td>${addr.addr }</td>
			<td>${addr.tel }</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>