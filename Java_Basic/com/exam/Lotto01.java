package com.exam;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Lotto01 {

	public static void main(String[] args) {
		try {
			Document doc=
			Jsoup.connect("https://m.dhlottery.co.kr/gameResult.do?method=byWin").get();
			Elements ballNum=doc.select("span.ball");
			for(int i=0; i<ballNum.size(); i++) {
				String num=ballNum.get(i).text();
				System.out.print(num+"\t");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}