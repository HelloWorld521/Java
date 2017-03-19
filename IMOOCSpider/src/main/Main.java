package main;

import java.util.ArrayList;
import java.util.List;

import bean.Imooc;

public class Main {

	public static void main(String[] args) {
		String url = "http://www.imooc.com/wenda/detail/345252";
//		List<Imooc> imoocs = new ArrayList<Imooc>();
		Imooc imooc;
//		限定爬取数量
		for(int i=0; i<5;i++){		
			imooc = new Imooc(url);
//			imoocs.add(imooc);
			url = imooc.nextUrl;
			System.out.println(imooc);
		}
	}
}
