package goottgirls.web.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goottgirls.web.board.domain.EventVO;
import goottgirls.web.board.pageutil.PageCriteria;
import goottgirls.web.board.persistence.EventDAO;



@Service // 컨트롤이 필요한 애들 @Component
// 스프링 프레임워크에게 서비스 계층(Service/Business layer)의
// 컴포넌트임을 알려주는 어노테이션
//나중에 dao를 두개 넣어, 2개실행할때 service 쓰인다.
public class EventServiceImple implements EventService {
	private static final Logger LOGGER = 
	         LoggerFactory.getLogger(EventServiceImple.class);
	
	@Autowired
	private EventDAO dao; // dao와 연결위해
			
	// Mybatis의 sqlSession을 사용하기 위해서
	// 스프링 프레임워크가 생성한 bean을 주입(injection)받음
	
	@Override
	public List<EventVO> read() {
		LOGGER.info("read() 호출");
		return dao.select();
	}

	@Override
	public EventVO read(int bno) {
		LOGGER.info("read() 호출 : bno = " + bno);
		return dao.select(bno);
	}

	@Override
	public int create(EventVO vo) {
		LOGGER.info("create() 호출");
		return dao.insert(vo);
	}

	@Override
	public int update(EventVO vo) {
		LOGGER.info("update() 호출");
		return dao.update(vo);
	}

	@Override
	public int delete(int bno) {
		LOGGER.info("delete() 호출");
		return dao.delete(bno);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() 호출");
		return dao.getTotalNumsOfRecords();
	}

	@Override
	public List<EventVO> read(PageCriteria criteria) {
		LOGGER.info("read() 호출 : page = " + criteria.getPage());
		return dao.select(criteria);
	}

}
