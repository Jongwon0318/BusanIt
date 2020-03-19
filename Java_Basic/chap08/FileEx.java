package chap08;

import java.io.File;

public class FileEx {
	public static void listDirectory(File dir) {
		System.out.println("-----"+dir.getPath()+"�� ���� ����Ʈ �Դϴ�.-----");
		File[] subFiles=dir.listFiles();
		for(int i=0; i<subFiles.length; i++) {
			File f= subFiles[i];
			long t= f.lastModified();
			System.out.println(f.getName());
			System.out.println("\t���� ũ��: "+f.length());
			System.out.printf("\t������ �ð�: %tb %td %ta %tT\n",t,t,t,t);
		}
	}
	public static void main(String[] args) {
		File f1=new File("c:\\windows\\system.ini");
		System.out.println(f1.getPath()+", "+f1.getParent()+", "+f1.getName()); //���,��������,�ڱ��̸��� �ҷ����� �޼ҵ�
		
		String res="";
		if(f1.isFile()) res="����";
		else if(f1.isDirectory()) res="���丮";
		System.out.println(f1.getPath()+" : "+res+"�Դϴ�.");
		
		File f2=new File("java_sample");
		if(f2.exists()==false) { //������ �ִ��� ����� �޼ҵ�
			f2.mkdir(); //���丮 ����� �޼ҵ�
		}
		
		listDirectory(new File("src\\chap08"));
		f2.renameTo(new File("src\\chap08\\javasample")); //�̸� �ٲٴ� �޼ҵ�
		listDirectory(new File("src\\chap08"));
	}
}
