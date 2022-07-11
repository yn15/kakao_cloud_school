package com.rapa.control.guestbook;

import java.util.ArrayList;
import java.util.List;

public class GuestbookDao {
	List<GuestbookDto> list = new ArrayList<GuestbookDto>();

	public GuestbookDao() {
		super();
		for(int i = 1; i<=20; i++) {
			list.add(new GuestbookDto(i, "제목"+i, "내용"+i, "작성자"+i, "2022006-24"));
		}
	}
	
	public List<GuestbookDto> getList(){
		return list;
	}
	
	public GuestbookDto getView(int id) {
		return list.get(id);
	}
	
	void insert(GuestbookDto dto) {
		dto.setId(list.size()+1);
		list.add(dto);
	}
	
	
}
