package comment.vo;

public class Comment {
	private String cID;
	private String content;
	private String cuserID;
	private String bNumber;
	
	
	
	public String getcID() {
		return cID;
	}
	public void setcID(String cID) {
		this.cID = cID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCuserID() {
		return cuserID;
	}
	public void setCuserID(String cuserID) {
		this.cuserID = cuserID;
	}
	public String getbNumber() {
		return bNumber;
	}
	public void setbNumber(String bNumber) {
		this.bNumber = bNumber;
	}
}
