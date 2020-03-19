package com.person.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.person.model.PersonDAOImpl;
import com.person.model.PersonDTO;

public class PersonView extends AbstractController{
	
	private PersonDAOImpl dao;
	
	public void setDao(PersonDAOImpl dao) {
		this.dao=dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/WEB-INF/jsp/personView.jsp");
		PersonDTO user=dao.personView(req.getParameter("id"));
		mv.addObject("user", user);
		return mv;
	}

}
