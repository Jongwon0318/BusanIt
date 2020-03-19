package chap06_2019_11_12;

import java.util.Calendar;

public class CalendarEx {
	public static void printCalendar(String msg,Calendar  cal){
		int year = cal.get(Calendar.YEAR); //��
		int month = cal.get(Calendar.MONTH)+1; //��
		int day = cal.get(Calendar.DAY_OF_MONTH);//��
		System.out.println(year +"/" + month+"/"+day);
		//����(1:��, 2:��, 3:ȭ, 4:��, 5:��, 6:��, 7:��)
		int dayofWeek = cal.get(Calendar.DAY_OF_WEEK);
		String yul ="";
		switch(dayofWeek) {
		case Calendar.SUNDAY : yul="��";break;
		case Calendar.MONDAY: yul="��";break;
		case 3 :                                  yul ="ȭ";break;
		case Calendar.WEDNESDAY : yul="��" ; break;
		case Calendar.THURSDAY : yul ="��" ; break;
		case Calendar.FRIDAY   : yul ="��";break;
		case Calendar.SATURDAY : yul ="��";
		}
		System.out.println("���� : " +dayofWeek  +": " + yul);
		
	    String[] arr = {"�Ͽ���","������","ȭ����","������","�����","�ݿ���","�����"};
	    System.out.println("�迭���� : " + arr[dayofWeek-1]);
		//��
		int h = cal.get(Calendar.HOUR);
		int ampm = cal.get(Calendar.AM_PM);
		String t ="";
		if(ampm==Calendar.AM) {
			t="����";
		}else {
			t="����";
		}
		int hourofDay = cal.get(Calendar.HOUR_OF_DAY);
		//��
		int m = cal.get(Calendar.MINUTE);
		//��
		int s = cal.get(Calendar.SECOND);
		System.out.println("����ð� :" +t +":"+  h +":"+m+":"+s);
		System.out.println("����ð� :" + hourofDay +":"+m+":"+s);
		
	}

	public static void main(String[] args) {
	 Calendar now = Calendar.getInstance();
	  printCalendar("���� ", now);
	  String[] arrday = {"�Ͽ���","������","ȭ����","������",
			                            "�����","�ݿ���","�����"};
	  Calendar firstDate = Calendar.getInstance();
	  firstDate.clear();
	  firstDate.set(2019,11,25);  //2019�� 12�� 25��
	  //���� ���ϱ�
	  System.out.println("���� : "
	  + arrday[firstDate.get(Calendar.DAY_OF_WEEK)-1]) ;
	  
	  //�ڱ��ڽ��� ������ birthDate ��ü�� �����ϰ�
	  //������ ���� ���ϱ�
	  Calendar birthDate = Calendar.getInstance();
	  birthDate.set(2018,11,25);  //2018�� 12�� 25
	  System.out.println("���� : "
			  + arrday[birthDate.get(Calendar.DAY_OF_WEEK)-1]) ;
	}

}
