package com.member.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;

public class MemberList extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		MemberDAOImpl mdao=MemberDAOImpl.getInstance();
		ArrayList<MemberDTO> list=mdao.getMemberList();
		req.setAttribute("list", list);
		
		RequestDispatcher rd=req.getRequestDispatcher("list.jsp");
		rd.forward(req, resp);
	}
}
