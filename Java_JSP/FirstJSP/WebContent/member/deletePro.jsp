<%@page import="com.member.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String userid=request.getParameter("userid");
	MemberDAOImpl mdao=MemberDAOImpl.getInstance();
	mdao.memberDel(userid);
	session.invalidate();
	response.sendRedirect("loginForm.jsp");
%>

