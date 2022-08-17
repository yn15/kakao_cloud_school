package com.mycom.board.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO {
	private int no;
	private String name;
	private String title;
	private String content;
	private String passwd;
	private Date regdate;
	private Date modifydate;
	private int hit;
}
