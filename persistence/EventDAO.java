package goottgirls.web.board.persistence;

import java.util.List;

import goottgirls.web.board.domain.EventVO;
import goottgirls.web.board.pageutil.PageCriteria;



public interface EventDAO {

	public abstract List<EventVO> select(); // 전체 선택
	public abstract EventVO select(int bno); // 1개 선택
	public abstract int insert(EventVO vo); // 등록
	public abstract int update(EventVO vo); // 수정
	public abstract int delete(int bno); // 삭제
	
	// return타입 int, 테이블 전체 데이터 갯수를 가져오는
	public abstract int getTotalNumsOfRecords(); // 데이터가 몇개인지 확인하는
	
	// 페이징 처리
	public abstract List<EventVO> select(PageCriteria criteria); // 페이징처리
	
	// 프론트사이드에서 전송하는것 구현
	// 검색시 like 키워드를 사용하여 
	public abstract List<EventVO> select(String userid); // 작성자 검색
	
	// 제목 또는 내용 검색
	public abstract List<EventVO> selectByTitleOrContent(String keyword); // 제목 or 내용 검색
}
