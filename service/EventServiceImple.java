package goottgirls.web.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goottgirls.web.board.domain.EventVO;
import goottgirls.web.board.pageutil.PageCriteria;
import goottgirls.web.board.persistence.EventDAO;



@Service // ��Ʈ���� �ʿ��� �ֵ� @Component
// ������ �����ӿ�ũ���� ���� ����(Service/Business layer)��
// ������Ʈ���� �˷��ִ� ������̼�
//���߿� dao�� �ΰ� �־�, 2�������Ҷ� service ���δ�.
public class EventServiceImple implements EventService {
	private static final Logger LOGGER = 
	         LoggerFactory.getLogger(EventServiceImple.class);
	
	@Autowired
	private EventDAO dao; // dao�� ��������
			
	// Mybatis�� sqlSession�� ����ϱ� ���ؼ�
	// ������ �����ӿ�ũ�� ������ bean�� ����(injection)����
	
	@Override
	public List<EventVO> read() {
		LOGGER.info("read() ȣ��");
		return dao.select();
	}

	@Override
	public EventVO read(int bno) {
		LOGGER.info("read() ȣ�� : bno = " + bno);
		return dao.select(bno);
	}

	@Override
	public int create(EventVO vo) {
		LOGGER.info("create() ȣ��");
		return dao.insert(vo);
	}

	@Override
	public int update(EventVO vo) {
		LOGGER.info("update() ȣ��");
		return dao.update(vo);
	}

	@Override
	public int delete(int bno) {
		LOGGER.info("delete() ȣ��");
		return dao.delete(bno);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() ȣ��");
		return dao.getTotalNumsOfRecords();
	}

	@Override
	public List<EventVO> read(PageCriteria criteria) {
		LOGGER.info("read() ȣ�� : page = " + criteria.getPage());
		return dao.select(criteria);
	}

}
