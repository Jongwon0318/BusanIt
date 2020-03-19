package chap05;

public class AbsShapeMain {

	public static void main(String[] args) {
		AbsCircle c1=new AbsCircle();
		c1.draw();
		c1.print();
		c1.move();
		System.out.println();
		
		AbsSquare s1=new AbsSquare();
		s1.draw();
		s1.print();
		s1.move();
		System.out.println();
		
		AbsShape a1= new AbsCircle(); 
		//a1은 AbsShape 객체이고 AbsCircle의 오버라이딩 된 메소드 접근가능
		a1.draw();
		a1.print();
		a1.move();
		System.out.println();
		
		AbsProduct ap=new AbsComputer();
		ap.turnOn();
		ap.print();
		ap.turnOff();
				
	}
}