package day09;

public class PlayerManager {
	private final int MAX_INT=30;
	
	Player[] arr=new Player[MAX_INT];
	
	private int cnt;
	
	public void insertPlayer() {
		System.out.println("������ �Է��մϴ�.");
		System.out.print("�̸� : ");
		String name=PlayerMain.sc.nextLine(); // nextLine-->���� �ϳ��� �޴°�(���� ����)
		System.out.print("�ּ� : ");
		String address=PlayerMain.sc.nextLine(); //next-->�ܾ� �ϳ��� �޴� ��
		System.out.print("���� : ");
		int age=PlayerMain.sc.nextInt();
		System.out.print("Ű : ");
		double height=PlayerMain.sc.nextDouble();
		System.out.print("������ : ");
		double weight=PlayerMain.sc.nextDouble();
		arr[cnt++]=new Player(name,address,age,height,weight);
	}
	
	public void viewPlayer() {
		for(int i=0; i<cnt; i++) { //if(arr[i]==null) break;
			System.out.print("\n"+"�̸� : "+arr[i].getName()+"\t");
			System.out.print("�ּ� : "+arr[i].getAddress()+"\t");
			System.out.print("���� : "+arr[i].getAge()+"\t");
			System.out.print("Ű : "+arr[i].getHeight()+"\t");
			System.out.print("������ : "+arr[i].getWeight()+"\n");
		}
	}
	public void searchPlayer() {
		System.out.println("���� �̸��� �Է��ϼ���.");
		String searchName=PlayerMain.sc.next();
		Player p=search(searchName);
		if(p==null) {
			System.out.println("ã�� ���� ����");
			return; // void���� return;�� ���Ḧ ��Ÿ��.
		}
		System.out.print("\n"+"�̸� : "+p.getName()+"\t");
		System.out.print("�ּ� : "+p.getAddress()+"\t");
		System.out.print("���� : "+p.getAge()+"\t");
		System.out.print("Ű : "+p.getHeight()+"\t");
		System.out.print("������ : "+p.getWeight()+"\n");
	}
	
	private Player search(String searchName) { //35~>47��
		for(int i=0; i<cnt; i++) {
			if(searchName.equals(arr[i].getName())) {
				return arr[i]; //������ �����ִ� ��
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
				System.out.print("\n"+"�̸� : "+arr[i].getName()+"\t");
				System.out.print("�ּ� : "+arr[i].getAddress()+"\t");
				System.out.print("���� : "+arr[i].getAge()+"\t");
				System.out.print("Ű : "+arr[i].getHeight()+"\t");
				System.out.print("������ : "+arr[i].getWeight()+"\n");
			}
		}
		if(flag==true) {
			for(int i=searchCnt; i<=searchCnt; i++) {
				viewPlayer();
			}
		}
		if(flag==false) {
			System.out.println("ã�� ���� ����.");
		}*/
	}
