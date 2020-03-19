package com.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.person.model.PSImpl;
import com.person.model.PVO;

@Controller
public class PersonController {
	
	@Autowired
	private PSImpl service;
	
	@RequestMapping("pInsert.mb")
	public String pInsertForm() {
		return "personInsert";
	}
	
	@RequestMapping(value="pInsert.mb",
										 method=RequestMethod.POST)
	public String pInsert(PVO pvo) {
		service.insert(pvo);
		return "redirect:pList.mb";
	}
	
	@RequestMapping("pList.mb")
	public String pList(Model model) {
		model.addAttribute("list", service.list());
		return "personList";
	}
	
	@RequestMapping("pDetail.mb")
	public String pDetail(Model model, String id) {
		model.addAttribute("person",service.detail(id));
		return "personView";
	}
	
	@RequestMapping("pUpdate.mb")
	public String pUpdate(PVO pvo) {
		service.update(pvo);
		return "redirect:pList.mb";
	}
	
	@RequestMapping("pDelete.mb")
	public String pDelete(String id) {
		service.delete(id);
		return "redirect:pList.mb";
	}
	
}
