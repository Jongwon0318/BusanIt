<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl01</title>
</head>
<body>
	<%
		String str="hello";
		pageContext.setAttribute("name", "홍길동");
	%>
	<%=
		str
	%>
	<br>
	${name}
</body>
</html>