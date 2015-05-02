/**
 * 过滤结果
 * @author matao
 *
 */
public class ResultData {
	private String linkText;
	private String linkHref;

	public ResultData(String linkText, String linkHref) {
		this.linkHref = linkHref;
		this.linkText = linkText;
	}

	public String getLinkHref() {
		return linkHref;
	}

	public String getLinkText() {
		return linkText;
	}

	public void setLinkHref(String linkHref) {
		this.linkHref = linkHref;
	}

	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}
}
