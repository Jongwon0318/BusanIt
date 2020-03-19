package chap07;

import java.util.Iterator;
import java.util.Vector;

public class IteratorEx {
	public static void main(String[] args) {
		Vector<Integer>v = new Vector();
		v.add(5);
		v.add(new Integer(4));
		v.add(-1);
		v.add(2,100);
		for(Integer i : v) {
			System.out.print(i+"\t");
		}
		System.out.println();
		
		Iterator<Integer> it = v.iterator();
		while(it.hasNext()) {
			System.out.println(it.next()+"\t");
		}
		System.out.println();
		
		it = v.iterator();
		int sum=0;
		while(it.hasNext()) {
			sum+=it.next();
		}
		System.out.println("합계 "+sum); // 왜 0이 나올까?
		
		int hap=0;
		for(Integer i: v) {
			hap+=i;
		}
		System.out.println("for 합계 "+hap);
	} 
}
