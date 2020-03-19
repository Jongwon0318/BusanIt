<%@page import="com.exam.IntroBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IntroPro2</title>
<%
request.setCharacterEncoding("UTF-8");
%>
<!-- IntroBean ibn=new IntroBean();와 같다. -->
<jsp:useBean id="ibn" class="com.exam.IntroBean"></jsp:useBean>	
<jsp:setProperty property="*" name="ibn"/>
</head>
<%
String[] strAvail=ibn.getAvail();
String avail="";
for(int i=0; i<strAvail.length; i++){
	avail+=strAvail[i]+" ";
}
String[] strPlay=ibn.getPlay();
String play="";
for(int i=0; i<strPlay.length; i++){
	play+=strPlay[i]+" ";
}
%>
<body>
이름 : <%=ibn.getName() %><br>
성별 : <%=ibn.getGender() %><br>
생일 : <%=ibn.getYear()+"년 "+ibn.getMonth()+"월 "+ibn.getDay()+"일 " +ibn.getBirthRadio()%><br>
주소 : <%=ibn.getAddr() %><br>
전화번호 : <%=ibn.getTel1()+"-"+ibn.getTel2()+"-"+ibn.getTel3() %><br>
프로그램 : <%=avail %><br>
여행지 : <%=play %><br>
메모 : <%=ibn.getMemo() %><br>
이름 : <jsp:getProperty property="name" name="ibn"/>
</body>
</html>