package goottgirls.web.board.persistence;

import java.util.List;

import goottgirls.web.board.domain.NoticeVO;
import goottgirls.web.board.pageutil.PageCriteria;
import goottgirls.web.board.pageutil.SearchCriteria;

public interface NoticeDAO {
	List<NoticeVO> select();
	NoticeVO select(int noticeNo);
	int insert(NoticeVO vo);
	int update(NoticeVO vo);
	int delete(int noticeNo);
	int getTotalNumsOfRecords();
	List<NoticeVO> select(PageCriteria criteria);
	List<NoticeVO> select(String admin);
	List<NoticeVO> selectByTitleOrContent(String keyword);
	
	void updateViewCnt(int noticeNo) throws Exception;
	
	// 게시물 (페이징 처리 + 검색결과 게시물 조회)
	List<NoticeVO> list(SearchCriteria searchCriteria) throws Exception;
	
	// 게시물 총 갯수
	int listCount(SearchCriteria searchCriteria) throws Exception;
	
}
