package com.member.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.member.model.MemServiceImpl;
import com.member.model.MemberVO;

@Controller
public class MemberController {
	
	@Resource(name="mService")
	private MemServiceImpl mService;
	
	//Ãß°¡Æû
	@RequestMapping("memberInsert.mb")
	public void insertForm() {
		 
	}
	
	//Ãß°¡
	@RequestMapping(value="memberInsert.mb",
										 method=RequestMethod.POST)
	public String insert(MemberVO member) {
		mService.insert(member);
		return "redirect:memberList.mb";
	}
	
	@RequestMapping("memberList.mb")
	public String list(Model model) {
		model.addAttribute("list",mService.list());
		return "memberList";
	}
	
	@RequestMapping("memberView.mb")
	public String detail(Model model,String id) {
		model.addAttribute("user", mService.detail(id));
		return "memberView";
	}
	
	@RequestMapping("memberDelete.mb")
	public String delete(String id) {
		mService.delete(id);
		return "redirect:memberList.mb";
	}
	
	@RequestMapping("memberUpdate.mb")
	public String updateForm(Model model,String id) {
		model.addAttribute("user",mService.detail(id));
		return "memberUpdate";
	}
	
	@RequestMapping(value="memberUpdate.mb",
										 method=RequestMethod.POST)
	public String update(MemberVO member) {
		mService.update(member);
		return "redirect:memberList.mb";
	}
	
}
