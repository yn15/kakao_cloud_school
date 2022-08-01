package book.vo;

public class Book {
//	책 표지	책 제목	책 저자	책 가격	삭제
	private String bisbn;
	private String btitle;
	private String bauthor;
	private String bprice;
	private String bimgurl;
	
	public Book() {
	}
	
	public Book(String bimgurl, String btitle, String bauthor, String bprice, String bisbn) {
		this.bimgurl = bimgurl;
		this.btitle = btitle;
		this.bauthor = bauthor;
		this.bprice = bprice;
		this.bisbn = bisbn;
	}
	
	public String getBimgurl() {
		return bimgurl;
	}
	public void setBimgurl(String bimgurl) {
		this.bimgurl = bimgurl;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public String getBprice() {
		return bprice;
	}
	public void setBprice(String bprice) {
		this.bprice = bprice;
	}
	public String getBisbn() {
		return bisbn;
	}
	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}
	
	
}
