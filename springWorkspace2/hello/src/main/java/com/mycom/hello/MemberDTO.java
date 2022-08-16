package com.mycom.hello;

import lombok.Data;

@Data
public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String tel;
}
