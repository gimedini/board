package goottgirls.web.board.persistence;

import java.util.List;

import goottgirls.web.board.domain.EventVO;
import goottgirls.web.board.pageutil.PageCriteria;



public interface EventDAO {

	public abstract List<EventVO> select(); // ��ü ����
	public abstract EventVO select(int bno); // 1�� ����
	public abstract int insert(EventVO vo); // ���
	public abstract int update(EventVO vo); // ����
	public abstract int delete(int bno); // ����
	
	// returnŸ�� int, ���̺� ��ü ������ ������ ��������
	public abstract int getTotalNumsOfRecords(); // �����Ͱ� ����� Ȯ���ϴ�
	
	// ����¡ ó��
	public abstract List<EventVO> select(PageCriteria criteria); // ����¡ó��
	
	// ����Ʈ���̵忡�� �����ϴ°� ����
	// �˻��� like Ű���带 ����Ͽ� 
	public abstract List<EventVO> select(String userid); // �ۼ��� �˻�
	
	// ���� �Ǵ� ���� �˻�
	public abstract List<EventVO> selectByTitleOrContent(String keyword); // ���� or ���� �˻�
}
