package review_ex;

public class BBS {
	String name,title,content;
	String year;
	
	public BBS(String name, String year, String title, String content) {
		this.name=name; this.year=year; this.title=title; this.content=content;
	}
	
	public static int no;
	
	public void print() {
		System.out.println("�۹�ȣ : "+ ++no);
		System.out.println("�̸� : "+name);
		System.out.println("�ۼ����� : "+year);
		System.out.println("���� : "+title);
		System.out.println("���� : "+content+"\n");
	}
	
	public static void main(String[] args) {
		BBS b1= new BBS("ȫ�浿","2019","����1","����1");
		b1.print();
		BBS b2= new BBS("�̼���","2018","����2","����2");
		b2.print();
		BBS b3= new BBS("������","2019","����3","����3");
		b3.print();
	}
}
