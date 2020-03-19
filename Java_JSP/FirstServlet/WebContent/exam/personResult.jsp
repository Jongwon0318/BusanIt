<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>personResult</title>
</head>
<body>
	PERSON 결과화면<br><br><hr><br>
	이름 : ${ps.name }<br>
	아이디 : ${ps.userid }<br>
	성별 : ${ps.gender }<br>
	메일수신여부 : 
	<c:forEach items="${ps.notice }" var="nt" varStatus="st">
		${nt }
		<c:if test="${not st.last }">
			, 
		</c:if>
	</c:forEach><br>
	직업 : ${ps.job }<br>
</body>
</html>