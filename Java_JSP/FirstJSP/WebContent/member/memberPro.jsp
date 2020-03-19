<%@page import="com.member.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="mem" class="com.member.MemberVO"></jsp:useBean>
<jsp:setProperty property="*" name="mem"/>
<%
MemberDAOImpl mdao=MemberDAOImpl.getInstance();
//String uid=request.getParameter("uid");
//userid에 값 넣기(disabled 이므로 hidden으로 전달해서 처리)
//mem.setUserid(uid);
mdao.memberInsert(mem);
response.sendRedirect("loginForm.jsp");
%>