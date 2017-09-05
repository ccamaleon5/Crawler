package pe.crawler.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Adrian
 * 
 *         Clase con operaciones utilitarias
 *
 */
public class Util {

	/**
	 * Normaliza la URL
	 * 
	 * @param url
	 * @return
	 */
	public static String normalizeUrl(String url) {
		if (!url.startsWith("http")) {
			url = "http://" + url;
		}

		if (url.endsWith("/")) {
			url = url.substring(0, url.length() - 1);
		}

		return url;
	}

	public static String getPageName(String url) {
		return url.substring(6, url.length()).replaceAll("[.|/]", "");
	}

	/**
	 * Escribe los patrones encontrados en un archivo
	 * 
	 * @param patternList
	 * @param fileName
	 * @return
	 */
	public static boolean writeListToFile(List<String> patternList, String fileName) {
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));) {
			for (String pattern : patternList) {
				out.println(pattern);
			}
			return true;
		} catch (FileNotFoundException | UnsupportedEncodingException e1) {
			System.out.println("No se encontro el archivo especificado");
			System.out.println(e1.getMessage());
			return false;
		} catch (IOException e) {
			System.out.println("Error en la escritura del archivo");
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * Obtiene los sitios de un archivo
	 * 
	 * @param path
	 * @return
	 */
	public static List<String> getSites(String path) {
		try {
			File file = new File(path);
			FileReader fr;
			fr = new FileReader(file);

			BufferedReader br = new BufferedReader(fr);
			String line;

			List<String> sites = new ArrayList<String>();
			while ((line = br.readLine()) != null) {
				sites.add(line);
			}
			br.close();
			fr.close();
			return sites;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}
}
