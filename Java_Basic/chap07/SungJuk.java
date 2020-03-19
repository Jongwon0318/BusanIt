package chap07;

public class SungJuk {
	private String name;
	private int kor; // private int kor,eng,math;
	private int eng;
	private int math;
	
	public SungJuk(String name, int kor, int eng, int math) {
		this.name=name; this.kor=kor; this.eng=eng; this.math=math;
	}
	
	public String getName() {
		return name;
	}
	
	public int getKor() {
		return kor;
	}
	
	public int getEng() {
		return eng;
	}
	
	public int getMath() {
		return math;
	}
	
	
	public int total() {
		return (kor+eng+math);
	}
	
	public double average() {
		return (double)(kor+eng+math/3);
	}
	
	/*public static void main(String[] args) {
		SungJuk s1= new SungJuk("홍길동",100,80,70);
		SungJuk s2= new SungJuk("이순신",50,60,30);
		System.out.println(s1.name+"의 총점은 "+s1.total()+" 입니다."); 
		System.out.println(s2.name+"의 평균은 "+s2.average()+" 입니다."); 
	}*/
}