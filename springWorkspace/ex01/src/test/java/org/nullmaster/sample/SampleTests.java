package org.nullmaster.sample;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)  // ���� �׽�Ʈ�ڵ尡 �������� �����ϴ� ������ �Ұ��ǹ�
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")  // ��������ü����
@Log4j	// �αױ�� ���� �������� ������ Logger��ü������� log ���� ��밡�� - Spring Legacy Project�� �����ϴ°�� Log4j�� �ش� ������ �Ϸ�Ǵ� ���·� ��������
		// /sec/main/resource �� /src/test/resource �� log4j.xml ������ ������������ 
public class SampleTests {

	@Setter(onMethod_= {@Autowired})
	private Academy academy;
	
	@Test	//junit ���� �׽�Ʈ ����� ǥ���ϴ� ���
	public void testExist() {
		assertNotNull(academy); //junit���� ����- academy��ü�� null �ȴϰ�� �׽�Ʈ �����ϴ� �޼��� 
		log.info(academy);
		log.info("-------------------------");
		log.info(academy.getTeacher());
	}
}






