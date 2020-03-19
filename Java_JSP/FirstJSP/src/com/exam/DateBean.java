package com.exam;

import java.util.Calendar;

public class DateBean {
	private Calendar ca=Calendar.getInstance();
	private String[] arr= {"일","월","화","수","목","금","토"};
	
	public String getToday() {
		String str=ca.get(Calendar.YEAR)+"년\t";
		str+=(ca.get(Calendar.MONTH)+1)+"월\t";
		str+=ca.get(Calendar.DATE)+"일\t";
		str+=arr[(ca.get(Calendar.DAY_OF_WEEK)-1)]+"요일";
		return str;
	}

}