package org.nullmaster.persistence;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nullmaster.mapper.TimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)  // ���� �׽�Ʈ�ڵ尡 �������� �����ϴ� ������ �Ұ��ǹ�
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")  // ��������ü����
@Log4j
public class TimeMapperTests {
	
	@Setter(onMethod_= {@Autowired})
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		log.info("getTime");
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTime());
	}
	
	@Test
	public void testGetTime2() {
		log.info("getTime2");
		log.info(timeMapper.getTime2());
	}
}

