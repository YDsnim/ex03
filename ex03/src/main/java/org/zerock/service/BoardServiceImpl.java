package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@AllArgsConstructor
@Log4j
@Service //스프링에 Sevice 객체로 인식시키기위해서(현재로는 @Componet 와 동일)
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> getList() {
		log.info("목록보기 서비스 요청..");
		return mapper.getList();
	}

	@Override
	public void register(BoardVO vo) {
		log.info("글 등록 서비스 요청...");
		//mapper.insert(vo);
		mapper.insertSelectKey(vo);
	}

	@Override
	public boolean modify(BoardVO vo) {
		log.info("글 수정 서비스 요청...");
		/*
		
			if(mapper.update(vo)==1)
				return true;
			else
				return false;
		*/
		return mapper.update(vo)==1 ? true : false;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("글 삭제 서비스 요청...");
		return mapper.delete(bno)==1 ? true : false ;
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("글 상세보기 서비스 요청...");
		return mapper.read(bno);
	}

}
