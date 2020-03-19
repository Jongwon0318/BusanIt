package com.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAOImpl dao;	
	
	//이름을 같게?
	@RequestMapping("memberFormInsert.me")
	public String memberFormInsert() {
		return "memberInsert";
	}
	
	@RequestMapping("memberInsert.me")
	public ModelAndView memberInsert(MemberVO user) {
		dao.insert(user);
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
		List<MemberVO> list=dao.getMemberList();
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
		MemberVO user=dao.findById(id);
		model.addAttribute("user",user);
		return "memberView";
	}
	
	@RequestMapping("memberFormUpdate.me")
	public ModelAndView memberFormUpdate(String id) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("memberUpdate");
		mv.addObject("user",dao.findById(id));
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
		dao.update(user);
		model.addAttribute("list", dao.getMemberList());
		return "memberList";
	}
	
	@RequestMapping("memberDelete.me")
	public ModelAndView memberDelete(String id) {
		dao.delete(id);
		return new ModelAndView("redirect:memberList.me");
	}
}
