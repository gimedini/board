package goottgirls.web.board.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import goottgirls.web.board.domain.NoticeVO;
import goottgirls.web.board.pageutil.PageCriteria;
import goottgirls.web.board.pageutil.SearchCriteria;
import goottgirls.web.board.service.NoticeService;

@Repository
public class NoticeDAOImple implements NoticeDAO{
	private static final Logger logger =
			LoggerFactory.getLogger(NoticeDAOImple.class);
	private static final String NAMESPACE =
			"goottgirls.web.NoticeMapper";
	
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public List<NoticeVO> select() {
		logger.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}

	@Override
	public NoticeVO select(int noticeNo) {
		logger.info("select() 호출 : no = " + noticeNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_no", noticeNo);
	}

	@Override
	public int insert(NoticeVO vo) {
		logger.info("insert() 호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public int update(NoticeVO vo) {
		logger.info("update() 호출");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int noticeNo) {
		logger.info("delete() 호출");
		return sqlSession.delete(NAMESPACE + ".delete", noticeNo);
	}

	@Override
	public int getTotalNumsOfRecords() {
		logger.info("getTotalNumsOfRecords() 호출");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	@Override
	public List<NoticeVO> select(PageCriteria criteria) {
		logger.info("select() 호출 : page = " + criteria.getPage());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	@Override
	public List<NoticeVO> select(String admin) {
		logger.info("select() 호출 : adminUser = " + admin);
		admin = "%" + admin + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_admin", admin);
	}

	@Override
	public List<NoticeVO> selectByTitleOrContent(String keyword) {
		logger.info("selectByTitleOrContent() : keyword" + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_title_content", keyword);
	}

	@Override
	public void updateViewCnt(int noticeNo) throws Exception{
		logger.info("조회수 notice_no = " + noticeNo);
	 sqlSession.update(NAMESPACE + ".updateViewCnt", noticeNo);	
		
	}

	// 게시물 목록 조회
	@Override
	public List<NoticeVO> list(SearchCriteria searchCriteria) throws Exception {
		logger.info("게시물 목록 조회 searchCriteria = " + searchCriteria);
		return sqlSession.selectList(NAMESPACE + ".paging", searchCriteria);
	}

	// 게시물 총 갯수
	@Override
	public int listCount(SearchCriteria searchCriteria) throws Exception {
		logger.info("게시물 총 갯수 seachCriteria = " + searchCriteria);
		return sqlSession.selectOne(NAMESPACE + ".listCount", searchCriteria);
	}







	







}
