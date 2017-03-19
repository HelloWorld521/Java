package spider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bean.Imooc;

/**
 * 1.获取网页源码
 * 
 */
public class Spider {
	
	/**
	 * 获取网页源代码
	 * @param url 网址
	 * @return
	 */
	public static String getSource(String url){
		BufferedReader reader=null;
		String result = "";
		try {
			URL realUrl = new URL(url);
//			打开和url之间的连接
			URLConnection conn = realUrl.openConnection();
			
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line="";
			while((line=reader.readLine())!=null){
				result+=line;
			}
//			System.out.println(result);
			if(reader!=null)
				reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
//	测试是否获得慕课问答页面源码
//	测试是否获取问题的url
	public static void main(String[] args) {
		String url = "http://www.imooc.com/wenda";
		String regex = "class=\"content\".+?href=\"(.+?)\".+?</a>";
		String result = getSource(url);
		List<String> wendaUrl = getImoocPage(result,regex);
		System.out.println(wendaUrl);
	}


	
	
//	没有用到
/**
 * 获取问题页面url
 * @param quesSource 页面源码
 * @param regex      匹配正则表达式
 * @return
 */
	public static List<String> getImoocPage(String quesSource,String regex){
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(quesSource);
		List<String> quesUrl = new ArrayList<String>();
		while(matcher.find()){
			String url = "http://www.imooc.com"+matcher.group(1);
			quesUrl.add(url);
		}
//		System.out.println(quesUrl);	
		return quesUrl;
	}
	
}
