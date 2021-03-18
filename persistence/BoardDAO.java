package goottgirls.web.board.persistence;

import java.util.List;

import goottgirls.web.board.domain.BoardVO;
import goottgirls.web.board.domain.CategoryVO;
import goottgirls.web.board.domain.NoticeVO;
import goottgirls.web.board.pageutil.PageCriteria;
import goottgirls.web.board.pageutil.SearchCriteria;



public interface BoardDAO {
	public abstract List<BoardVO> select();
	public abstract BoardVO select(int bno);
	public abstract int insert(BoardVO vo);
	public abstract int update(BoardVO vo);
	public abstract int delete(int bno);
	public abstract int getTotalNumsOfRecords();
	public abstract List<BoardVO> select(PageCriteria criteria);
	public abstract List<BoardVO> select(String userid);
	public abstract List<BoardVO> selectByTitleOrContent(String keyword);
	public abstract int updateReplyCount(int amount, int replyBno);
	
	int replyExist(int reply_count);
	// 카테고리
	List<CategoryVO> category() throws Exception;
	
	// 게시물 (페이징 처리 + 검색결과 게시물 조회)
	List<NoticeVO> list(SearchCriteria searchCriteria) throws Exception;
	
	// 게시물 총 갯수
	int listCount(SearchCriteria searchCriteria) throws Exception;
}













