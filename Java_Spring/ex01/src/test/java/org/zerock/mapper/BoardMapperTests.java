package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
//	@Test
//	public void testGetList() {
//		mapper.getList().forEach(board  -> log.info(board));
//	}
//	
//	@Test
//	public void testInsert() {
//		BoardVO board = new BoardVO();
//		board.setTitle("new TestTItle");
//		board.setContent("new Test Content");
//		board.setWriter("newbie");
//		
//		mapper.insert(board);
//		
//		log.info(board);
//	}
//	
//	@Test
//	public void testINsertSelectKey() {
//		BoardVO board = new BoardVO();
//		board.setTitle("new TestTItle(selectKey)");
//		board.setContent("new Test Content(selectKey)");
//		board.setWriter("newbie(selectKey)");
//		
//		mapper.insertSelectKey(board);
//		
//		log.info(board);
//		
//	}
	
//	@Test
//	public void testRead() {
//		BoardVO board=mapper.read(13L);
//		
//		log.info(board);
//	}
	
//	@Test
//	public void testDelete() {
//		log.info("DELETE COUNT : "+mapper.delete(11L));		
//	}
	
	@Test
	public void testUpdate() {
		BoardVO board=new BoardVO();
		board.setBno(3L);
		board.setContent("ContentUpdate");
		board.setTitle("TitleUpdate");
		board.setWriter("WriterUpdate");

		log.info("UPDATE COUNT : " + mapper.update(board));
	}
	
}
