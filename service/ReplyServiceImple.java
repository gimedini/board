package goottgirls.web.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goottgirls.web.board.domain.ReplyVO;
import goottgirls.web.board.persistence.BoardDAO;
import goottgirls.web.board.persistence.ReplyDAO;



@Service
public class ReplyServiceImple implements ReplyService{
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(ReplyServiceImple.class);
	
	@Autowired
	private ReplyDAO replyDao;
	@Autowired
	private BoardDAO boardDao;
	
	// @Transactional
	// - 두 개의 데이터베이스 변경이 생길 때
	//   위의 내용이 실행되었고, 아래 내용이 에러가 발생하면
	//   위의 내용은 rollback 되어야 한다.
	//   이러한 기능을 해주는 어노테이션이 Transactional이다.

	@Transactional 
	// root-context.xml 에서 설정한 transactionManager를 weaving
	@Override
	public int create(ReplyVO vo) throws Exception{
		LOGGER.info("create() 호출 = " + vo);
		replyDao.insert(vo);
		LOGGER.info("댓글 입력 성공 = " + vo);
		
		boardDao.updateReplyCount(1, vo.getReplyBno());
		LOGGER.info("게시판 댓글 개수 업데이트 성공");
		return 1;
	}

	@Override
	public List<ReplyVO> read(int replyBno) {
		LOGGER.info("replyBno = " + replyBno);
		return replyDao.select(replyBno);
	}

	@Override
	public int update(ReplyVO vo) {
		LOGGER.info("수정완료 = " + vo);
		return replyDao.update(vo);
	}

	@Transactional 
	@Override
	public int delete(int replyNo, int replyBno) throws Exception{
		LOGGER.info("replyNo = " + replyNo + "replyBno = " + replyBno);
		replyDao.delete(replyNo);
		LOGGER.info("댓글 삭제 성공");
		
		boardDao.updateReplyCount(-1, replyBno);
		LOGGER.info("게시판 댓글 개수 업데이트 성공");
		return 1;
	}
}












