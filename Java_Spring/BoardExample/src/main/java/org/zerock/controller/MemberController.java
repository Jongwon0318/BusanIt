package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;


@Controller
public class MemberController {
	
//	@Autowired
//	private MemberMapper mapper;
//	
//	@Autowired
//	private PasswordEncoder pwencoder;
//	
//	@GetMapping("/memberRegister")
//	public void memberRegister() {
//		
//	}
//	
//	@PostMapping("/memberRegister")
//	public String mRegister(MemberVO vo, Model model) {
//		
//		if(mapper.memberIdCheck(vo.getUserid())==1) {
//			model.addAttribute("idCheck","중복된 아이디입니다.");
//			model.addAttribute("userpw",vo.getUserpw());
//			model.addAttribute("username",vo.getUsername());
//			return "/memberRegister";
//		}
//		else {
//			vo.setUserpw(pwencoder.encode(vo.getUserpw()));
//			mapper.insert(vo);
//			mapper.authInsert(vo.getUserid(), "ROLE_ADMIN");
//			return "/customLogin";
//		}
//		
//	}
}
