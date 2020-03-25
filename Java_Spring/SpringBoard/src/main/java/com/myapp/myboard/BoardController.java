package com.myapp.myboard;

import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.model.BoardServiceImpl;
import com.myapp.model.BoardVO;
import com.myapp.model.CommentVO;
import com.myapp.util.PageAction;


@Controller
public class BoardController {

	@Autowired
	private BoardServiceImpl service;
	
	@Autowired
	private PageAction page;
	
	@GetMapping("insert")
	public void insertForm() {
		
	}
	@PostMapping("insert")
	public String insert(@ModelAttribute("board") BoardVO board) {
		service.insert(board);
		return "redirect:list";
	}
	
	@GetMapping("list")
	public String list(Model model, String pageNum,String field, String word) {
		HashMap<String,Object> hm=new HashMap<String,Object>();
		hm.put("field", field);
		hm.put("word", word);

		int count=service.count(hm);
		
		int pageSize=5;
		if(pageNum==null) pageNum="1";
		int currentPage=Integer.parseInt(pageNum);
		int startRow=(currentPage-1)*pageSize+1;
		int endRow=startRow+pageSize-1;
		if(endRow>count) endRow=count;
		hm.put("startRow", startRow);
		hm.put("endRow",endRow);
		
		String pageHtml;
		
		if(field==null||word==null) {
			pageHtml=page.paging(count, pageSize, currentPage, "", "");
		}
		else {
			pageHtml=page.paging(count, pageSize, currentPage, field, word);
		}
		
		List<BoardVO> list=service.list(hm);
		
		model.addAttribute("list",list);
		model.addAttribute("count",count);
		model.addAttribute("pageHtml",pageHtml);
		return "list";
	}
	
	@GetMapping("detail")
	public String detail(Model model,int num) {
		service.hitCount(num);
		model.addAttribute("detail",service.detail(num));
		
		int bnum=num;
		List<CommentVO> commentList=service.getComments(bnum);
		model.addAttribute("commentList",commentList);
		
		return "detail";
	}
	
	@GetMapping("delete")
	public void deleteForm() {
	}
	
	@PostMapping("delete")
	public void delete(int num) {
		service.delete(num);
	}
	
	@GetMapping("update")
	public void updateForm(Model model,int num) {
		model.addAttribute("board",service.detail(num));
	}
	
	@PostMapping("update")
	public String update(@ModelAttribute("board") BoardVO board) {
		service.update(board);
		return "redirect:list";
	}
	
	@PostMapping("passCheck")
	@ResponseBody
	public String passCheck(int num, String password) {
		if(service.detail(num).getPassword().equals(password)) {
			return "true";
		}else {
			return "false";
		}
	}

	@PostMapping("addComment")
	@ResponseBody
	public Object addComment(CommentVO comment, int bnum) {
		service.addComment(comment);
		
		List<CommentVO> commentList=service.getComments(bnum);
				
		return commentList;
	}
	
	@GetMapping("commentDelete")
	public void commentDeleteForm(Model model, int cnum, int bnum) {
		model.addAttribute("cnum",cnum);
		model.addAttribute("bnum",bnum);
	}
	
	@PostMapping("commentPassCheck")
	@ResponseBody
	public String commentPassCheck(int cnum, String password) {
		if(service.commentDetail(cnum).getPassword().equals(password)) {
			return "true";
		}else {
			return "false";
		}
	}

	@PostMapping("commentDelete")
	@ResponseBody
	public void deleteComment(int cnum) {
		service.commentDelete(cnum);
	}
	
}
