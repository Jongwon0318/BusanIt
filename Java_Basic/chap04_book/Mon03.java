package chap04_book;

class Song {
	private String title, artist, country;
	private int year;

	public Song() {}
	public Song(String title, String artist, String country, int year) {
		this.title=title; this.artist=artist; this.country=country; this.year=year;
	}
	public void show() {
		System.out.print(year+"�� "+country+"������ "+artist+"�� �θ� "+title+"\n");
		//System.out.println("\n"+"�뷡���� : "+title+"\n"+"���� : "+artist+"\n"+"��ǥ�� ���� : "+year+"\n"+"���� : "+country);
	}
}

/*public class Mon03 {
	public static void main(String[] args) {
		Song s1=new Song("Dancing Queen","ABBA","������",1978);
		s1.show();
	}
}*/
