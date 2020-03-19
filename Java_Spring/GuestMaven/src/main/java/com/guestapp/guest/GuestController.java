package com.guestapp.guest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.guestapp.model.GuestServiceImpl;
import com.guestapp.util.PageAction;
import com.guestapp.vo.GuestVO;

@SessionAttributes("login")
@Controller
public class GuestController {
	@Autowired
	GuestServiceImpl service;
	
	@Autowired
	PageAction page;

	// GetMapping, PostMapping을 이용하면 method를 따로 적어주지않아도 됨
	// 추가 폼
	@GetMapping("gInsert")
	public String insert() {
		return "insert";
	}

	// 추가
	@PostMapping("gInsert")
	//@ModelAttribute : 모델에 해당 이름으로 객체를 담아줌
	public String insert(@ModelAttribute("guest") GuestVO guest) {
		InetAddress local;
		try {
			local = InetAddress.getLocalHost();
			guest.setIpaddr(local.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		service.insert(guest);
		return "redirect:gList";
	}

	// 리스트
	@GetMapping("gList")
	public String list(Model model, String field, String word, String pageNum) {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		if(field==null) field="";
		if(word==null) word="";
		
		hm.put("field", field);
		hm.put("word", word);
		
		int count=service.count(hm);
		
		System.out.println(count);
		int pageSize=5;
		
		System.out.println(pageNum);
		if(pageNum==null) pageNum="1";
		
		int currentPage=Integer.parseInt(pageNum);
		
		int startRow=(currentPage-1)*pageSize+1;
		
		int endRow=startRow+pageSize-1;
		
		if(endRow>count) endRow=count;
		
		hm.put("startRow", startRow);
		hm.put("endRow",endRow);
		
		List<GuestVO> list = service.list(hm);
		
		String pageHtml=page.paging(count, pageSize, currentPage, field, word);
		
		System.out.println();
		
		model.addAttribute("count",count);
		
		model.addAttribute("guestlist", list);
		
		model.addAttribute("pageHtml",pageHtml);
		
		return "list";
	}

	// 상세보기
	@GetMapping(value="gView", produces="text/plain;charset=UTF-8")
	@ResponseBody //***리턴값이 view가아니라 진짜 문자열일때 사용(String)
	//@RequestParam("num") int no : num으로 넘어오는 값을 no로 받겠다는 뜻 
	public String view(@RequestParam("num") int no) {
		GuestVO guest = service.findById(no);
		JSONObject obj=new JSONObject();
		obj.put("name", guest.getName());
		obj.put("content", guest.getContent());
		obj.put("created", guest.getCreated());
		obj.put("grade", guest.getGrade());
		obj.put("ipaddr",guest.getIpaddr());
		
		return obj.toString();
	}

	// 수정 폼
	@GetMapping("gUpdate")
	public String update(Model model, int num) {
		GuestVO guest = service.findById(num);
		model.addAttribute("guest", guest);
		return "update";
	}

	// 수정
	@PostMapping("gUpdate")
	public String update(GuestVO guest) {
		service.update(guest);
		return "redirect:gList";
	}

	// 삭제
	@GetMapping("gDelete")
	public String delete(int num) {
		service.delete(num);
		return "redirect:gList";
	}
	
	//로그인
	@GetMapping("login")
	public void login() {
		
	}
	
//	@PostMapping("login")
//	public String login(Model model,HttpServletRequest req,String id, String pwd) {
//		HttpSession session=req.getSession();
//		if(id.equals("admin")&&pwd.equals("1234")) {
//			session.setAttribute("login", true);
//			return "insert";
//		}else {
//			model.addAttribute("errMsg","아이디/비밀번호 오류");
//			return "login";
//		}
//	}

//	//로그아웃
//	@GetMapping("logout")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "redirect:/";
//	}
	
	@PostMapping("login")
	public String login(String id, String pwd, Model model) {
		if(id.equals("admin")&&pwd.equals("1234")) {
			model.addAttribute("login",true);
			return "insert";
		}else {
			model.addAttribute("errMsg","아이디/비밀번호 오류");
			return "login";
		}
	}
	@GetMapping("logout")
	public String logout(SessionStatus session) {
		session.setComplete();
		return "redirect:/";
	}
	


}
