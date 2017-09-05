package pe.crawler.util;

import org.junit.Assert;
import org.junit.Test;

public class UtilTest {

	/**
	 * Test para probar la normalizacion de la url
	 */
	@Test
	public void normalizeUrl_OK() {
		String url = "www.google.com";
		Assert.assertEquals("http://www.google.com", Util.normalizeUrl(url));
	}

	/**
	 * Test para probar la extraccion del nombre de la pagina
	 */
	@Test
	public void getPageName_OK() {
		String url = "http://www.google.com";
		Assert.assertEquals("wwwgooglecom", Util.getPageName(url));
	}
}
