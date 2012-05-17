package fr.solutec.gestionStocks.util;

import java.text.DecimalFormat;

/**
 * @author achankimponne
 * 
 */
public class NumberUtils {
	public static final DecimalFormat MONTANT_2_DECIMALES = new DecimalFormat(
			"###.##");

	public static final String SEPARATEUR_VIRGULE_REGEX = "\\,";

	/**
	 * Parse un String en Double
	 * 
	 * @param s
	 * @param decimalSeparator
	 * @return
	 * @throws NumberFormatException
	 */
	public static Double stringToDouble(String s, String decimalSeparator)
			throws NumberFormatException {
		if (s == null || decimalSeparator == null) {
			throw new NumberFormatException(
					"decimal separator or String to parse is null");
		}

		return Double.parseDouble(s.replaceAll(decimalSeparator, "."));
	}

	/**
	 * Parse un Double en String
	 * 
	 * @param d
	 * @param formatter
	 * @return
	 */
	public static String doubleToString(Double d, DecimalFormat formatter) {
		if (d == null || formatter == null) {
			return null;
		}
		return formatter.format(d);
	}
}
