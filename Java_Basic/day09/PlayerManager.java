package day09;

public class PlayerManager {
	private final int MAX_INT=30;
	
	Player[] arr=new Player[MAX_INT];
	
	private int cnt;
	
	public void insertPlayer() {
		System.out.println("선수를 입력합니다.");
		System.out.print("이름 : ");
		String name=PlayerMain.sc.nextLine(); // nextLine-->문장 하나를 받는것(띄어쓰기 포함)
		System.out.print("주소 : ");
		String address=PlayerMain.sc.nextLine(); //next-->단어 하나를 받는 것
		System.out.print("나이 : ");
		int age=PlayerMain.sc.nextInt();
		System.out.print("키 : ");
		double height=PlayerMain.sc.nextDouble();
		System.out.print("몸무게 : ");
		double weight=PlayerMain.sc.nextDouble();
		arr[cnt++]=new Player(name,address,age,height,weight);
	}
	
	public void viewPlayer() {
		for(int i=0; i<cnt; i++) { //if(arr[i]==null) break;
			System.out.print("\n"+"이름 : "+arr[i].getName()+"\t");
			System.out.print("주소 : "+arr[i].getAddress()+"\t");
			System.out.print("나이 : "+arr[i].getAge()+"\t");
			System.out.print("키 : "+arr[i].getHeight()+"\t");
			System.out.print("몸무게 : "+arr[i].getWeight()+"\n");
		}
	}
	public void searchPlayer() {
		System.out.println("선수 이름을 입력하세요.");
		String searchName=PlayerMain.sc.next();
		Player p=search(searchName);
		if(p==null) {
			System.out.println("찾는 선수 없음");
			return; // void에서 return;은 종료를 나타냄.
		}
		System.out.print("\n"+"이름 : "+p.getName()+"\t");
		System.out.print("주소 : "+p.getAddress()+"\t");
		System.out.print("나이 : "+p.getAge()+"\t");
		System.out.print("키 : "+p.getHeight()+"\t");
		System.out.print("몸무게 : "+p.getWeight()+"\n");
	}
	
	private Player search(String searchName) { //35~>47번
		for(int i=0; i<cnt; i++) {
			if(searchName.equals(arr[i].getName())) {
				return arr[i]; //선수를 돌려주는 것
			}
		}
		return null;
	}
	
		/*int searchCnt=0;
		boolean flag=false;
		for(int i=0; i<cnt; i++) {
			if(searchName.equals(arr[i].getName())) {
				searchCnt=i;
				flag=true;
				System.out.print("\n"+"이름 : "+arr[i].getName()+"\t");
				System.out.print("주소 : "+arr[i].getAddress()+"\t");
				System.out.print("나이 : "+arr[i].getAge()+"\t");
				System.out.print("키 : "+arr[i].getHeight()+"\t");
				System.out.print("몸무게 : "+arr[i].getWeight()+"\n");
			}
		}
		if(flag==true) {
			for(int i=searchCnt; i<=searchCnt; i++) {
				viewPlayer();
			}
		}
		if(flag==false) {
			System.out.println("찾는 선수 없음.");
		}*/
	}
