package com.exam;

import java.util.Calendar;

public class DateBean {
	private Calendar ca=Calendar.getInstance();
	private String[] arr= {"��","��","ȭ","��","��","��","��"};
	
	public String getToday() {
		String str=ca.get(Calendar.YEAR)+"��\t";
		str+=(ca.get(Calendar.MONTH)+1)+"��\t";
		str+=ca.get(Calendar.DATE)+"��\t";
		str+=arr[(ca.get(Calendar.DAY_OF_WEEK)-1)]+"����";
		return str;
	}

}