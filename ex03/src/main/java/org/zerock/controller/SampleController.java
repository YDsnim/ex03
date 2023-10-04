package org.zerock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

import lombok.extern.log4j.Log4j;

@RestController // = data로 응답하겠다.
@RequestMapping("/sample")
@Log4j
public class SampleController {

//	@GetMapping("/getText") //이대로 진행시 한글폰트 깨짐
	@GetMapping(value = "/getText", produces = "text/plain;charset=UTF-8")
	// A.위와 같은 설정을해줘야 한글폰트 안깨짐
	public String getText() {

		log.info("MiME TYPE:" + MediaType.TEXT_PLAIN_VALUE); // A와 같은 기능
		return "안녕하세요";
	}

	@GetMapping(value = "/getSample", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	// json , xml 둘 다 사용할경우 위 처럼 배열로 구현해 놓는다.

	public SampleVO getSample() {
		SampleVO vo = new SampleVO(1, "오늘은", "수요일");
		return vo;

		// json 변환 라이브러리만 있으면 json으로
		// xml 변환라이브러리만 있으면 xml으로
		// 둘다 있을시 xml이 우선순위가 높음.
		// url뒤에 .json 이면 json으로 .xml이면 xml으로 처리됨.
	}

	@GetMapping(value = "/getList")
	public List<SampleVO> getList() {
//		List<SampleVO> list = new ArrayList<>();
//		for (int i = 0; i < 10; i++) {
//			SampleVO vo = new SampleVO(i,"성"+i,"이름"+i);
//			list.add(vo);
//		}
		return IntStream.range(0, 10).mapToObj(i -> new SampleVO(i, "성" + i, "이름" + i)).collect(Collectors.toList());
	}

	@GetMapping("/getMap")
	public Map<String, SampleVO> getMap() {
		Map<String, SampleVO> map = new HashMap<>();
		map.put("나는키값", new SampleVO(1, "오늘은", "수요일"));
		// 보통 변수명이 들어감 , new ~~
		return map;
	}

	// ex) smaple/check?height=140&weight=50
	// params : 특정 키 값이 존재하게 제한
	@GetMapping(value = "/check", params = { "height", "weight" })
	public ResponseEntity<SampleVO> check(int height, int weight) {

		SampleVO vo = new SampleVO(1, height + "", weight + "");

		ResponseEntity<SampleVO> result = null;

		if (height < 150)
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		else
			result = ResponseEntity.status(HttpStatus.OK).body(vo);

		return result;
	}

	// p366 url 에 있는 값 읽는법 @PathVariable

	// /sample/product/(원하는 글자/원하는 숫자
	// /sample/product/(싸펑/2077)
	// 읽어야할 부분을 {}로 표시
	@GetMapping("/product/{pname}/{pyear}")
	public String[] getPath(
				@PathVariable("pname") String name, // pname를 변수 name으로
				@PathVariable("pyear") String num) { // year를 변수 num으로
	return new String[] { "제품명: " + name, "제조일 :" + num };

	}

	// 보낸 데이터를 읽는법

	@PostMapping("/ticket")
	// SampleVO 형태로 데이터를 보낼거임
	// 파라미터형태로 보내는거 아님
	// 테스트를 위해 크롬확장프로그램 Yet Another REST Client 다운
	public SampleVO convert(@RequestBody SampleVO vo) {
		log.info("수집이 됬나요?" + vo);
		return vo;
	}

}
