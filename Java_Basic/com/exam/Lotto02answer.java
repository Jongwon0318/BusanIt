package com.exam;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Lotto02answer {

	public static void main(String[] args) {
		
		try {
			Document doc;
			doc = Jsoup.connect("https://m.dhlottery.co.kr/common.do?method=main").get();
			Elements lottoDrwNo=doc.select("div.prizeresult");
			Elements titles=doc.select("div.section_title #lottoDrwNo");
			for(int i=0; i<titles.size(); i++) {
				String lottoCount=titles.get(i).select("strong").text();
				String lottoNum=lottoDrwNo.get(i).select(".num span").text();
				System.out.println(lottoCount+" : "+lottoNum);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
