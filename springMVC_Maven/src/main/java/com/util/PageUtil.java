package com.util;

public class PageUtil {

	// 총페이지수 계산하는 메소드 : 페이지수, 데이터건수 
	public static int getPageCnt(int numPerPage, int totalCnt){
		// 총페이지수 
		int pageCnt = 0;			
		
		pageCnt = totalCnt / numPerPage;
		
		if (totalCnt % numPerPage != 0){
			pageCnt++;
		}	
		return pageCnt;
	}
	
	// 현재 페이지 설정 
	public static int setCurrentPage(String pageNo, int pageCnt){
		int currentPage = 0;
		if(pageNo != null){
			currentPage = Integer.parseInt(pageNo);
		}else{
			currentPage = 1;
		}
		if(currentPage == 0){
			currentPage = 1;
		}
		if(currentPage > pageCnt ){
			currentPage=pageCnt;
		}
		return currentPage;
	}
	
	// 페이징 인덱스
	public static String pageIndexList(int currentPage, int pageCnt, String menu){
		// pageBlock : 전체 페이지가 11개일 때, 한번에 보여지는 페이지 수 [<<][이전]1 2 3 4 5[다음][>>]
		int numPerBlock = 5;
		
		// 표시할 페이지 첫 페이지 수 
		int currentPageSetup = 0;
		int page = 0;
		
		// 페이징 인덱스를 문자열로 저장하기 위한 StringBuffer 객체 생성 
		StringBuffer sb = new StringBuffer();
		
		// 현재 페이지나  총페이지수가 0이면 공백 리턴 
		if(currentPage == 0 && pageCnt == 0){
			return "";
		}
		// 현재 8페이지라면 [이전]을 눌러서 이전 블럭으로 페이지 이동
		// 8/5 = 1 *5 = 5 : [이전]을 누르면 5페이지로 이동  
		// 이전 블럭의 마지막 페이지를 구하는 공식 
		currentPageSetup = (currentPage/numPerBlock)*numPerBlock;
		
		// 현재 페이지가 블럭의 마지막 페이지라면, 블럭의첫페이지-블럭수 한 값을 넣음
		if (currentPage %numPerBlock == 0){
			currentPageSetup = currentPageSetup - numPerBlock;
		}
		
		//if(pageCnt > numPerBlock && currentPageSetup > 0 ){
		//	sb.append("<a href=\"javascript:page('1', '"+menu+"');\">[<<]</a>&nbsp;");
		//	sb.append("<a href=\"javascript:page('"+currentPageSetup+"', '"+menu+"');\">[이전]</a>");
		//}else{
			sb.append("<a href=\"javascript:page('1', '"+menu+"');\">[<<]</a>&nbsp;");
			sb.append("<a href=\"javascript:page('"+ (currentPage-1) +"', '"+menu+"');\">[前へ]</a>");
		//}
		page = currentPageSetup + 1;
		
		if(pageCnt > numPerBlock){
			while(page <= pageCnt && page <= (currentPageSetup+numPerBlock)){
				if(page == currentPage){
					sb.append("<span style=\"color:red;\">"+page+"</span>&nbsp;");
				}else{
					sb.append("<a href=\"javascript:page('"+page+"', '"+menu+"');\">"+page+"</a>&nbsp;");
				}
				page++;
			}			
		}else{
			sb.append("<span style=\"color:red;\">"+page+"</span>&nbsp;");
		}

		
		//if(pageCnt - currentPageSetup > numPerBlock ){
		//	sb.append("<a href=\"javascript:page('"+page+"', '"+menu+"');\">[다음]</a>&nbsp;");
		//	sb.append("<a href=\"javascript:page('"+pageCnt+"', '"+menu+"');\">[>>]</a>&nbsp;");
		//}else{
			sb.append("<a href=\"javascript:page('"+(currentPage+1)+"', '"+menu+"');\">[次へ]</a>&nbsp;");
			sb.append("<a href=\"javascript:page('"+pageCnt+"', '"+menu+"');\">[>>]</a>&nbsp;");
		//}		
		return sb.toString();
	}
}
