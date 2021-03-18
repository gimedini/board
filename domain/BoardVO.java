package goottgirls.web.board.domain;

import java.util.Date;

public class BoardVO {
	private int bno;
	private String title;
	private String content;
	private String userid;
	private Date cdate;
	private int replyCount;
	private String cateCode;
	
	
	
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}



	public BoardVO(int bno, String title, String content, String userid, Date cdate, int replyCount, String cateCode) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.userid = userid;
		this.cdate = cdate;
		this.replyCount = replyCount;
		this.cateCode = cateCode;
	}



	public int getBno() {
		return bno;
	}



	public void setBno(int bno) {
		this.bno = bno;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public Date getCdate() {
		return cdate;
	}



	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}



	public int getReplyCount() {
		return replyCount;
	}



	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}



	public String getCateCode() {
		return cateCode;
	}



	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}



	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", userid=" + userid + ", cdate="
				+ cdate + ", replyCount=" + replyCount + ", cateCode=" + cateCode + "]";
	}
	
	

} // end BoardVO










