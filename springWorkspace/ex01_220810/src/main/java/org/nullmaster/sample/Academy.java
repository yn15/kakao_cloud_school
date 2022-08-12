package org.nullmaster.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component	// ���������� �����ؾ��ϴ� ������� ǥ���ϴ� �ǹ�
@Data		// lombok ��� - set/get/������/toString()�� �ڵ����� �������ش�. 
public class Academy {

	@Setter(onMethod_=@Autowired)   //lombok ��� - set�޼��带 �����Ͻ� �����Ѵ�. 
	private Teacher teacher;
}
