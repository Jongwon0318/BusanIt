package org.zerock.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.service.BoardServiceImpl;
import org.zerock.service.ReplyServiceImpl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@AllArgsConstructor
public class HomeController {
	
	private BoardServiceImpl service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, Criteria cri) {
		log.info("list"+cri);
		model.addAttribute("list",service.getList(cri));
		
		int total= service.getTotal(cri);
		
		log.info("total: "+total);
		model.addAttribute("pageMaker",new PageDTO(cri,total));
		
		return "home";
	}
	
}
