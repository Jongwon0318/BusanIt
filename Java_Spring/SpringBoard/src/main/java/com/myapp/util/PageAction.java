package com.myapp.util;

import org.springframework.stereotype.Component;

@Component
public class PageAction {
	public String paging(int count, int pageSize, int currentPage, String field, String word) {
		//count : DB 행 갯수
		//pageSize : 한페이지에 들어가는 행 갯수
		//currentPage : 현재 페이지 번호
		
		// 페이지 수
		int pageCount = (count/pageSize) + (count % pageSize == 0 ? 0 : 1);
		
		int pageBlock = 3;

		//O
		int startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;
		
		//O
		int endPage = startPage + pageBlock - 1;
		
		//O
		if (endPage > pageCount)	endPage = pageCount;

		StringBuilder sb = new StringBuilder();
		
		if (count > 0) {
			// 이전
			if (startPage > pageBlock) {
				sb.append("<a href='list?");
				sb.append("pageNum="+(startPage-pageBlock));
				sb.append("&&field="+field+"");
				sb.append("&&word="+word+"'");
				sb.append(" class='text-dark'>[이전]</a>");
		}
		
		// 페이지 출력
		for (int i = startPage; i<=endPage; i++) {
				if(i==currentPage) {
					sb.append("&nbsp;<span class='text-danger'>["+i+"]</span>&nbsp;");
				}else {
					sb.append("&nbsp;<a href='list?");
					sb.append("pageNum="+i);
					sb.append("&&field="+field);
					sb.append("&&word="+word+"' class='text-dark'>");
					sb.append(i);
					sb.append("</a>&nbsp;");
				}
		}

		// 다음
		if (endPage < pageCount) {
				sb.append("<a href='list?");
				sb.append("pageNum="+(startPage+pageBlock));
				sb.append("&&field="+field+"");
				sb.append("&&word="+word+"' class='text-dark' >");
				sb.append("[다음]</a>");
			}
		}

		return sb.toString();
	}
}
