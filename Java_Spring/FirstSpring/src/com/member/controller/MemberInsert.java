package com.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;

public class MemberInsert extends AbstractController{

	private MemberDAOImpl dao;
	
	//setter
	public void setDao(MemberDAOImpl dao) {
		this.dao = dao;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("utf-8");
		
		MemberDTO user=new MemberDTO();
		user.setId(req.getParameter("id"));
		user.setPass(req.getParameter("pass"));
		user.setName(req.getParameter("name"));
		user.setAddr(req.getParameter("addr"));
		user.setMemo(req.getParameter("memo"));
		
		dao.insert(user);
		return new ModelAndView("redirect:member_list.do");
	}


}
