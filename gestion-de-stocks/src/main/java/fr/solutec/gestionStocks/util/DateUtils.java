package fr.solutec.gestionStocks.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Classe utilitaire de manipulation des dates
 * 
 * @author achankimponne
 * 
 */
public class DateUtils {
	public static final SimpleDateFormat FORMAT_DDMMYYYY = new SimpleDateFormat(
			"dd/MM/yyyy");

	public static Date stringToDate(String date, SimpleDateFormat format)
			throws ParseException {
		if (date == null || format == null) {
			throw new ParseException(
					"SimpleDateFormat or date to parse is null", 0);
		}
		return format.parse(date);
	}

	public static String dateToString(Date date, SimpleDateFormat format) {
		if (date == null || format == null) {
			return null;
		}
		return format.format(date);
	}

	public static Date getCurrentDate() {
		Calendar currentDate = Calendar.getInstance();
		return currentDate.getTime();
	}

}
