package pe.crawler.main;

import pe.crawler.service.CrawlerService;
import pe.crawler.service.CrawlerServiceImpl;
import pe.crawler.util.Constant;

public class MicroserviceMain {

	private static CrawlerService service;

	public static void main(String[] args) {
		System.out.println("Iniciando Miroservice");

		String pathSites = null;
		if (args[0] != null) {
			pathSites = args[0];
			service = new CrawlerServiceImpl();

			service.pagesProcessor(pathSites, Constant.HASH_TAG_REGULAR_EXPRESSION);
		} else {
			System.out.println("Es necesario ingresar la ubicaci�n del archivo");
		}
	}

}
