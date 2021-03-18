package goottgirls.web.board.service;

import java.util.List;

import goottgirls.web.board.domain.EventVO;
import goottgirls.web.board.pageutil.PageCriteria;



// CRUD(Create, Read, Update, Delete)
// Service : 중간에서 명확하게 해주거나, 트랜직션에서 사용할때 쓰인다
public interface EventService {
	public abstract List<EventVO> read();
	public abstract EventVO read(int bno);
	public abstract int create(EventVO vo);
	public abstract int update(EventVO vo);
	public abstract int delete(int bno);
	public abstract int getTotalNumsOfRecords();
	public abstract List<EventVO> read(PageCriteria criteria);
	// 검색은 나중에 추가해보세용
}
