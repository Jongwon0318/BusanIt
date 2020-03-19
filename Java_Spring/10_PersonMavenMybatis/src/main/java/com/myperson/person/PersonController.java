package com.myperson.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.person.model.PersonServiceImpl;
import com.person.vo.PersonVO;

@Controller
public class PersonController {

	@Autowired
	private PersonServiceImpl service;
	
	@RequestMapping("pInsert")
	public String insertForm() {
		return "personInsert";
	}
	
	@RequestMapping(value="pInsert" , method=RequestMethod.POST)
	public String insert(PersonVO person) {
		service.insert(person);
		return "redirect:pList";
	}
	
	@RequestMapping("pList")
	public String list(Model model,String field, String word) {
		model.addAttribute("list",service.list(field, word));
		model.addAttribute("count",service.count(field, word));
		return "personList";
	}
	
	@RequestMapping("pCount")
	public int count(String field,String word) {
		return service.count(field, word);
	}
	
	@RequestMapping("pView")
	public String detail(Model model,String id) {
		model.addAttribute("person",service.detail(id));
		return "personView";
	}
	
	@RequestMapping("pUpdate")
	public String update(PersonVO person) {
		service.update(person);
		return "redirect:pList";
	}
	
	@RequestMapping("pDelete")
	public String delete(String id) {
		service.delete(id);
		return "redirect:pList";
	}
}
