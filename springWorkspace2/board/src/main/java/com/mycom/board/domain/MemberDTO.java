package com.mycom.board.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberDTO {
	private String id;
	private String passwd;
	private String name;
	private String email;
	private String tel;
	private String addr;
	private Date regdate;
	private String delYn;
}
