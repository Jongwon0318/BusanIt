package com.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;

public class MemberDetail extends AbstractController{
	
	private MemberDAOImpl dao;
	
	//setter
	public void setDao(MemberDAOImpl dao) {
		this.dao=dao;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("utf-8");

		System.out.println(req.getParameter("id"));
		ModelAndView mv=new ModelAndView();
		mv.setViewName("WEB-INF/jsp/detail.jsp");
		MemberDTO user=dao.findById(req.getParameter("id"));
		mv.addObject("user",user);
		return mv;
	}
	
	public MemberDAOImpl getDao() {
		return dao;
	}
}
