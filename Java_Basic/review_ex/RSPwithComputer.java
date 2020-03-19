package review_ex;
import java.util.Scanner;

public class RSPwithComputer {
	public static void main(String[] args) {
		String[] computer= {"가위","바위","보"};
		Scanner sc=new Scanner(System.in);
		System.out.println("가위바위보를 시작합니다. 종료하시려면 '그만'을 입력해주세요.");

		while(true) {
			int r =(int)(Math.random()*3);
			System.out.println("\n"+"가위 바위 보!!");
			System.out.print("입력 : ");
			String player=sc.next();
			if(player.equals("그만")) {
				System.out.println("가위바위보를 종료합니다.");
				break;
			}
			if(computer[r].equals(player)) {
				System.out.println("\n"+"컴퓨터 : "+computer[r]);
				System.out.println("\n"+"Player : "+player);
				System.out.println("\n"+"비겼습니다.");
				continue;
			}else if(computer[r].equals("가위") && player.equals("바위")) {
				System.out.println("\n"+"컴퓨터 : "+computer[r]);
				System.out.println("\n"+"Player : "+player);
				System.out.println("\n"+"당신이 이겼습니다.");
				continue;
			}else if(computer[r].equals("가위") && player.equals("보")) {
				System.out.println("\n"+"컴퓨터 : "+computer[r]);
				System.out.println("\n"+"Player : "+player);
				System.out.println("\n"+"컴퓨터가 이겼습니다.");
				continue;
			}else if(computer[r].equals("바위") && player.equals("보")) {
				System.out.println("\n"+"컴퓨터 : "+computer[r]);
				System.out.println("\n"+"Player : "+player);
				System.out.println("\n"+"당신이 이겼습니다.");
				continue;
			}else if(computer[r].equals("바위") && player.equals("가위")) {
				System.out.println("\n"+"컴퓨터 : "+computer[r]);
				System.out.println("\n"+"Player : "+player);
				System.out.println("\n"+"컴퓨터가 이겼습니다.");
				continue;
			}else if(computer[r].equals("보") && player.equals("가위")) {
				System.out.println("\n"+"컴퓨터 : "+computer[r]);
				System.out.println("\n"+"Player : "+player);
				System.out.println("\n"+"당신이 이겼습니다.");
				continue;
			}else if(computer[r].equals("보") && player.equals("바위")) {
				System.out.println("\n"+"컴퓨터 : "+computer[r]);
				System.out.println("\n"+"Player : "+player);
				System.out.println("\n"+"컴퓨터가 이겼습니다.");
				continue;
			}
		}
	}
}
