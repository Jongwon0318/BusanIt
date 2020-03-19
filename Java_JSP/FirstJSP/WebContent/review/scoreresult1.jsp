<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	int tot=Integer.parseInt(request.getParameter("eng"))+Integer.parseInt(request.getParameter("kor"))
	+Integer.parseInt(request.getParameter("math"));
	int avg=tot/3;
	String grade="";
	if(avg>=90){
		grade="A";
	}else if(avg>=80){
		grade="B";
	}else if(avg>=70){
		grade="C";
	}else{
		grade="F";
	}
%>
<body>
이름 : <%=request.getParameter("name") %><br>
국어 : <%=request.getParameter("kor") %><br>
수학 : <%=request.getParameter("math") %><br>
영어 : <%=request.getParameter("eng") %><br>
총점 : <%=tot %><br>
평균 : <%=avg %><br>
학점 : <%=grade %>
</body>
</html>