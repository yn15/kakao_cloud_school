package org.nullmaster.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component	// 스프링에서 관리해야하는 대상임을 표시하는 의미
@Data		// lombok 기능 - set/get/생성자/toString()을 자동으로 생성해준다. 
public class Academy {

	@Setter(onMethod_=@Autowired)   //lombok 기능 - set메서드를 컴파일시 생성한다. 
	private Teacher teacher;
}
