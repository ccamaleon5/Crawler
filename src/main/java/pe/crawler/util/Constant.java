package pe.crawler.util;

public class Constant {
	
	public static final String HASH_TAG_REGULAR_EXPRESSION = "\\B(\\#[a-zA-Z]+\\b)(?!;)";
	public static final String TWITTER_ACCOUNT_REGULAR_EXPRESSION = "^@?(\\w){1,15}$";
	public static final String URL_REGULAR_EXPRESSION="^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$";
	public static final String PROPER_NAME_REGULAR_EXPRESSION = "environment";
	

}
