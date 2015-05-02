import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.org.apache.regexp.internal.REUtil;


public class ParseService {
	/**
	 * 按Rule中的规则解析处ResultData中的数据
	 * @param rule
	 * @return
	 */
	public static List<ResultData> parse(Rule rule) {
		validate(rule);
		List<ResultData> resultDatas = new ArrayList<>();
		ResultData data = null;
		String url = rule.getUrl();
		HashMap<String, String> params = rule.getParams();
		String filterTagName = rule.getFilterTagName();
		int type = rule.getType();
		int requestMethod = rule.getRequestMethod();
		try {
			Connection conn = Jsoup.connect(url);
			if (params != null) {
				conn.data(params);
			}
			Document doc = null;
			switch (requestMethod) {
			case Rule.GET:
				doc = conn.timeout(30 * 1000).get();
				break;
			case Rule.POST:
				doc = conn.timeout(30 * 1000).post();
				break;
			default:
				break;
			}
			Elements elements = new Elements();
			switch (type) {
			case Rule.ID:
				elements.add(doc.getElementById(filterTagName));
				break;
			case Rule.CLASS:
				elements = doc.getElementsByClass(filterTagName);
				break;
			case Rule.SELECTION:
				elements = doc.select(filterTagName);
				break;
			default:
				elements = doc.getElementsByTag("body");
				break;
			}
			for (Element element : elements) {
				Elements linkInfos = element.getElementsByTag("a");
				for (Element linkInfo : linkInfos) {
					String linkHref = linkInfo.attr("href");
					String linkText = linkInfo.text();
					data = new ResultData(linkText, linkHref);
					resultDatas.add(data);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultDatas;
	}
	
	private static void validate(Rule rule) {
		String url = rule.getUrl();
		if (url == null || url.isEmpty()) {
			throw new RuleException("url can't be null or empty");
		}
		
		if (!url.startsWith("http") && !url.startsWith("https")) {
			throw new RuleException("wrong url");
		}
	}
}
