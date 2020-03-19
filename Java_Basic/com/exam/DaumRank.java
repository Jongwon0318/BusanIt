package com.exam;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class DaumRank {

	public static void main(String[] args) {
		try {
			Document doc
			=Jsoup.connect("https://www.daum.net").get();
//			Elements ols = doc.select("ol.list_hotissue");
			Elements ols=doc.select("div.realtime_part");
			Elements rankcont =ols.select("div.rank_cont");
			for(int i=0; i<rankcont.size(); i++) {
				String rank=rankcont.get(i).select("span.txt_issue").text();
				System.out.println(rank);
				i++;
			}
//			System.out.println(doc);
//			System.out.println(ols);
//			System.out.println(rankcont.size());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}