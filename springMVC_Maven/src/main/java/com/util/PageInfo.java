package com.util;

public class PageInfo {

	private String 	searchField;
	private String 	searchText;
	private int		start;
	private int		end;
	private String	pageNo = "1";
	private int		numPerPage = 5;
	
	// DB에서 가져올 start , end 값 설정 
	public void setPageBlock(int currentPage){
		start 	= (currentPage-1)*numPerPage + 1;
		end 	= currentPage * numPerPage; 
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public String getPageNo() {
		return pageNo;
	}

	// pageNo NULL 값이면 1로 설정 
	public void setPageNo(String pageNo) {
		if(pageNo == null || "".equals(pageNo)){
			this.pageNo = "1";
		}else{
			this.pageNo = pageNo;
		}
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
	
	
}
