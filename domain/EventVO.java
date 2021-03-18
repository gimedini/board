package goottgirls.web.board.domain;

import java.util.Date;

public class EventVO {
	private int bno;
	private String title;
	private String content;
	private String userid;
	
	// 문자열로(String) 하면 나중에 꼬여서 Date class(util)로 변경
	private Date cdate;
	
	private String gdsImg;
	private String gdsThumbImg;
	
	public EventVO() {}

	public EventVO(int bno, String title, String content, String userid, Date cdate, String gdsImg,
			String gdsThumbImg) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.userid = userid;
		this.cdate = cdate;
		this.gdsImg = gdsImg;
		this.gdsThumbImg = gdsThumbImg;
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

	public String getGdsImg() {
		return gdsImg;
	}

	public void setGdsImg(String gdsImg) {
		this.gdsImg = gdsImg;
	}

	public String getGdsThumbImg() {
		return gdsThumbImg;
	}

	public void setGdsThumbImg(String gdsThumbImg) {
		this.gdsThumbImg = gdsThumbImg;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", userid=" + userid + ", cdate="
				+ cdate + ", gdsImg=" + gdsImg + ", gdsThumbImg=" + gdsThumbImg + "]";
	}


	
	
} // end BoardVO










