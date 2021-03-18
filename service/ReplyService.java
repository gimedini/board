package goottgirls.web.board.service;

import java.util.List;

import goottgirls.web.board.domain.ReplyVO;



public interface ReplyService {
	int create(ReplyVO vo) throws Exception;
	List<ReplyVO> read(int replyBno);
	int update(ReplyVO vo);
	int delete(int replyNo, int replyBno) throws Exception;	
}
