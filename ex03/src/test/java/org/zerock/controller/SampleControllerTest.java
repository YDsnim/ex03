package org.zerock.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.domain.SampleVO;

import com.google.gson.Gson;

import lombok.extern.log4j.Log4j;

@WebAppConfiguration //컨트롤러 테스트위해
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" }) //컨트롤러 테스트위해
@Log4j
public class SampleControllerTest {

	@Autowired
	private WebApplicationContext ctx; //mockMvc 객체를 만들때 필요.

	private MockMvc mockMvc;  //이 객체를 이용해서 컨트롤러는 테스트를 해야함
		                      //객체를 직접 인스턴해서 사용해야함.
	
	@Before //junit으로 테스트할때 먼저 수행하는 메소드
	public void setup() {
		mockMvc=MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	/// 아래부터 테스트
	//Gson 라이브러리는  java객체를 Json 문자열로 변환하기 위해 사용
	
@Test
public void testTicket() throws Exception {
	//넣어주기 위한 json data
	SampleVO vo = new SampleVO(2,"abc","def");
	Gson gson = new Gson();
	String jsonData=gson.toJson(vo);
	log.info("json형태로 변환 "+jsonData);
	
	
	mockMvc.perform(post("/sample/ticket")
			.contentType(MediaType.APPLICATION_JSON)
			.content(jsonData)).andExpect(status().is(200));
	}
	//crud = read(읽기),create(쓰기),update(수정),delete(삭제)
	//메소드 =get(읽기),post(쓰기),put(수정),delete(삭제)
}
