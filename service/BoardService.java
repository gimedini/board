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
	
	// ī�װ�
		List<CategoryVO> category() throws Exception;
		
		// �Խù� �����ȸ
		List<NoticeVO> list(SearchCriteria searchCriteria) throws Exception;
		
		// �Խù� �� ����
		int listCount(SearchCriteria searchCriteria) throws Exception;
}
















