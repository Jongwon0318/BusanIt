<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String name = request.getParameter("name");
	
	int kor = Integer.parseInt(request.getParameter("kor"));
	
	int math = Integer.parseInt(request.getParameter("math"));
	
	int eng = Integer.parseInt(request.getParameter("eng"));
	
	int avg=(kor+math+eng)/3;
	
	int tot=kor+math+eng;
	
	String grade="";
	
	if(avg>=90){
		grade="A";
	}else	if(avg>=80){
		grade="B";
	}else	if(avg>=70){
		grade="C";
	}else{
		grade="F";
	}
	
	switch(avg/10){
		case 10:
		case 9: grade="A"; break;
		case 8: grade="B"; break;
		case 7: grade="C"; break;
		default: grade="F"; 
	}
%>

<body>
	이름 : <%=name %><br>
	국어 : <%=kor %><br>
	수학 : <%=math %><br>
	영어 : <%=eng %><br>
	총점 : <%=tot %><br>
	평균 : <%=avg %><br>
	학점 : <%=grade %>
</body>
</html>