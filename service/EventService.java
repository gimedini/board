package goottgirls.web.board.service;

import java.util.List;

import goottgirls.web.board.domain.EventVO;
import goottgirls.web.board.pageutil.PageCriteria;



// CRUD(Create, Read, Update, Delete)
// Service : �߰����� ��Ȯ�ϰ� ���ְų�, Ʈ�����ǿ��� ����Ҷ� ���δ�
public interface EventService {
	public abstract List<EventVO> read();
	public abstract EventVO read(int bno);
	public abstract int create(EventVO vo);
	public abstract int update(EventVO vo);
	public abstract int delete(int bno);
	public abstract int getTotalNumsOfRecords();
	public abstract List<EventVO> read(PageCriteria criteria);
	// �˻��� ���߿� �߰��غ�����
}
