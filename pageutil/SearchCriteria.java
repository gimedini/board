package goottgirls.web.board.pageutil;

import java.util.Date;

public class SearchCriteria extends PageCriteria{
//	private Date startDate, endDate; // ��¥Ÿ��
	
	private String searchType = ""; // �˻�Ÿ��
	private String keyword = ""; // �˻�Ű����
	
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
