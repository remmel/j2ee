package fr.solutec.gestionStocks.util;

/**
 * @author achankimponne
 * 
 */
public class StringUtils {

	public static boolean isNullOrEmpty(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isNotNullOrEmpty(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		return true;
	}
}
