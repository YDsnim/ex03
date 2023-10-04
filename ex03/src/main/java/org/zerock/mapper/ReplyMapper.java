package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	
	//1.쓰기 (write)
	int register(ReplyVO vo);
	
	//2.목록읽기 (read)
	List<ReplyVO> getList(Long bno);
	
	//3.수정하기 (update)
	int update(ReplyVO vo);
	
	//4.지우기
	int delete(Long rno);
	
	
	

}
