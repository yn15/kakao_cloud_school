package com.rapa.control.guestbook;

public class GuestbookDto {
	private int    id =1;
	private String title = "";
	private String contents="";
	private String writer="";
	private String wdate="";
	private int    hit=0;
	
	
	//추가적인 생성자를 만들생각이 없으면 이거 안마들어도 됨 - 디폴트 생성자(매개변수 생성자)
	//시스템은 우리가 아무런 생성자도 안만들면 디폴트 생성자를 만들어서 호출한다.
	//하는 일은 없지만 만들어서 호출한다
	//필요에 의해서 디폴트 생성자 이외의 생성자를 만들면, 시스템이 디폴트 생성자를 안만들어 준다
	//그래서 기본 객체 생성 못함 GuestbookDto dto = new GusetbookDtd(); ==>불가(에러)
	//실제로 데이터베이스에 접근해야할 상황이면 생성자 안만들어도 된다.
	public GuestbookDto() {
		super(); //부모 클래스의 생성자를 호출한다.
		// TODO Auto-generated constructor stub
	}
	
	
	
	public GuestbookDto(int id, String title, String contents, String writer, String wdate) {
		super();
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.wdate = wdate;
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

}
