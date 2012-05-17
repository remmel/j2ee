package fr.solutec.gestionStocks.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author achankimponne
 * 
 */
public abstract class BaseController {
	public static final String GLOBAL_MESSAGES_KEY = "globalMessages";
	public static final String GLOBAL_ERRORS_KEY = "globalErrors";

	public void addGlobalMessage(HttpServletRequest request, String key) {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) request.getSession()
				.getAttribute(GLOBAL_MESSAGES_KEY);

		if (messages == null) {
			messages = new ArrayList<String>();
		}

		messages.add(key);
		request.getSession().setAttribute(GLOBAL_MESSAGES_KEY, messages);
	}

	public void addGlobalError(HttpServletRequest request, String key) {
		@SuppressWarnings("unchecked")
		List<String> errors = (List<String>) request.getSession().getAttribute(
				GLOBAL_ERRORS_KEY);

		if (errors == null) {
			errors = new ArrayList<String>();
		}

		errors.add(key);
		request.getSession().setAttribute(GLOBAL_ERRORS_KEY, errors);
	}
}
