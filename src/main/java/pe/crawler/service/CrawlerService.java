package pe.crawler.service;

public interface CrawlerService {

	/**
	 * Metodo que procesa la lista de paginas
	 * 
	 * @param path Ruta de archivo
	 * @param pattern Patron para encontrar en la pagina
	 * @return
	 */
	public boolean pagesProcessor(String path, String pattern);

}
