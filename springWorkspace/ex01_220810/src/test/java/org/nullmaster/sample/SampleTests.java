package org.nullmaster.sample;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)  // 현재 테스트코드가 스프링을 실행하는 역할을 할것의미
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")  // 스프링객체설정
@Log4j	// 로그기록 변수 생성해줌 별도의 Logger객체선언없이 log 변수 사용가능 - Spring Legacy Project로 생성하는경우 Log4j와 해당 설정이 완료되는 상태로 제공해줌
		// /sec/main/resource 과 /src/test/resource 에 log4j.xml 파일이 별도로존재함 
public class SampleTests {

	@Setter(onMethod_= {@Autowired})
	private Academy academy;
	
	@Test	//junit 에서 테스트 대상을 표시하는 기능
	public void testExist() {
		assertNotNull(academy); //junit에서 제공- academy객체가 null 안니경우 테스트 성공하는 메서드 
		log.info(academy);
		log.info("-------------------------");
		log.info(academy.getTeacher());
	}
}






