package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/**")
@AllArgsConstructor
public class BoardController {
	
	BoardService service; //생성자 주입

	@GetMapping("/list") //전체 목록 board/list (get)
	public void list(Model model) {
		log.info("list url 요청..");
		model.addAttribute("list", service.getList());
		// -> board/list.jsp
	}
	
	// 등록(작성글-BoardVO) board/register (post)   <- 입력화면 (get)
	@PostMapping("/register")
	public String register(BoardVO vo,RedirectAttributes rttr) {
		log.info("register url post 요청");
		service.register(vo);
		rttr.addFlashAttribute("result", vo.getBno()); // why? 데이터(작성글번호) 한번만 전송
		return "redirect:/board/list"; //why? redirect가 없으면 jsp이고 
									   //redirect 가 있으면 요청
	}
	
	@GetMapping({"/register","/remove"})
	public void register() {
		
	}

	@GetMapping("/modify")
	public void modify(Long bno,Model model) {
		model.addAttribute("board",service.get(bno));
	}
	

	// 조회(글번호-bno) board/get (get) //p218
	@GetMapping("/get")
	public void get(Long bno,Model model) {
		log.info("글상세보기 url 요청");
		model.addAttribute("board", service.get(bno));
		// -> board/get.jsp
	}
	
	
	// 삭제(글번호-bno) board/remove (post)  <- 입력화면(get)
	@PostMapping("/remove")
	public String remove(Long bno,RedirectAttributes rttr) {
		log.info("삭제 url 요청");
		if(service.remove(bno)) //이상없으면 result 이름으로 success 라는 문자 전송
			rttr.addFlashAttribute("result", "success1"); 
		return "redirect:/board/list";	
	}

	
	// 수정(수정글-BoardV) board/modify (post) <- 입력화면(get)
	@PostMapping("/modify")
	public String modify(BoardVO vo,RedirectAttributes rttr) {
		log.info("수정 url 요청:");
		if(service.modify(vo))
			rttr.addFlashAttribute("result", "success2"); 
		return "redirect:/board/list";	
	}
	

 
}





