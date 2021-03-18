package goottgirls.web.board.service;

import java.util.List;

import goottgirls.web.board.domain.NoticeVO;
import goottgirls.web.board.pageutil.PageCriteria;
import goottgirls.web.board.pageutil.SearchCriteria;

public interface NoticeService {

	List<NoticeVO> read();
	NoticeVO read(int noticeNo) throws Exception;
	int create(NoticeVO vo);
	int update(NoticeVO vo);
	int delete(int noticeNo);
	int getTotalNumsOfRecords();
	List<NoticeVO> read(PageCriteria criteria);
	
	// 게시물 목록조회
	List<NoticeVO> list(SearchCriteria searchCriteria) throws Exception;
	
	// 게시물 총 갯수
	int listCount(SearchCriteria searchCriteria) throws Exception;
	


}
