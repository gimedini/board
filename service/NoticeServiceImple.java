package goottgirls.web.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import goottgirls.web.board.domain.NoticeVO;
import goottgirls.web.board.pageutil.PageCriteria;
import goottgirls.web.board.pageutil.SearchCriteria;
import goottgirls.web.board.persistence.NoticeDAO;

@Service
public class NoticeServiceImple implements NoticeService {
	private static final Logger logger =
			LoggerFactory.getLogger(NoticeServiceImple.class);
	
	@Autowired
	private NoticeDAO dao;
	
	@Override
	public List<NoticeVO> read() {
		logger.info("read() 호출");
		return dao.select();
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public NoticeVO read(int noticeNo) throws Exception{
		logger.info("read() 호출 : no = " + noticeNo);
		 dao.updateViewCnt(noticeNo);
		return dao.select(noticeNo);
	}

	@Override
	public int create(NoticeVO vo) {
		logger.info("create() 호출");
		return dao.insert(vo);
	}

	@Override
	public int update(NoticeVO vo) {
		logger.info("update() 호출");
		return dao.update(vo);
	}

	@Override
	public int delete(int noticeNo) {
		logger.info("delete() 호출");
		return dao.delete(noticeNo);
	}

	@Override
	public int getTotalNumsOfRecords() {
		logger.info("getTotalNumsOfRecords() 호출");
		return dao.getTotalNumsOfRecords();
	}

	@Override
	public List<NoticeVO> read(PageCriteria criteria) {
		logger.info("read() 호출 : page = " + criteria.getPage());
		
		return dao.select(criteria);
	}

	// 게시물 목록 조회
	@Override
	public List<NoticeVO> list(SearchCriteria searchCriteria) throws Exception {
		logger.info("게시물 목록 조회 searchCriteria = " + searchCriteria);
		return dao.list(searchCriteria);
	}

	// 게시물 총 갯수
	@Override
	public int listCount(SearchCriteria searchCriteria) throws Exception {
		logger.info("게시물 총 갯수 = " + searchCriteria);
		return dao.listCount(searchCriteria);
	}




}
