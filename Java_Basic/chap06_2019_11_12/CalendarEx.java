package chap06_2019_11_12;

import java.util.Calendar;

public class CalendarEx {
	public static void printCalendar(String msg,Calendar  cal){
		int year = cal.get(Calendar.YEAR); //년
		int month = cal.get(Calendar.MONTH)+1; //월
		int day = cal.get(Calendar.DAY_OF_MONTH);//일
		System.out.println(year +"/" + month+"/"+day);
		//요일(1:일, 2:월, 3:화, 4:수, 5:목, 6:금, 7:토)
		int dayofWeek = cal.get(Calendar.DAY_OF_WEEK);
		String yul ="";
		switch(dayofWeek) {
		case Calendar.SUNDAY : yul="일";break;
		case Calendar.MONDAY: yul="월";break;
		case 3 :                                  yul ="화";break;
		case Calendar.WEDNESDAY : yul="수" ; break;
		case Calendar.THURSDAY : yul ="목" ; break;
		case Calendar.FRIDAY   : yul ="금";break;
		case Calendar.SATURDAY : yul ="토";
		}
		System.out.println("요일 : " +dayofWeek  +": " + yul);
		
	    String[] arr = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
	    System.out.println("배열요일 : " + arr[dayofWeek-1]);
		//시
		int h = cal.get(Calendar.HOUR);
		int ampm = cal.get(Calendar.AM_PM);
		String t ="";
		if(ampm==Calendar.AM) {
			t="오전";
		}else {
			t="오후";
		}
		int hourofDay = cal.get(Calendar.HOUR_OF_DAY);
		//분
		int m = cal.get(Calendar.MINUTE);
		//초
		int s = cal.get(Calendar.SECOND);
		System.out.println("현재시각 :" +t +":"+  h +":"+m+":"+s);
		System.out.println("현재시각 :" + hourofDay +":"+m+":"+s);
		
	}

	public static void main(String[] args) {
	 Calendar now = Calendar.getInstance();
	  printCalendar("현재 ", now);
	  String[] arrday = {"일요일","월요일","화요일","수요일",
			                            "목요일","금요일","토요일"};
	  Calendar firstDate = Calendar.getInstance();
	  firstDate.clear();
	  firstDate.set(2019,11,25);  //2019년 12월 25일
	  //요일 구하기
	  System.out.println("요일 : "
	  + arrday[firstDate.get(Calendar.DAY_OF_WEEK)-1]) ;
	  
	  //자기자신의 생일인 birthDate 객체를 생성하고
	  //생일의 요일 구하기
	  Calendar birthDate = Calendar.getInstance();
	  birthDate.set(2018,11,25);  //2018년 12월 25
	  System.out.println("요일 : "
			  + arrday[birthDate.get(Calendar.DAY_OF_WEEK)-1]) ;
	}

}
