package org.zerock.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController // = data로 응답하겠다.
@RequestMapping ("/sample") 
@Log4j
public class SampleController {
//	@GetMapping("/getText") //이대로 진행시 한글폰트 깨짐
	@GetMapping(value="/getText",produces="text/plain;charset=UTF-8") 
	//A.위와 같은 설정을해줘야 한글폰트 안깨짐
	public String getText() {
		
		log.info("MiME TYPE:" + MediaType.TEXT_PLAIN_VALUE); //A와 같은 기능
		return "안녕하세요"; 
	}
	
	
}
