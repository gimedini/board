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
	
	// �Խù� (����¡ ó�� + �˻���� �Խù� ��ȸ)
	List<NoticeVO> list(SearchCriteria searchCriteria) throws Exception;
	
	// �Խù� �� ����
	int listCount(SearchCriteria searchCriteria) throws Exception;
	
}
