package goottgirls.web.board.service;

import java.util.List;

import goottgirls.web.board.domain.BoardVO;
import goottgirls.web.board.domain.CategoryVO;
import goottgirls.web.board.domain.NoticeVO;
import goottgirls.web.board.pageutil.PageCriteria;
import goottgirls.web.board.pageutil.SearchCriteria;



// CRUD(CREATE, READ, UPDATE, DELETE)
public interface BoardService {
	public abstract List<BoardVO> read();
	public abstract BoardVO read(int bno);
	public abstract int create(BoardVO vo);
	public abstract int update(BoardVO vo);
	public abstract int delete(int bno);
	public abstract int getTotalNumsOfRecords();
	public abstract List<BoardVO> read(PageCriteria criteria);
	
	int replyExist(int reply_count);
	
	// 카테고리
		List<CategoryVO> category() throws Exception;
		
		// 게시물 목록조회
		List<NoticeVO> list(SearchCriteria searchCriteria) throws Exception;
		
		// 게시물 총 갯수
		int listCount(SearchCriteria searchCriteria) throws Exception;
}
















