package pe.crawler.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import pe.crawler.model.Result;
import pe.crawler.thread.CrawlerThread;
import pe.crawler.util.Util;

public class CrawlerServiceImpl implements CrawlerService {

	@Override
	public boolean pagesProcessor(String path, String pattern) {
		Collection<Callable<Result>> tasks = new ArrayList<>();

		List<String> urls = Util.getSites(path);

		if (urls.size() < 1) {
			return false;
		}

		for (String url : urls) {
			tasks.add(new CrawlerThread(url, pattern));
		}

		ExecutorService executor = Executors.newFixedThreadPool(urls.size());
		List<Future<Result>> results;
		try {
			results = executor.invokeAll(tasks);

			for (Future<Result> result : results) {
				Result resultPage = result.get();
				System.out.println("Resultado:" + resultPage.isSuccess());
			}
		} catch (InterruptedException e) {
			System.out.println("Error al procesar el hilo");
			System.out.println(e.getMessage());
		} catch (ExecutionException e) {
			System.out.println("Error en la ejecuci�n del hilo");
			System.out.println(e.getMessage());
		}
		executor.shutdown();
		return false;
	}

}
