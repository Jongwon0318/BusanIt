package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.MemberVO;
import org.zerock.domain.PageDTO;
import org.zerock.mapper.MemberMapper;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	@GetMapping("/getList")
	@ResponseBody
	public List<BoardVO> getList(Criteria cri) {
		if(cri.getKeyword()!=null) {
			Criteria searchCreteria=new Criteria(1,service.getTotal(cri));
			searchCreteria.setType(cri.getType());
			searchCreteria.setKeyword(cri.getKeyword());
			List<BoardVO> boardList=service.getList(searchCreteria);
			log.info("boardList : "+boardList);
			return boardList;
		}else {
			log.info("cri : "+cri);
			List<BoardVO> boardList=service.getList(cri);
			log.info("boardList : "+boardList);
			return boardList;
		}
	}
	
	@GetMapping("/getBoardDetail")
	public String boardDetail(Long bno, Model model) {
		BoardVO board=service.get(bno);
		model.addAttribute("boardDetail",board);
		
		return "boardDetail";
	}
	
	@GetMapping("/boardModify")
	@ResponseBody
	public int boardModify(BoardVO board) {
		service.modify(board);
		
		return 1;
	}
	
	@PostMapping("/register")
	public String registerBoard(BoardVO board,Model model) {
		service.register(board);
		return "redirect:/";
	}
}
