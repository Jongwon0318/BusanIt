package day06_object;

public class Gugudan {
	int dansu;
	public Gugudan(int dansu) {
		this.dansu=dansu;
	}
	
	public void viewData() {
		System.out.println("구구단 "+dansu+"단을 출력합니다.\n");
		for(int i=0; i<9; i++) {
			System.out.println(dansu+" * "+(i+1)+" = "+dansu*(i+1));
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Gugudan g1=new Gugudan(5);
		g1.viewData();
		Gugudan g2=new Gugudan(7);
		g2.viewData();
	}
}