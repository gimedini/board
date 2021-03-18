package goottgirls.web.board.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import goottgirls.web.board.domain.EventVO;
import goottgirls.web.board.pageutil.PageCriteria;



@Repository // @Component
// - 영속 계층(Persistence Layer)의 DB 관련 기능을 담당
// - Spring Component bean으로 등록함
// - 스프링 프레임워크가 bean을 생성하기 위해서는
// root-context.xml에 bean으로 등록해야함
// - <context:component-scan ... />
public class EventDAOImple implements EventDAO {
	private static final Logger LOGGER = 
	         LoggerFactory.getLogger(EventDAOImple.class);
	   private static final String NAMESPACE = 
	         "goottgirls.web.EventMapper"; // mapper랑 연결
	   
	   // Mybatis의 sqlSession을 사용하기 위해서
	   // 스프링 프레임워크가 생성한 bean을 주입(injection)받음
	   @Autowired
	   private SqlSession sqlSession;
	
	// 전체선택
	@Override
	public List<EventVO> select() {
		LOGGER.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
		// .select_all : board-mapper.xml의 id와 매칭
	}

	// 1개 선택
	@Override
	public EventVO select(int bno) {
		LOGGER.info("select() 호출 : bno = " + bno);
		return sqlSession.selectOne(NAMESPACE + ".select_by_bno", bno);
	}

	// 등록
	@Override
	public int insert(EventVO vo) {
		LOGGER.info("insert() 호출");
		// DAO까지 잘만들어졌는지 확인 - 단일 테스트
		// 이유 : @Repository객체가 잘 생성되는지 보기 위해
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	// 수정
	@Override
	public int update(EventVO vo) {
		LOGGER.info("update() 호출");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	// 삭제
	@Override
	public int delete(int bno) {
		LOGGER.info("delete() 호출");
		return sqlSession.delete(NAMESPACE + ".delete", bno);
	}

	// 테이블 전체 데이터 갯수 가져오기
	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() 호출");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	// 페이징 처리
	// PageCritetia의 getter/setter 가져옴
	@Override
	public List<EventVO> select(PageCriteria criteria) {
		LOGGER.info("select() 호출 : page = " + criteria.getPage());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	// 작성자 검색
	@Override
	public List<EventVO> select(String userid) {
		LOGGER.info("select() 호출 : userid = " + userid);
		// 누군가 userid 앞뒤에 %를 넣어줘야 한다.(쿼리에 있는)
		// select * from test_board
		// where userid like '%t%';
		userid = "%" + userid + "%";
		
		return sqlSession.selectList(NAMESPACE + ".select_by_userid" , userid);
	}

	// 제목 or 내용 검색
	@Override
	public List<EventVO> selectByTitleOrContent(String keyword) {
		LOGGER.info("selectByTitleOrContent() : kwyword = " + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_title_content", keyword);
	}

}
