<%@page import="com.exam.ScoreBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	
	int kor = Integer.parseInt(request.getParameter("kor"));
	
	int math = Integer.parseInt(request.getParameter("math"));
	
	int eng = Integer.parseInt(request.getParameter("eng"));
	ScoreBean sb=new ScoreBean();
	sb.setName(name);
	sb.setKor(kor);
	sb.setMath(math);
	sb.setEng(eng);
%>

<body>
	이름 : <%=sb.getName() %><br>
	국어 : <%=sb.getKor() %><br>
	수학 : <%=sb.getMath() %><br>
	영어 : <%=sb.getEng() %><br>
	총점 : <%=sb.getTotal() %><br>
	평균 : <%=sb.getAvg() %><br>
	학점 : <%=sb.getGrade() %>
</body>
</html>