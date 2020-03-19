package com.guestapp.guest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	// GetMapping, PostMapping�� �̿��ϸ� method�� ���� ���������ʾƵ� ��
	// �߰� ��
	@GetMapping("gInsert")
	public String insert() {
		return "insert";
	}

	// �߰�
	@PostMapping("gInsert")
	//@ModelAttribute : �𵨿� �ش� �̸����� ��ü�� �����
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

	// ����Ʈ
	@GetMapping("gList")
	@ResponseBody
	public Object list(Model model, String field, String word, String pageNum) {
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
		
		List<Object> obj=new ArrayList<Object>();
		
		obj.add(count);
		obj.add(list);
		obj.add(pageHtml);
		
		//model.addAttribute("count",count);
		//model.addAttribute("guestlist", list);
		//model.addAttribute("pageHtml",pageHtml);
		
		return obj;
	}

	//Jackson Databind�� Ȱ���� �󼼺���
	@GetMapping(value="gView")
	@ResponseBody //***���ϰ��� view���ƴ϶� ��¥ ���ڿ��϶� ���(String)
	//@RequestParam("num") int no : num���� �Ѿ���� ���� no�� �ްڴٴ� �� 
	public GuestVO view(int num) {
		GuestVO guest = service.findById(num);
		return guest;
	}

	// ���� ��
	@GetMapping("gUpdate")
	public String update(Model model, int num) {
		GuestVO guest = service.findById(num);
		model.addAttribute("guest", guest);
		return "update";
	}

	// ����
	@PostMapping("gUpdate")
	public String update(GuestVO guest) {
		service.update(guest);
		return "redirect:gList";
	}

	// ����
	@GetMapping("gDelete")
	public String delete(int num) {
		service.delete(num);
		return "insert";
	}
	
	//�α���
	@GetMapping("login")
	public void login() {
		
	}
	
	


}
