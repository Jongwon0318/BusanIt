package day08;

public class BBS {	
	private String name,date,title,content;
	
	private static int no; //static : �����ؼ� ���� ����, �ٸ� ��ü�� ������ �ش�. ������� ��Ī���� �ʾƵ� �ȴ�. Ȥ�� �տ� Ŭ���� �̸��� �� �� �ִ�. (Ŭ����.�������)�� ���� - ex)BBS.no
	
	public BBS(String name, String date, String title, String content) {
		 this.name=name; this.date=date; this.title=title; this.content=content;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
	
	private void print() {
		System.out.println("�۹�ȣ : "+ ++BBS.no); //static->����, final->���
		System.out.println("�̸� : "+getName());
		System.out.println("�ۼ��� : "+getDate());
		System.out.println("���� : "+getTitle());
		System.out.println("���� : "+getContent());
		System.out.println();
	}

	public static void main(String[] args) {
											//name, date, title, content
		BBS b1= new BBS("ȫ�浿","2019","����1","����1");
		b1.print();
		BBS b2= new BBS("�̼���","2018","����2","����2");
		b2.print();
		BBS b3= new BBS("������","2019","����3","����3");
		b3.print();
	}

}
