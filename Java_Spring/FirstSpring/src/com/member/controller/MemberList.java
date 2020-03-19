package com.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;

public class MemberList extends AbstractController{

	private MemberDAOImpl dao;
	
	//setter
	public void setDao(MemberDAOImpl dao) {
		this.dao = dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) 
			throws Exception {
		req.setCharacterEncoding("utf-8");
		ModelAndView mv=new ModelAndView("WEB-INF/jsp/list.jsp");
	
		List<MemberDTO> list=dao.getMemberList();
		mv.addObject("list",list);
		return mv;
	}
	
	public MemberDAOImpl getDao() {
		return dao;
	}
}
