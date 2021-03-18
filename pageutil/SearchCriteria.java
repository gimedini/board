package goottgirls.web.board.pageutil;

import java.util.Date;

public class SearchCriteria extends PageCriteria{
//	private Date startDate, endDate; // 날짜타입
	
	private String searchType = ""; // 검색타입
	private String keyword = ""; // 검색키워드
	
	public SearchCriteria() {}

	public SearchCriteria(String searchType, String keyword) {
		super();
		this.searchType = searchType;
		this.keyword = keyword;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + "]";
	}


	
}
