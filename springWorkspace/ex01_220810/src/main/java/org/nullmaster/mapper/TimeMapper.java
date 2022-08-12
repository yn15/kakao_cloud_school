package org.nullmaster.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("select now()")  // mybatis에서 제공 select 를 지원한다. 
	public String getTime();
	
	public String getTime2();
}
