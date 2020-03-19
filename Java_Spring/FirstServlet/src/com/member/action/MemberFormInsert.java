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

public class MemberFormInsert extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String id=req.getParameter("id");
		String pass=req.getParameter("pass");
		String name=req.getParameter("name");
		String addr=req.getParameter("addr");
		String memo=req.getParameter("memo");
		
		MemberDTO user=new MemberDTO();
		user.setId(id);
		user.setPass(pass);
		user.setName(name);
		user.setAddr(addr);
		user.setMemo(memo);
		
		MemberDAOImpl mdao=MemberDAOImpl.getInstance();
		
		mdao.insert(user);
		
		ArrayList<MemberDTO> list=mdao.getMemberList();
		req.setAttribute("list", list);
		
		RequestDispatcher rd=req.getRequestDispatcher("list.jsp");
		rd.forward(req, resp);
	}
}
