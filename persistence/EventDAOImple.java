package goottgirls.web.board.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import goottgirls.web.board.domain.EventVO;
import goottgirls.web.board.pageutil.PageCriteria;



@Repository // @Component
// - ���� ����(Persistence Layer)�� DB ���� ����� ���
// - Spring Component bean���� �����
// - ������ �����ӿ�ũ�� bean�� �����ϱ� ���ؼ���
// root-context.xml�� bean���� ����ؾ���
// - <context:component-scan ... />
public class EventDAOImple implements EventDAO {
	private static final Logger LOGGER = 
	         LoggerFactory.getLogger(EventDAOImple.class);
	   private static final String NAMESPACE = 
	         "goottgirls.web.EventMapper"; // mapper�� ����
	   
	   // Mybatis�� sqlSession�� ����ϱ� ���ؼ�
	   // ������ �����ӿ�ũ�� ������ bean�� ����(injection)����
	   @Autowired
	   private SqlSession sqlSession;
	
	// ��ü����
	@Override
	public List<EventVO> select() {
		LOGGER.info("select() ȣ��");
		return sqlSession.selectList(NAMESPACE + ".select_all");
		// .select_all : board-mapper.xml�� id�� ��Ī
	}

	// 1�� ����
	@Override
	public EventVO select(int bno) {
		LOGGER.info("select() ȣ�� : bno = " + bno);
		return sqlSession.selectOne(NAMESPACE + ".select_by_bno", bno);
	}

	// ���
	@Override
	public int insert(EventVO vo) {
		LOGGER.info("insert() ȣ��");
		// DAO���� �߸���������� Ȯ�� - ���� �׽�Ʈ
		// ���� : @Repository��ü�� �� �����Ǵ��� ���� ����
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	// ����
	@Override
	public int update(EventVO vo) {
		LOGGER.info("update() ȣ��");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	// ����
	@Override
	public int delete(int bno) {
		LOGGER.info("delete() ȣ��");
		return sqlSession.delete(NAMESPACE + ".delete", bno);
	}

	// ���̺� ��ü ������ ���� ��������
	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() ȣ��");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	// ����¡ ó��
	// PageCritetia�� getter/setter ������
	@Override
	public List<EventVO> select(PageCriteria criteria) {
		LOGGER.info("select() ȣ�� : page = " + criteria.getPage());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	// �ۼ��� �˻�
	@Override
	public List<EventVO> select(String userid) {
		LOGGER.info("select() ȣ�� : userid = " + userid);
		// ������ userid �յڿ� %�� �־���� �Ѵ�.(������ �ִ�)
		// select * from test_board
		// where userid like '%t%';
		userid = "%" + userid + "%";
		
		return sqlSession.selectList(NAMESPACE + ".select_by_userid" , userid);
	}

	// ���� or ���� �˻�
	@Override
	public List<EventVO> selectByTitleOrContent(String keyword) {
		LOGGER.info("selectByTitleOrContent() : kwyword = " + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_title_content", keyword);
	}

}
