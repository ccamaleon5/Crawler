package pe.crawler.model;

public class Result {
	
	private String url;
	private boolean success;
	
	public Result(String pUrl,boolean pSuccess){
		url = pUrl;
		success = pSuccess;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

}
