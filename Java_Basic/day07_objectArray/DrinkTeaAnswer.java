package day07_objectArray;
import day06_object.Drink;

public class DrinkTeaAnswer {
		private String name;
		private int price;
		private int cnt;
		
		public DrinkTeaAnswer(String name, int price , int cnt) {
			this.name=name; this.price=price; this.cnt=cnt;
		}
		
		public int getTotal() {
			return price*cnt;
		}

		public void getData() {
			System.out.println(name+"\t : "+price+"��, "+cnt+"�� "+" : �� "+getTotal()+"��");
		}

		public static void main(String[] args) {
			Drink[] arr=new Drink[100];
			arr[0]=new Drink("Ŀ��",3000,3);
			arr[1]=new Drink("ī���",4000,2);
			int sum=0;

			for(int i=0; i<arr.length; i++) {
				if(arr[i]==null)break;
				arr[i].getData();
				sum+=arr[i].getTotal();
			}
			System.out.println("�� �Ǹž� : "+sum);
		}
}
