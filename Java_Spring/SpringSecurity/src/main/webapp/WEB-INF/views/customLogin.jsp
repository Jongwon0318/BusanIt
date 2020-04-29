<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Custom Login Page</h1>
	<h2><c:out value="${error }"/></h2>
	<h2><c:out value="${logout }"/></h2>
	<!-- action이름은 항상 /security/login 이어야 함. (바꾸면 안됨) -->
	<form role="form" action="/security/login" method="post">
		<div>
			<!-- userId 가 아니라 username으로 써야 SpringSecurity 가 인식할 수 있다. -->
			<input name="username" type="text">
		</div>
		<div>
			<input name="password" type="password">
		</div>
		<div>
			<input type="checkbox" name="remember-me">Remember Me
		</div>
		<div>
			<input type="submit">
		</div>
		<!-- 위조 방지(기본값) -->
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
	</form>
</body>
</html>