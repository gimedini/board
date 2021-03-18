package goottgirls.web.board.persistence;

import java.util.List;

import goottgirls.web.board.domain.ReplyVO;



public interface ReplyDAO {
	int insert(ReplyVO vo);
	List<ReplyVO> select(int replyBno);
	int update(ReplyVO vo);
	int delete(int replyNo);
}













