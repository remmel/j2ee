package fr.solutec.gestionStocks.web.employe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import fr.solutec.gestionStocks.bean.Employe;
import fr.solutec.gestionStocks.bean.Service;
import fr.solutec.gestionStocks.bean.Titre;
import fr.solutec.gestionStocks.bean.enums.AuthorityEnum;
import fr.solutec.gestionStocks.service.IAuthentificationManager;
import fr.solutec.gestionStocks.service.IEmployeManager;
import fr.solutec.gestionStocks.service.IServiceManager;
import fr.solutec.gestionStocks.service.ITitreManager;
import fr.solutec.gestionStocks.util.NumberUtils;
import fr.solutec.gestionStocks.util.StringUtils;
import fr.solutec.gestionStocks.web.BaseController;
import fr.solutec.gestionStocks.web.formBean.EmployeFormBean;
import fr.solutec.gestionStocks.web.formBean.ServiceEditor;
import fr.solutec.gestionStocks.web.formBean.ServiceFormBean;

/**
 * Controller de gestion d'un employe
 * 
 * @author achankimponne
 */
@Controller
public class EmployeController extends BaseController {

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
	 * Manager des services
	 */
	@Autowired
	@Qualifier("serviceManager")
	private IServiceManager serviceManager;

	/**
	 * Manager de l'authentification
	 */
	@Autowired
	@Qualifier("authentificationManager")
	private IAuthentificationManager authentificationManager;

	/**
	 * Manager des titres
	 */
	@Autowired
	@Qualifier("titreManager")
	private ITitreManager titreManager;

	/**
	 * Validator d'employe
	 */
	@Autowired
	@Qualifier("employeValidator")
	private Validator employeValidator;

	@ModelAttribute("listTitres")
	public List<String> populateTitresList() {
		List<Titre> titres = this.getTitreManager().getAllTitres();
		List<String> nomTitres = null;

		if (titres != null && !titres.isEmpty()) {
			nomTitres = new ArrayList<String>();
			for (Titre titre : titres) {
				nomTitres.add(titre.getTitre());
			}
		}
		return nomTitres;
	}

	@ModelAttribute("listServices")
	public Map<String, String> populateServicesList() {
		Map<String, String> mapServices = new HashMap<String, String>();
		List<Service> listServices = this.getServiceManager().getAllServices();

		if (listServices != null) {
			for (Service service : listServices) {
				mapServices.put(service.getId().toString(), service.getNom());
			}
		}
		return mapServices;
	}

	@ModelAttribute("listAuthorities")
	public List<String> populateAuthoritiesList() {
		List<String> listAuthorities = new ArrayList<String>();

		List<AuthorityEnum> listAuthoritiesEnum = AuthorityEnum.getList();

		if (listAuthorities != null) {
			for (AuthorityEnum authority : listAuthoritiesEnum) {
				listAuthorities.add(authority.getValue());
			}
		}
		return listAuthorities;
	}

	/**
	 * Affiche le formulaire d'édition d'un employe
	 * 
	 * @param id
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value = "/employe/edit.htm", method = RequestMethod.GET)
	public ModelAndView editer(HttpServletRequest request,
			@RequestParam(value = "id", required = false) Integer id,
			ModelMap model) {
		EmployeFormBean employeInfoData = null;

		Employe employe = null;

		model = new ModelMap();

		if (id == null) {
			employeInfoData = new EmployeFormBean();
			model.addAttribute("employeInfoData", employeInfoData);
			addGlobalError(request, "globalError.technicalError");

			return new ModelAndView("EditEmployePage", model);
		} else if (id <= 0) {
			employeInfoData = new EmployeFormBean();

		} else {
			employe = employeManager.getEmployeById(id);
			employeInfoData = new EmployeFormBean(employe);

			if (employe == null) {
				model.addAttribute("employeInfoData", employeInfoData);
				addGlobalError(request, "employe.notfoundError");
				return new ModelAndView("EditEmployePage", model);
			}

		}

		model.addAttribute("employeInfoData", employeInfoData);

		return new ModelAndView("EditEmployePage", model);

	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(ServiceFormBean.class, "service",
				new ServiceEditor(this.getServiceManager()));
	}

	/**
	 * Sauvegarde un employe par le formulaire d'édition
	 * 
	 * @param employe
	 *            {@link Employe}
	 * @param result
	 *            {@link BindingResult}
	 * @param status
	 *            {@link SessionStatus}
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value = "/employe/edit.htm", method = RequestMethod.POST)
	public ModelAndView sauver(HttpServletRequest request,
			@ModelAttribute("employeInfoData") EmployeFormBean employeForm,
			BindingResult result) {

		ModelMap model = new ModelMap();

		if (employeForm == null) {
			addGlobalError(request, "globalError.technicalError");
			return new ModelAndView("EditEmployePage", model);
		}

		this.getEmployeValidator().validate(employeForm, result);

		if (result.hasErrors()) {
			addGlobalError(request, "globalError.fieldError");
			return new ModelAndView("EditEmployePage", model);
		} else {

			if (log.isDebugEnabled()) {
				log.debug("employeForm :" + employeForm);
			}

			Employe employe = new Employe();

			if (employeForm.getId() != null && employeForm.getId() <= 0) {
				employe.setId(null);

				employe.setMotDePasse(this.getAuthentificationManager()
						.encodePassword(employeForm.getMotDePasse()));

				employe.setUtilisateur(employeForm.getUtilisateur());

			} else {
				employe = this.getEmployeManager().getEmployeById(
						employeForm.getId());
				if (employe == null) {
					addGlobalError(request, "employe.notfoundError");
					return new ModelAndView("EditEmployePage", model);
				}
			}

			employe.setNom(employeForm.getNom());
			employe.setPrenom(employeForm.getPrenom());

			employe.setCommentaires(employeForm.getCommentaires());

			if (StringUtils.isNotNullOrEmpty(employeForm.getSalaire())) {
				employe.setSalaire(NumberUtils.stringToDouble(
						employeForm.getSalaire(),
						NumberUtils.SEPARATEUR_VIRGULE_REGEX));
			}
			if (StringUtils.isNotNullOrEmpty(employeForm.getPctCommission())) {
				employe.setPctCommission(NumberUtils.stringToDouble(
						employeForm.getPctCommission(),
						NumberUtils.SEPARATEUR_VIRGULE_REGEX));
			}

			if (employeForm.getTitre() != null) {
				Titre titre = this.getTitreManager().getTitreById(
						employeForm.getTitre());
				employe.setTitre(titre);
			}

			if (employeForm.getService() != null
					&& employeForm.getService().getId() != null) {
				Service service = this.getServiceManager().getServiceById(
						employeForm.getService().getId());

				if (service != null) {
					employe.setService(service);
				}

			}
			employe = employeManager.saveEmploye(employe);

			this.getEmployeManager().saveAuthorities(employe,
					employeForm.getAuthorities());

			addGlobalMessage(request, "employe.saveDone");

			model.addAttribute("employe", employe);

			return new ModelAndView(new RedirectView("/employe/edit.htm?id="
					+ employe.getId(), true, true, false), model);
		}
	}

	@RequestMapping(value = "/employe/list.htm", method = RequestMethod.GET)
	public ModelAndView afficherListe(HttpServletRequest request)
			throws Exception {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		User user = (User) auth.getPrincipal();
		Employe employeCourrant = employeManager.getEmployeByUsername(user
				.getUsername());

		ModelMap model = new ModelMap();

		if (employeCourrant == null) {
			addGlobalError(request, "globalError.technicalError");

			model.addAttribute("idCourrant", null);
			model.addAttribute("employes", null);
			model.addAttribute("serviceInfoData", new ServiceFormBean());

			return new ModelAndView("ListEmployesPage", model);
		}

		List<Employe> employes = employeManager.getAllEmployes();

		List<EmployeFormBean> employeForms = new ArrayList<EmployeFormBean>();

		if (employes != null && employes.size() > 0) {
			for (Employe employe : employes) {
				if (log.isDebugEnabled()) {
					log.debug(employe);
				}
				employeForms.add(new EmployeFormBean(employe));

			}
		}

		model.addAttribute("idCourrant", employeCourrant.getId());
		model.addAttribute("employes", employeForms);
		model.addAttribute("serviceInfoData", new ServiceFormBean());

		return new ModelAndView("ListEmployesPage", model);
	}

	@RequestMapping(value = "/employe/list.htm", method = RequestMethod.POST)
	public ModelAndView filtrerListe(
			@ModelAttribute("serviceInfoData") ServiceFormBean serviceForm,
			BindingResult result, SessionStatus status) throws Exception {

		List<Employe> employes = null;
		ModelMap model = new ModelMap();
		List<EmployeFormBean> employeForms = new ArrayList<EmployeFormBean>();

		if (serviceForm == null || serviceForm.getId() == null) {
			employes = employeManager.getAllEmployes();
		} else {

			employes = this.getEmployeManager().getListEmployesByIdService(
					serviceForm.getId());
		}

		if (employes != null && employes.size() > 0) {
			for (Employe employe : employes) {
				if (log.isDebugEnabled()) {
					log.debug(employe);
				}
				employeForms.add(new EmployeFormBean(employe));

			}
		}

		model.addAttribute("employes", employeForms);
		model.addAttribute("serviceInfoData", serviceForm);

		return new ModelAndView("ListEmployesPage", model);
	}

	@RequestMapping(value = "/employe/delete.htm", method = RequestMethod.GET)
	public ModelAndView supprimer(HttpServletRequest request,
			@RequestParam("id") Integer id) {
		if (id == null || id <= 0) {
			addGlobalError(request, "globalError.technicalError");
		} else {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			User user = (User) auth.getPrincipal();
			Employe employe = employeManager.getEmployeByUsername(user
					.getUsername());

			if (employe == null) {
				addGlobalError(request, "employe.notfoundError");
				return new ModelAndView(new RedirectView("/employe/list.htm",
						true, true, false));
			}

			if (id.equals(employe.getId())) {
				addGlobalError(request, "employe.suppressionUserConnecteError");
				return new ModelAndView(new RedirectView("/employe/list.htm",
						true, true, false));
			}

			this.getEmployeManager().deleteEmployeById(id);
		}

		return new ModelAndView(new RedirectView("/employe/list.htm", true,
				true, false));
	}

	/**
	 * @return {@link IEmployeManager}
	 */
	public IEmployeManager getEmployeManager() {
		return employeManager;
	}

	/**
	 * @param employeManager
	 *            {@link IEmployeManager}
	 */
	public void setEmployeManager(IEmployeManager employeManager) {
		this.employeManager = employeManager;
	}

	/**
	 * @return {@link Validator}
	 */
	public Validator getEmployeValidator() {
		return employeValidator;
	}

	/**
	 * @param employeValidator
	 *            {@link Validator}
	 */
	public void setEmployeValidator(Validator employeValidator) {
		this.employeValidator = employeValidator;
	}

	/**
	 * @return the serviceManager
	 */
	public IServiceManager getServiceManager() {
		return serviceManager;
	}

	/**
	 * @param serviceManager
	 *            the serviceManager to set
	 */
	public void setServiceManager(IServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	/**
	 * @return the titreManager
	 */
	public ITitreManager getTitreManager() {
		return titreManager;
	}

	/**
	 * @param titreManager
	 *            the titreManager to set
	 */
	public void setTitreManager(ITitreManager titreManager) {
		this.titreManager = titreManager;
	}

	/**
	 * @return the authentificationManager
	 */
	public IAuthentificationManager getAuthentificationManager() {
		return authentificationManager;
	}

	/**
	 * @param authentificationManager
	 *            the authentificationManager to set
	 */
	public void setAuthentificationManager(
			IAuthentificationManager authentificationManager) {
		this.authentificationManager = authentificationManager;
	}

}
