package review_ex;

public class BBS {
	String name,title,content;
	String year;
	
	public BBS(String name, String year, String title, String content) {
		this.name=name; this.year=year; this.title=title; this.content=content;
	}
	
	public static int no;
	
	public void print() {
		System.out.println("글번호 : "+ ++no);
		System.out.println("이름 : "+name);
		System.out.println("작성연도 : "+year);
		System.out.println("제목 : "+title);
		System.out.println("내용 : "+content+"\n");
	}
	
	public static void main(String[] args) {
		BBS b1= new BBS("홍길동","2019","제목1","내용1");
		b1.print();
		BBS b2= new BBS("이순신","2018","제목2","내용2");
		b2.print();
		BBS b3= new BBS("강감찬","2019","제목3","내용3");
		b3.print();
	}
}
