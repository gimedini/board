package goottgirls.web.board.domain;

import java.util.Arrays;
import java.util.Date;

public class NoticeVO {

	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private String noticeAdmin;
	private Date noticeDate;
	private int noticeRead;
	
	public NoticeVO() {
		// TODO Auto-generated constructor stub
	}

	public NoticeVO(int noticeNo, String noticeTitle, String noticeContent, String noticeAdmin, Date noticeDate,
			int noticeRead) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeAdmin = noticeAdmin;
		this.noticeDate = noticeDate;
		this.noticeRead = noticeRead;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeAdmin() {
		return noticeAdmin;
	}

	public void setNoticeAdmin(String noticeAdmin) {
		this.noticeAdmin = noticeAdmin;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public int getNoticeRead() {
		return noticeRead;
	}

	public void setNoticeRead(int noticeRead) {
		this.noticeRead = noticeRead;
	}

	@Override
	public String toString() {
		return "NoticeVO [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeAdmin=" + noticeAdmin + ", noticeDate=" + noticeDate + ", noticeRead=" + noticeRead + "]";
	}

	

	
}
