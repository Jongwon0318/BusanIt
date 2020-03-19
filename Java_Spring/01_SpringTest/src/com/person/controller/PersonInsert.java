package com.person.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.person.model.PersonDAOImpl;
import com.person.model.PersonDTO;

public class PersonInsert extends AbstractController{

	private PersonDAOImpl dao;
	
	//setter
	public void setDao(PersonDAOImpl dao) {
		this.dao = dao;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		PersonDTO user=new PersonDTO();
		
		user.setId(req.getParameter("id"));
		user.setPassword(req.getParameter("pwd"));
		user.setName(req.getParameter("name"));
		user.setGender(req.getParameter("gender"));
		user.setJob(req.getParameter("job"));
		
		dao.personInsert(user);
		
		//????????????????????????????????
		//return new ModelAndView("/WebContent/index.jsp");
		return null;
	}

}
