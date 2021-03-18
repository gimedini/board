package goottgirls.web.board.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import goottgirls.web.board.domain.BoardVO;
import goottgirls.web.board.domain.CategoryVO;
import goottgirls.web.board.domain.NoticeVO;
import goottgirls.web.board.pageutil.PageCriteria;
import goottgirls.web.board.pageutil.SearchCriteria;

@Repository // @Component
// - ���� ����(Persistence Layer)�� DB ���� ����� ���
// - Spring Component bean���� �����
// - ������ �����ӿ�ũ�� bean�� �����ϱ� ���ؼ���
//   root-context.xml�� bean���� ����ؾ���
// - <context:component-scan ... />
public class BoardDAOImple implements BoardDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(BoardDAOImple.class);
	private static final String NAMESPACE = "goottgirls.web.BoardMapper";

	// MyBatis�� SqlSession�� ����ϱ� ���ؼ�
	// ������ �����ӿ�ũ�� ������ bean�� ����(injection)����
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BoardVO> select() {
		LOGGER.info("select() ȣ��");
		return sqlSession.selectList(NAMESPACE + ".select_all");
		// .select_all : board-mapper.xml�� id�� ��Ī
	}

	@Override
	public BoardVO select(int bno) {
		LOGGER.info("select() ȣ�� : bno = " + bno);
		return sqlSession.selectOne(NAMESPACE + ".select_by_bno", bno);
	}

	@Override
	public int insert(BoardVO vo) {
		LOGGER.info("insert() ȣ��");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public int update(BoardVO vo) {
		LOGGER.info("update() ȣ��");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int bno) {
		LOGGER.info("delete() ȣ��");
		return sqlSession.delete(NAMESPACE + ".delete", bno);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() ȣ��");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	@Override
	public List<BoardVO> select(PageCriteria criteria) {
		LOGGER.info("select() ȣ�� : page = " + criteria.getPage());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	@Override
	public List<BoardVO> select(String userid) {
		LOGGER.info("select() ȣ�� : userid = " + userid);
		userid = "%" + userid + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_userid", userid);
	}

	@Override
	public List<BoardVO> selectByTitleOrContent(String keyword) {
		LOGGER.info("selectByTitleOrContent() : keyword = " + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_title_content", keyword);
	}

	@Override
	public int updateReplyCount(int amount, int bno) {
		Map<String, Integer> args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("bno", bno);

		return sqlSession.update(NAMESPACE + ".update_reply_count", args);
	}

	@Override
	public int replyExist(int reply_count) {
		LOGGER.info("����� �����ϸ� = " + reply_count);
		return sqlSession.selectOne(NAMESPACE + ".replyExist", reply_count);
	}

	// ī�װ�
	@Override
	public List<CategoryVO> category() throws Exception {

		return sqlSession.selectList(NAMESPACE + ".category");
	}

	// �Խù� ��� ��ȸ
	@Override
	public List<NoticeVO> list(SearchCriteria searchCriteria) throws Exception {
		LOGGER.info("�Խù� ��� ��ȸ searchCriteria = " + searchCriteria);
		return sqlSession.selectList(NAMESPACE + ".paging", searchCriteria);
	}

	// �Խù� �� ����
	@Override
	public int listCount(SearchCriteria searchCriteria) throws Exception {
		LOGGER.info("�Խù� �� ���� seachCriteria = " + searchCriteria);
		return sqlSession.selectOne(NAMESPACE + ".listCount", searchCriteria);
	}

}
