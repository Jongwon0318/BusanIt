package com.myapp.myboard;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myapp.model.BoardServiceImpl;
import com.myapp.model.BoardVO;
import com.myapp.util.PageAction;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private BoardServiceImpl service;
	
	@Autowired
	private PageAction page;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		HashMap<String,Object> hm=new HashMap<String,Object>();
		hm.put("field", "");
		hm.put("word", "");
		
		int count=service.count(hm);
		int pageSize=5;
		String pageNum="1";
		int currentPage=Integer.parseInt(pageNum);
		int startRow=(currentPage-1)*pageSize+1;
		int endRow=startRow+pageSize-1;
		if(endRow>count) endRow=count;
		hm.put("startRow", startRow);
		hm.put("endRow",endRow);
		
		String pageHtml=page.paging(count, pageSize, currentPage, "", "");
		
		List<BoardVO> list=service.list(hm);
		
		model.addAttribute("list",list);
		model.addAttribute("count",count);
		model.addAttribute("pageHtml",pageHtml);

		return "list";
	}
	
}
