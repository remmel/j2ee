package fr.solutec.gestionStocks.web.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller du login
 * 
 * @author achankimponne
 * 
 */
@Controller
public class LoginController {

	@RequestMapping(value = "/auth/login.htm", method = RequestMethod.GET)
	public ModelAndView getLoginPage(
			@RequestParam(value = "login_error", required = false) Integer error,
			ModelMap model) {

		if (error == null) {
			model.put("login_error", null);
		} else {
			model.put("login_error", error);
		}

		return new ModelAndView("LoginPage", model);

	}

	@RequestMapping(value = "/auth/accessDenied.htm", method = RequestMethod.GET)
	public String getAccessDeniedPage(ModelMap model) {
		return "AccessDeniedPage";

	}

}
