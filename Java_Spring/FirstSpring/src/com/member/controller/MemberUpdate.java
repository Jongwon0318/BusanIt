package com.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;

public class MemberUpdate extends AbstractController{
	
	private MemberDAOImpl dao;
	
	//setter
	public void setDao(MemberDAOImpl dao) {
		this.dao=dao;
	}
		
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		MemberDTO user=dao.findById(req.getParameter("id"));
		user.setAddr(req.getParameter("addr"));
		user.setMemo(req.getParameter("memo"));
		user.setName(req.getParameter("name"));
		dao.update(user);
		
		//스프링의 기본은 forward
		
		return new ModelAndView("redirect:member_list.do");
	}

}
