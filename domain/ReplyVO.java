package goottgirls.web.board.domain;

import java.util.Date;

public class ReplyVO {
	private int replyNo; // 댓글 번호
	private int replyBno; // 게시글 번호
	private String replyContent; // 댓글 내용
	private String replyId; // 댓글 작성자 아이디
	private Date replyDate; // 댓글 작성/수정 시간
	private int reply_count;
	
	public ReplyVO() {}

	public ReplyVO(int replyNo, int replyBno, String replyContent, String replyId, Date replyDate, int reply_count) {
		super();
		this.replyNo = replyNo;
		this.replyBno = replyBno;
		this.replyContent = replyContent;
		this.replyId = replyId;
		this.replyDate = replyDate;
		this.reply_count = reply_count;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getReplyBno() {
		return replyBno;
	}

	public void setReplyBno(int replyBno) {
		this.replyBno = replyBno;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public int getReply_count() {
		return reply_count;
	}

	public void setReply_count(int reply_count) {
		this.reply_count = reply_count;
	}

	@Override
	public String toString() {
		return "ReplyVO [replyNo=" + replyNo + ", replyBno=" + replyBno + ", replyContent=" + replyContent
				+ ", replyId=" + replyId + ", replyDate=" + replyDate + ", reply_count=" + reply_count + "]";
	}


	
}
