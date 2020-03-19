package review_ex;

public class Gugudan {
	int dansu;
	public Gugudan(int dansu) {
		this.dansu=dansu;
	}
	public void viewData() {
		System.out.println("\n"+"지금부터 구구단 "+dansu+"단을 욉니다."+"\n");
		for(int i=1; i<10; i++) {
			System.out.println(dansu+"*"+i+" = "+dansu*i);
		}
	}
	public static void main(String[] args) {
		Gugudan g1=new Gugudan(5);
		g1.viewData();
		Gugudan g2=new Gugudan(7);
		g2.viewData();
	}
}
