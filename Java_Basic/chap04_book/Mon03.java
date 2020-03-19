package chap04_book;

class Song {
	private String title, artist, country;
	private int year;

	public Song() {}
	public Song(String title, String artist, String country, int year) {
		this.title=title; this.artist=artist; this.country=country; this.year=year;
	}
	public void show() {
		System.out.print(year+"년 "+country+"국적의 "+artist+"가 부른 "+title+"\n");
		//System.out.println("\n"+"노래제목 : "+title+"\n"+"가수 : "+artist+"\n"+"발표된 연도 : "+year+"\n"+"국적 : "+country);
	}
}

/*public class Mon03 {
	public static void main(String[] args) {
		Song s1=new Song("Dancing Queen","ABBA","스웨덴",1978);
		s1.show();
	}
}*/
