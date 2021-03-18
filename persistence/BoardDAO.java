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
	// ī�װ�
	List<CategoryVO> category() throws Exception;
	
	// �Խù� (����¡ ó�� + �˻���� �Խù� ��ȸ)
	List<NoticeVO> list(SearchCriteria searchCriteria) throws Exception;
	
	// �Խù� �� ����
	int listCount(SearchCriteria searchCriteria) throws Exception;
}













