package goottgirls.web.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goottgirls.web.board.domain.BoardVO;
import goottgirls.web.board.domain.CategoryVO;
import goottgirls.web.board.domain.NoticeVO;
import goottgirls.web.board.pageutil.PageCriteria;
import goottgirls.web.board.pageutil.SearchCriteria;
import goottgirls.web.board.persistence.BoardDAO;



@Service // @Component
// ������ �����ӿ�ũ���� ���� ����(Service/Business layer)��
// ���۳�Ʈ���� �˷��ִ� ������̼�
public class BoardServiceImple implements BoardService{
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(BoardServiceImple.class);
	
	@Autowired
	private BoardDAO dao;

	@Override
	public List<BoardVO> read() {
		LOGGER.info("read() ȣ��");
		return dao.select();
	}

	@Override
	public BoardVO read(int bno) {
		LOGGER.info("read() ȣ�� : bno = " + bno);
		return dao.select(bno);
	}

	@Override
	public int create(BoardVO vo) {
		LOGGER.info("create() ȣ��");
		return dao.insert(vo);
	}

	@Override
	public int update(BoardVO vo) {
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
	public List<BoardVO> read(PageCriteria criteria) {
		LOGGER.info("read() ȣ�� : page = " + criteria.getPage());
		return dao.select(criteria);
	}

	@Override
	public int replyExist(int reply_count) {
		// TODO Auto-generated method stub
		return dao.replyExist(reply_count);
	}
	
	@Override
	public List<CategoryVO> category() throws Exception {
		// TODO Auto-generated method stub
		return dao.category();
	}
	
	// �Խù� ��� ��ȸ
	@Override
	public List<NoticeVO> list(SearchCriteria searchCriteria) throws Exception {
		LOGGER.info("�Խù� ��� ��ȸ searchCriteria = " + searchCriteria);
		return dao.list(searchCriteria);
	}

	// �Խù� �� ����
	@Override
	public int listCount(SearchCriteria searchCriteria) throws Exception {
		LOGGER.info("�Խù� �� ���� = " + searchCriteria);
		return dao.listCount(searchCriteria);
	}

}



