package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyServiceTests {
	
	@Autowired
	private ReplyService service;
	
	@Test
	public void TestReplyService() {
		
		ReplyVO vo = new ReplyVO();
		vo.setBno(27680L);
		vo.setReply("댓글작성기능 테스트");
		vo.setReplyer("테스트맨");
	
		
		//댓글 목록 불러오기
		service.getList(27680L).forEach(x->log.info(x));
		
	
	
	}
	
//	@Test
//	public void Testregister() {
//		BoardVO vo = new BoardVO();
//		vo.setTitle("111");
//		vo.setContent("냉무");
//		vo.setWriter("나다");
//		log.info("게시글 작성서비스:");
//		service.register(vo);
//	}
//	
//	@Test
//	public void TestModify() {
//		BoardVO vo = new BoardVO();
//		vo.setTitle("111");
//		vo.setContent("냉무");
//		vo.setBno(41L);
//		log.info("수정 서비스:"+service.modify(vo));
//	}
//	
//	@Test
//	public void TestRemove() {
//		log.info("삭제 서비스:"+service.remove(22L));
//	}
//	
//	@Test
//	public void TestGet() {
//		log.info("상세보기 서비스:"+service.get(3L));
//	}
	
	
}
