package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Data 
@AllArgsConstructor 
@NoArgsConstructor //기본생성자까지 간소화
public class SampleVO {
	private Integer mno;
	private String firstName;
	private String lastName;
}
