package org.nullmaster.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("select now()")  // mybatis���� ���� select �� �����Ѵ�. 
	public String getTime();
	
	public String getTime2();
}
