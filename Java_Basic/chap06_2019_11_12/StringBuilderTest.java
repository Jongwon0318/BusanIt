package chap06_2019_11_12;

public class StringBuilderTest {
	public static void main(String[] args) {
		String str ="string";
		StringBuffer sb = new StringBuffer(str);
		System.out.println(sb);
		sb.append("java");
		System.out.println(sb);
		sb.insert(2, "oracle");
		System.out.println(sb);
		System.out.println(sb.toString());
		sb.replace(1, 3, "database");
		System.out.println(sb);
		sb.delete(2, 5);
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		System.out.println(sb.charAt(3));
		
		StringBuilder sbu = new StringBuilder(str);
		sbu.append(" test ");
		System.out.println(sbu);

	}

}
