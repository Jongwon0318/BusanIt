package com.myspring.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspring.model.MemberServiceImpl;
import com.myspring.model.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private MemberServiceImpl service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("mInsert")
	public String insert() {
		return "memberInsert";
	}
	
	@RequestMapping(value="mInsert",
										 method=RequestMethod.POST)	
	public String insert(MemberVO member) {
		service.insert(member);
		return "redirect:mList";
	}
	
	@RequestMapping("mList")
	public String list(Model model,String field, String data) {
		model.addAttribute("list",service.list(field,data));
		return "memberList";
	}
	
	@RequestMapping("mView")
	public String list(Model model,String id) {
		model.addAttribute("user",service.view(id));
		return "memberView";
	}
	
	@RequestMapping("mUpdate")
	public String update(Model model, String id) {
		model.addAttribute("user",service.view(id));
		return "memberUpdate";
	}
	
	@RequestMapping(value="mUpdate",
										 method=RequestMethod.POST)
	public String update(MemberVO member) {
		service.update(member);
		return "redirect:mList";
	}
	
	@RequestMapping("mDelete")
	public String delete(String id) {
		service.delete(id);
		return "redirect:mList";
	}
}
