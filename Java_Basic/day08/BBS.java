package day08;

public class BBS {	
	private String name,date,title,content;
	
	private static int no; //static : 공유해서 쓰는 개념, 다른 객체에 영향을 준다. 누구라고 지칭하지 않아도 된다. 혹은 앞에 클래스 이름이 들어갈 수 있다. (클래스.멤버변수)의 형태 - ex)BBS.no
	
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
		System.out.println("글번호 : "+ ++BBS.no); //static->공유, final->상수
		System.out.println("이름 : "+getName());
		System.out.println("작성일 : "+getDate());
		System.out.println("제목 : "+getTitle());
		System.out.println("내용 : "+getContent());
		System.out.println();
	}

	public static void main(String[] args) {
											//name, date, title, content
		BBS b1= new BBS("홍길동","2019","제목1","내용1");
		b1.print();
		BBS b2= new BBS("이순신","2018","제목2","내용2");
		b2.print();
		BBS b3= new BBS("강감찬","2019","제목3","내용3");
		b3.print();
	}

}
