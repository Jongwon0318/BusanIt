<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id=request.getParameter("id") ;
	String pwd=request.getParameter("pwd");
	String method=request.getParameter("method");
	String str=method+"방식으로 처리한 결과!! <br>";
	str+="id : <u>"+id+"</u><br><br>";
	str+="pwd : <u>"+pwd+"</u>";
	out.println(str);
%>