package com.exam;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Lotto02 {

	public static void main(String[] args) {
		try {
			Document doc=
			Jsoup.connect("https://m.dhlottery.co.kr/common.do?method=main").get();
			Elements codes=doc.select("div.prizeresult");
			Elements str1codes=doc.select("div.section_title");
			for(int i=0; i<5; i++) {
				String str=codes.get(i).select("div.num").text();
				String str1=str1codes.get(i).select("strong#lottoDrwNo").text();
				System.out.println(str1+" : "+str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
