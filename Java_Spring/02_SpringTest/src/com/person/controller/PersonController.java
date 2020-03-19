package com.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.person.model.PersonDAOImpl;
import com.person.model.PersonVO;

@Controller
public class PersonController {
	
	@Autowired
	private PersonDAOImpl dao;
	
	@RequestMapping(value="personForm.go",
										 method=RequestMethod.GET)
	public String personForm() {
		return "personForm";
	}
	
	@RequestMapping(value="personInsert.go",
										 method=RequestMethod.POST)
	public ModelAndView personInsert(PersonVO person) {
		dao.person_insert(person);
		return new ModelAndView("redirect:personList.go");
	}
	
	@RequestMapping(value="personList.go",
										 method=RequestMethod.GET)
	public ModelAndView personList() {
		
		ModelAndView mv=new ModelAndView();
		List<PersonVO> list=dao.person_list();
		
		mv.setViewName("personList");
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping(value="personView.go",
										 method=RequestMethod.GET)
	public ModelAndView personView(String id) {
		
		ModelAndView mv=new ModelAndView();
		PersonVO person=dao.person_view(id);
		
		mv.setViewName("personView");
		mv.addObject("person",person);
		
		return mv;
	}
	
	@RequestMapping(value="personUpdate.go",
										 method=RequestMethod.POST)
	public ModelAndView personUpdate(PersonVO person) {
		dao.person_update(person);
		return new ModelAndView("redirect:personList.go");
	}
	
	@RequestMapping(value="personDelete.go",
										 method=RequestMethod.GET)
	public ModelAndView personDelete(String id) {
		dao.person_delete(id);		
		return new ModelAndView("redirect:personList.go");
	}
	
}
