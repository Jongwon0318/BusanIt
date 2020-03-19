package com.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;

public class MemberDelete extends AbstractController{

	private MemberDAOImpl dao;
	
	//setter
	public void setDao(MemberDAOImpl dao) {
		this.dao=dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		dao.delete(req.getParameter("id"));
		return new ModelAndView("redirect:member_list.do");
	}
}
