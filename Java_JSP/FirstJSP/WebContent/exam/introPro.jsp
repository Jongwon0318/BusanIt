<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>introPro</title>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String[] play=request.getParameterValues("play");
	String strPlay="";
	for(int i=0; i<play.length; i++){
		strPlay+=play[i]+"\t";
	}
	String[] program=request.getParameterValues("avail");
	String strPgm="";
	for(int i=0; i<program.length; i++){
		strPgm+=program[i]+"\t";
	}
%>
<body>
이름 : <%=request.getParameter("name") %><br>
성별 : <%=request.getParameter("gender") %><br>
생일 : <%=request.getParameter("year") %>-<%=request.getParameter("month") %>-<%=request.getParameter("day") %><br>
주소 : <%=request.getParameter("addr") %><br>
전화번호 : <%=request.getParameter("tel1") %>-<%=request.getParameter("tel2") %>-<%=request.getParameter("tel3") %><br>
프로그램 : <%=strPgm %><br>
여행지 : <%=strPlay %><br>
메모 : <%=request.getParameter("memo") %>
</body>
</html>