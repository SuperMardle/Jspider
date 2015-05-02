import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {

	public static void main(String[] args) {
		HashMap<String, String> params = new HashMap<>();
		params.put("word", "支付宝");
		Rule rule = new Rule("http://news.baidu.com/ns", params, "c-title", Rule.CLASS, Rule.GET);
		List<ResultData> resultDatas = ParseService.parse(rule);
		printResult(resultDatas);
		
//		try {
//			Connection conn = Jsoup.connect("http://news.baidu.com/ns");
//			HashMap<String, String> params = new HashMap<>();
//			params.put("word", "支付宝");
//			conn.data(params);
//			Document doc = conn.get();
//			Elements elements = doc.getElementsByClass("c-title");
//			for (Element element : elements) {
//				Elements linkInfos = element.getElementsByTag("a");
//				for (Element linkInfo : linkInfos) {
//					System.out.println(linkInfo.text());
//					System.out.println(linkInfo.attr("href"));
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}

	public static void printResult(List<ResultData> resultDatas) {
		for (ResultData resultData : resultDatas) {
			System.out.println(resultData.getLinkText());
			System.out.println(resultData.getLinkHref());
			System.out.println("**********************");
		}
	}
}
