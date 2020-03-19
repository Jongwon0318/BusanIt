<%@page import="com.member.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String userid=request.getParameter("userid");
	String pwd=request.getParameter("pwd");
	MemberDAOImpl mdao=MemberDAOImpl.getInstance();
	int flag=mdao.loginCheck(userid,pwd); //-1, 0, 1, 2
	if(flag==0 || flag==1){
		session.setAttribute("userid", userid);
	}
	out.println(flag);
%>