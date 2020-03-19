package com.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.member.model.MemberDAOImpl;

public class MemberFormUpdate extends AbstractController{
	
	private MemberDAOImpl dao;
	
	//setter
	public void setDao(MemberDAOImpl dao) {
		this.dao=dao;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("WEB-INF/jsp/memberUpdate.jsp");
		mv.addObject("user",dao.findById(req.getParameter("id")));
		return mv;
	}

}
