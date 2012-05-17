package fr.solutec.gestionStocks.web.employe;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import fr.solutec.gestionStocks.bean.Employe;
import fr.solutec.gestionStocks.service.IEmployeManager;
import fr.solutec.gestionStocks.web.BaseController;
import fr.solutec.gestionStocks.web.formBean.ModificationMotDePasseFormBean;

/**
 * @author achankimponne
 * 
 */
@Controller
public class MotDePasseController extends BaseController {
	/**
	 * Logger
	 */
	private static final Logger log = Logger.getLogger(EmployeController.class);

	/**
	 * Manager d'employe
	 */
	@Autowired
	@Qualifier("employeManager")
	private IEmployeManager employeManager;

	/**
	 * Validator de mot de passe
	 */
	@Autowired
	@Qualifier("motDePasseValidator")
	private Validator motDePasseValidator;

	/**
	 * @return the employeManager
	 */
	public IEmployeManager getEmployeManager() {
		return employeManager;
	}

	/**
	 * @param employeManager
	 *            the employeManager to set
	 */
	public void setEmployeManager(IEmployeManager employeManager) {
		this.employeManager = employeManager;
	}

	/**
	 * Affiche le formulaire d'édition du mot de passe
	 * 
	 * @param id
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value = "/motdepasse/edit.htm", method = RequestMethod.GET)
	public ModelAndView editer(HttpServletRequest request, ModelMap model) {

		ModificationMotDePasseFormBean mpForm = new ModificationMotDePasseFormBean();

		model.addAttribute("modificationMotDePasseFormBean", mpForm);

		return new ModelAndView("EditMotDePassePage", model);

	}

	/**
	 * Sauvegarde le nouveau mot de passe de l'utilisateur
	 * 
	 * @param employe
	 *            {@link Employe}
	 * @param result
	 *            {@link BindingResult}
	 * @param status
	 *            {@link SessionStatus}
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value = "/motdepasse/edit.htm", method = RequestMethod.POST)
	public ModelAndView sauver(
			HttpServletRequest request,
			@ModelAttribute("modificationMotDePasseFormBean") ModificationMotDePasseFormBean mpForm,
			BindingResult result) {

		ModelMap model = new ModelMap();

		if (mpForm == null) {
			addGlobalError(request, "globalError.technicalError");
			return new ModelAndView("EditMotDePassePage", model);
		}

		this.getMotDePasseValidator().validate(mpForm, result);

		if (result.hasErrors()) {
			addGlobalError(request, "globalError.fieldError");
			return new ModelAndView("EditMotDePassePage", model);
		} else {

			if (log.isDebugEnabled()) {
				log.debug("mpForm :" + mpForm);
			}

			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			User user = (User) auth.getPrincipal();

			Employe employe = employeManager.getEmployeByUsername(user
					.getUsername());

			String motDePasseUtilisateur = employe.getMotDePasse();

			if (!mpForm.getMpActuel().equals(motDePasseUtilisateur)) {
				result.rejectValue("mpActuel", "ancienMotDePasse.notMatched");
				return new ModelAndView("EditMotDePassePage", model);
			} else {

				employe.setMotDePasse(mpForm.getMpNouveau());

				this.getEmployeManager().saveEmploye(employe);

				addGlobalMessage(request, "motDePasse.saveDone");

				model.addAttribute("employe", employe);

				return new ModelAndView(new RedirectView(
						"/accueil/accueil.htm", true, true, false), model);
			}
		}

	}

	/**
	 * @return the motDePasseValidator
	 */
	public Validator getMotDePasseValidator() {
		return motDePasseValidator;
	}

	/**
	 * @param motDePasseValidator
	 *            the motDePasseValidator to set
	 */
	public void setMotDePasseValidator(Validator motDePasseValidator) {
		this.motDePasseValidator = motDePasseValidator;
	}

}
