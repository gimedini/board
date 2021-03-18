package goottgirls.web.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goottgirls.web.board.domain.BoardVO;
import goottgirls.web.board.domain.CategoryVO;
import goottgirls.web.board.domain.NoticeVO;
import goottgirls.web.board.pageutil.PageCriteria;
import goottgirls.web.board.pageutil.SearchCriteria;
import goottgirls.web.board.persistence.BoardDAO;



@Service // @Component
// 스프링 프레임워크에게 서비스 계층(Service/Business layer)의
// 컴퍼넌트임을 알려주는 어노테이션
public class BoardServiceImple implements BoardService{
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(BoardServiceImple.class);
	
	@Autowired
	private BoardDAO dao;

	@Override
	public List<BoardVO> read() {
		LOGGER.info("read() 호출");
		return dao.select();
	}

	@Override
	public BoardVO read(int bno) {
		LOGGER.info("read() 호출 : bno = " + bno);
		return dao.select(bno);
	}

	@Override
	public int create(BoardVO vo) {
		LOGGER.info("create() 호출");
		return dao.insert(vo);
	}

	@Override
	public int update(BoardVO vo) {
		LOGGER.info("update() 호출");
		return dao.update(vo);
	}

	@Override
	public int delete(int bno) {
		LOGGER.info("delete() 호출");
		return dao.delete(bno);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() 호출");
		return dao.getTotalNumsOfRecords();
	}

	@Override
	public List<BoardVO> read(PageCriteria criteria) {
		LOGGER.info("read() 호출 : page = " + criteria.getPage());
		return dao.select(criteria);
	}

	@Override
	public int replyExist(int reply_count) {
		// TODO Auto-generated method stub
		return dao.replyExist(reply_count);
	}
	
	@Override
	public List<CategoryVO> category() throws Exception {
		// TODO Auto-generated method stub
		return dao.category();
	}
	
	// 게시물 목록 조회
	@Override
	public List<NoticeVO> list(SearchCriteria searchCriteria) throws Exception {
		LOGGER.info("게시물 목록 조회 searchCriteria = " + searchCriteria);
		return dao.list(searchCriteria);
	}

	// 게시물 총 갯수
	@Override
	public int listCount(SearchCriteria searchCriteria) throws Exception {
		LOGGER.info("게시물 총 갯수 = " + searchCriteria);
		return dao.listCount(searchCriteria);
	}

}



