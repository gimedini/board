package goottgirls.web.board.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import goottgirls.web.board.domain.ReplyVO;



@Repository
public class ReplyDAOImple implements ReplyDAO{
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(ReplyDAOImple.class);
	private static final String NAMESPACE = 
			"goottgirls.web.ReplyMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(ReplyVO vo) {
		LOGGER.info("insert() ȣ��" + vo);
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<ReplyVO> select(int replyBno) {
		LOGGER.info("select() ȣ�� : replyBno = " + replyBno);
		return sqlSession.selectList(NAMESPACE + ".select_all_by_reply_bno", replyBno);
	}

	@Override
	public int update(ReplyVO vo) {
		LOGGER.info("update() ȣ��" + vo);
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int replyNo) {
		LOGGER.info("delete() ȣ�� : replyNo = " + replyNo);
		return sqlSession.delete(NAMESPACE + ".delete", replyNo);
	}

}




