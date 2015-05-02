import java.util.HashMap;

/**
 * 过滤规则
 * @author matao
 *
 */
public class Rule {
	public static final int GET = 0;
	public static final int POST = 1;
	public static final int CLASS = 0;
	public static final int ID = 1;
	public static final int SELECTION = 2;
	
	private String url; 					//链接
	private HashMap<String, String> params; //参数
	private String filterTagName;			//过滤名称
	private int type = ID; 					//CLASS / ID / SELECTION 
											//设置filterTagName的类型，默认为ID  
	private int requestMethod = GET;		//默认GET请求
	
	public Rule(String url, HashMap<String, String> params,
			String filterTagName, int type, int requestMethod) {
		super();
		this.url = url;
		this.params = params;
		this.filterTagName = filterTagName;
		this.type = type;
		this.requestMethod = requestMethod;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public HashMap<String, String> getParams() {
		return params;
	}
	
	public void setParams(HashMap<String, String> params) {
		this.params = params;
	}
	
	public String getFilterTagName() {
		return filterTagName;
	}

	public void setFilterTagName(String filterTagName) {
		this.filterTagName = filterTagName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(int requestMethod) {
		this.requestMethod = requestMethod;
	}
}
