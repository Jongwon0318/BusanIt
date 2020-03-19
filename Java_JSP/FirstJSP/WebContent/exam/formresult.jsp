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
	String age = request.getParameter("age");
	String gender = request.getParameter("maleOrfemale");
	String[] fav=request.getParameterValues("fav");
	String job=request.getParameter("job");
	String tmp="  ";
	if(name.equals("")) name=" ";
	if(age.equals("")) age=" ";
	if(job.equals("")) job=" ";
	if(fav!=null){
		for(int i=0; i<fav.length; i++){
			tmp+=fav[i]+"  ";
		}
	}
	/*
	try{
		for(int i=0; i<fav.length; i++){
			tmp+=fav[i]+"  ";
		}
	}catch(NullPointerException e){
		tmp="  ";
	}
	*/
%>
<body>
이름 : <%=name %><br>
나이 : <%=age %><br>
성별 : <%=gender %><br>
관심분야 : <%=tmp %><br>
직업 : <%=job %>
<hr>
이름 : <%=request.getParameter("name") %><br>
나이 : <%=request.getParameter("age") %><br>
성별 : <%= request.getParameter("maleOrfemale") %><br>
관심분야 : <%=tmp %><br>
직업 : <%=request.getParameter("job") %>
</body>

</html>