package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class ReplyController {
	
	private ReplyService replyService;
	
	@GetMapping("getReplyList")
	@ResponseBody
	public List<Object> replyDetail(Long bno,int pageNum) {		
		int total=replyService.getTotal(bno);
		Criteria replyCriteria=new Criteria(pageNum,5);
		List<ReplyVO>  replyList=replyService.getList(replyCriteria, bno);
		PageDTO pageDto=new PageDTO(replyCriteria,total);
		
		List<Object> list=new ArrayList<Object>();
		list.add(replyList);
		list.add(pageDto);
		log.info("replyList : "+replyList);
		log.info("pageDto : "+pageDto);
		return list;
	}
	
	@GetMapping("replyRegister")
	@ResponseBody
	public int replyRegister(ReplyVO vo) {
		replyService.register(vo);
		System.out.println("Reply Total : "+replyService.getTotal(vo.getBno()) );
		
		int replyCount=replyService.getTotal(vo.getBno());
		
		int realEnd=(int)(Math.ceil((replyCount*1.0)/5));

		return realEnd;
	}

}
