package com.member.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.member.model.MemberServiceImpl;
import com.member.model.MemberVO;

@Controller
public class MemberController {
	
	@Resource(name="service")
	private MemberServiceImpl service;
	
	//이름을 같게?
	@RequestMapping("memberFormInsert.me")
	public String memberFormInsert() {
		return "memberInsert";
	}
	
	@RequestMapping("memberInsert.me")
	public ModelAndView memberInsert(MemberVO user) {
		service.insert(user);
		return new ModelAndView("redirect:memberList.me");
	}
	
//	@RequestMapping("memberList.me")
//	public ModelAndView memberList() {
//		ModelAndView mv=new ModelAndView();
//		List<MemberVO> list=dao.getMemberList();
//		
//		mv.setViewName("memberList");
//		mv.addObject("list",list);
//		
//		return mv;
//	}
	
	//전체보기
	@RequestMapping("memberList.me")
	public String list(Model model) {
		List<MemberVO> list=service.list();
		model.addAttribute("list", list);
		return "memberList";
	}
	
	
//	@RequestMapping("memberView.me")
//	public ModelAndView memberView(String id) {
//		ModelAndView mv=new ModelAndView("memberView");
//		MemberVO user=dao.findById(id);
//		mv.addObject("user", user);
//		return mv;
//	}
	
	//상세보기
	@RequestMapping("memberView.me")
	public String detail(Model model, String id) {
		MemberVO user=service.detail(id);
		model.addAttribute("user",user);
		return "memberView";
	}
	
	@RequestMapping("memberFormUpdate.me")
	public ModelAndView memberFormUpdate(String id) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("memberUpdate");
		mv.addObject("user",service.detail(id));
		return mv;
	}
	
//	@RequestMapping("memberUpdate.me")
//	public ModelAndView memberUpdate(MemberVO user) {
//		dao.update(user);
//		return new ModelAndView("redirect:memberList.me");
//	}
	
	//수정하기
	@RequestMapping("memberUpdate.me")
	public String memberUpdate(Model model, MemberVO user) {
		service.update(user);
		model.addAttribute("list", service.list());
		return "memberList";
	}
	
	@RequestMapping("memberDelete.me")
	public ModelAndView memberDelete(String id) {
		service.delete(id);
		return new ModelAndView("redirect:memberList.me");
	}
}
