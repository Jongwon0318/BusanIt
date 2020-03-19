<%@page import="com.member.MemberDAOImpl"%>
<%@page import="com.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="vo" class="com.member.MemberVO"></jsp:useBean>
<jsp:setProperty property="*" name="vo"/>

<%
	MemberDAOImpl mdao=MemberDAOImpl.getInstance();
	mdao.memberUpdate(vo);
	response.sendRedirect("loginForm.jsp");
%>