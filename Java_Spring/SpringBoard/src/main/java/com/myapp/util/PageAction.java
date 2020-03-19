package com.myapp.util;

import org.springframework.stereotype.Component;

@Component
public class PageAction {
	public String paging(int count, int pageSize, int currentPage, String field, String word) {
		//count : DB �� ����
		//pageSize : ���������� ���� �� ����
		//currentPage : ���� ������ ��ȣ
		
		// ������ ��
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
			// ����
			if (startPage > pageBlock) {
				sb.append("<a href='list?");
				sb.append("pageNum="+(startPage-pageBlock));
				sb.append("&&field="+field+"");
				sb.append("&&word="+word+"'");
				sb.append(" class='text-dark'>[����]</a>");
		}
		
		// ������ ���
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

		// ����
		if (endPage < pageCount) {
				sb.append("<a href='list?");
				sb.append("pageNum="+(startPage+pageBlock));
				sb.append("&&field="+field+"");
				sb.append("&&word="+word+"' class='text-dark' >");
				sb.append("[����]</a>");
			}
		}

		return sb.toString();
	}
}
