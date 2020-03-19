<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dateExam</title>
</head>
<%
	Calendar ca=Calendar.getInstance();
	int year=ca.get(Calendar.YEAR);
	int month=ca.get(Calendar.MONTH)+1;
	int date=ca.get(Calendar.DAY_OF_MONTH);
	// ca.get(Calendar.DAY_OF_WEEK) 에서 일요일 =1
	String[] arr={"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
	
	String day="";
	switch(ca.get(Calendar.DAY_OF_WEEK)){
	case 1: day="일요일"; break;
	case 2: day="월요일"; break;
	case 3: day="화요일"; break;
	case 4: day="수요일"; break;
	case 5: day="목요일"; break;
	case 6: day="금요일"; break;
	case 7: day="토요일"; break;
	}
	
	String strDay="";
	switch(ca.get(Calendar.DAY_OF_WEEK)){
		case Calendar.MONDAY : strDay="월요일입니다."; break;
		case Calendar.TUESDAY : strDay="화요일입니다."; break;
		case Calendar.WEDNESDAY : strDay="수요일입니다."; break;
		case Calendar.THURSDAY : strDay="목요일입니다."; break;
		case Calendar.FRIDAY : strDay="금요일입니다."; break;
		case Calendar.SATURDAY : strDay="토요일입니다."; break;
		case Calendar.SUNDAY : strDay="일요일입니다."; break;
	}
	
%>
<%!
public String getDay(int x){
	String str="";
	switch(x){
	case 1: str="일요일"; break;
	case 2: str="월요일"; break;
	case 3: str="화요일"; break;
	case 4: str="수요일"; break;
	case 5: str="목요일"; break;
	case 6: str="금요일"; break;
	case 7: str="토요일"; break;
	}
	return str;
}
%>
<body>
오늘은 <%=year %>년 <%=month %> 월 <%=date %> 일 <%=arr[ca.get(Calendar.DAY_OF_WEEK)-1] %><br>
<hr>	
<%=day%>
<hr>
<%=strDay %>
<hr>	
함수사용 : <%=getDay(ca.get(Calendar.DAY_OF_WEEK)) %>
</body>
</html>