package board.vo;

import java.util.ArrayList;
import java.util.HashMap;

import comment.vo.Comment;

public class Board {
	private String bNumber;
	private String bTitle;
	private String bContents;
	private String bDate;
	private int bLikes;
	private int bHits;
	private String bcomments;
	private String userID;
	private ArrayList<Comment> list;
	
	public String getbNumber() {
		return bNumber;
	}
	public void setbNumber(String bNumber) {
		this.bNumber = bNumber;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContents() {
		return bContents;
	}
	public void setbContents(String bContents) {
		this.bContents = bContents;
	}
	public String getbDate() {
		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
	}
	public int getbLikes() {
		return bLikes;
	}
	public void setbLikes(int bLikes) {
		this.bLikes = bLikes;
	}
	public int getbHits() {
		return bHits;
	}
	public void setbHits(int bHits) {
		this.bHits = bHits;
	}
	public String getBcomments() {
		return bcomments;
	}
	public void setBcomments(String bcomments) {
		this.bcomments = bcomments;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public ArrayList<Comment> getList() {
		return list;
	}
	public void setList(ArrayList<Comment> list) {
		this.list = list;
	}
	
	
}
