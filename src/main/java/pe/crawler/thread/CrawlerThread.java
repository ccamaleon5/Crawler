package pe.crawler.thread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import pe.crawler.model.Result;
import pe.crawler.util.Util;

/**
 * @author Adriano 
 * 
 * Clase para obtener los patrones de la pagina principal
 *
 */
public class CrawlerThread implements Callable<Result> {

	private String url;
	private String pattern;

	public CrawlerThread(String pUrl, String pPattern) {
		this.url = pUrl;
		this.pattern = pPattern;
	}

	@Override
	public Result call() {
		Result result = new Result(this.url, true);
		try {
			Document doc = Jsoup.connect(url).get();
			Pattern findPattern = Pattern.compile(this.pattern);
			Matcher matcher = findPattern.matcher(doc.body().text());

			List<String> patternList = new ArrayList<String>();
			while (matcher.find()) {
				patternList.add(matcher.group());
			}

			Util.writeListToFile(patternList, Util.getPageName(url));
		} catch (IOException e) {
			result.setSuccess(false);
		}

		return result;
	}

}
