package com.guestapp.util;

import org.springframework.stereotype.Component;

@Component
public class PageAction {
	public String paging(int count, int pageSize, int currentPage, String field, String word) {
		String file = "javascript:getData(";

		//count : DB �� ����
		//pageSize : ���������� ���� �� ����
		//currentPage : ���� ������ ��ȣ
		
		// ������ ��
		int pageCount = (count/pageSize) + (count % pageSize == 0 ? 0 : 1);
		System.out.println(pageCount);
		
		int pageBlock = 3;

		//O
		int startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;
		
		//O
		int endPage = startPage + pageBlock - 1;
		
		//O
		if (endPage > pageCount)	endPage = pageCount;

		StringBuilder sb = new StringBuilder();
		
		if (count > 0) {
			// ����
			if (startPage > pageBlock) {
				sb.append("<a href=");
				sb.append(file);
				sb.append((startPage-pageBlock));
				sb.append(",'"+field+"'");
				sb.append(",'"+word+"')");
				sb.append(">[����]</a>");
		}
		
		// ������ ���
		for (int i = startPage; i<=endPage; i++) {
				if(i==currentPage) {
					sb.append("["+i+"]");
				}else {
					sb.append("<a href=");
					sb.append(file);
					sb.append(i);
					sb.append(",'"+field+"'");
					sb.append(",'"+word+"')");
					sb.append(">");
					sb.append(i);
					sb.append("</a>");
				}
		}

		// ����
		if (endPage < pageCount) {
				sb.append("<a href=");
				sb.append(file);
				sb.append((startPage+pageBlock));
				sb.append(",'"+field+"'");
				sb.append(",'"+word+"')");
				sb.append(">[����]</a>");
			}
		}

		return sb.toString();
	}
}
