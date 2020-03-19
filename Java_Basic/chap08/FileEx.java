package chap08;

import java.io.File;

public class FileEx {
	public static void listDirectory(File dir) {
		System.out.println("-----"+dir.getPath()+"의 서브 리스트 입니다.-----");
		File[] subFiles=dir.listFiles();
		for(int i=0; i<subFiles.length; i++) {
			File f= subFiles[i];
			long t= f.lastModified();
			System.out.println(f.getName());
			System.out.println("\t파일 크기: "+f.length());
			System.out.printf("\t수정한 시간: %tb %td %ta %tT\n",t,t,t,t);
		}
	}
	public static void main(String[] args) {
		File f1=new File("c:\\windows\\system.ini");
		System.out.println(f1.getPath()+", "+f1.getParent()+", "+f1.getName()); //경로,상위폴더,자기이름을 불러오는 메소드
		
		String res="";
		if(f1.isFile()) res="파일";
		else if(f1.isDirectory()) res="디렉토리";
		System.out.println(f1.getPath()+" : "+res+"입니다.");
		
		File f2=new File("java_sample");
		if(f2.exists()==false) { //파일이 있는지 물어보는 메소드
			f2.mkdir(); //디렉토리 만드는 메소드
		}
		
		listDirectory(new File("src\\chap08"));
		f2.renameTo(new File("src\\chap08\\javasample")); //이름 바꾸는 메소드
		listDirectory(new File("src\\chap08"));
	}
}
