package fr.solutec.gestionStocks.web.client;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import fr.solutec.gestionStocks.bean.Client;
import fr.solutec.gestionStocks.bean.Employe;
import fr.solutec.gestionStocks.service.IClientManager;
import fr.solutec.gestionStocks.service.IEmployeManager;
import fr.solutec.gestionStocks.web.BaseController;
import fr.solutec.gestionStocks.web.formBean.ClientFormBean;

/**
 * @author achankimponne
 * 
 */
@Controller
public class ClientController extends BaseController {
	/**
	 * Logger
	 */
	private static final Logger log = Logger.getLogger(ClientController.class);

	/**
	 * Manager de Client
	 */
	@Autowired
	@Qualifier("clientManager")
	private IClientManager clientManager;

	/**
	 * Manager de Employe
	 */
	@Autowired
	@Qualifier("employeManager")
	private IEmployeManager employeManager;

	private Employe employe;

	private Client client;

	/**
	 * validator de Client
	 */
	@Autowired
	@Qualifier("clientValidator")
	private Validator clientValidator;

	public IEmployeManager getEmployeManager() {
		return employeManager;
	}

	public void setEmployeManager(IEmployeManager employeManager) {
		this.employeManager = employeManager;
	}

	/**
	 * @return the clientManager
	 */
	public IClientManager getClientManager() {
		return clientManager;
	}

	/**
	 * @param clientManager
	 *            the clientManager to set
	 */
	public void setClientManager(IClientManager clientManager) {
		this.clientManager = clientManager;
	}

	@RequestMapping(value = "/client/list.htm", method = RequestMethod.GET)
	public ModelAndView afficherListe() throws Exception {

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		User user = (User) auth.getPrincipal();
		employe = employeManager.getEmployeByUsername(user.getUsername());

		List<Client> clients = clientManager.getClientsEmploye(employe);

		ModelMap model = new ModelMap();

		List<ClientFormBean> clientForms = new ArrayList<ClientFormBean>();

		if (clients != null && clients.size() > 0) {
			for (Client client : clients) {
				if (log.isDebugEnabled()) {
					log.debug(client);
				}
				clientForms.add(new ClientFormBean(client));
			}
		}

		model.addAttribute("clients", clientForms);

		return new ModelAndView("ListClientsPage", model);
	}

	@RequestMapping(value = "/client/edit.htm", method = RequestMethod.GET)
	public ModelAndView editer(HttpServletRequest request,
			@RequestParam(value = "id", required = false) Integer id,
			ModelMap model) {
		ClientFormBean clientInfoData = new ClientFormBean();
		model = new ModelMap();

		if (id == null) {
			model.addAttribute("clientInfoData", clientInfoData);
			addGlobalError(request, "globalError.technicalError");

			return new ModelAndView("EditClientPage", model);
		} else {
			if (id > 0) {
				client = clientManager.getClientById(id);
				clientInfoData = new ClientFormBean(client);
				if (client == null) {
					model.addAttribute("clientInfoData", clientInfoData);
					addGlobalError(request, "client.notfoundError");
					return new ModelAndView("EditClientPage", model);
				}
			}

		}

		model.addAttribute("clientInfoData", clientInfoData);
		return new ModelAndView("EditClientPage", model);
	}

	/**
	 * Sauvegarde un client par le formulaire d'édition
	 * 
	 * @param employe
	 *            {@link Client}
	 * @param result
	 *            {@link BindingResult}
	 * @param status
	 *            {@link SessionStatus}
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value = "/client/edit.htm", method = RequestMethod.POST)
	public ModelAndView sauver(HttpServletRequest request,
			@ModelAttribute("clientInfoData") ClientFormBean clientForm,
			BindingResult result) {

		ModelMap model = new ModelMap();

		if (clientForm == null) {
			addGlobalError(request, "globalError.technicalError");
			return new ModelAndView("EditClientPage", model);
		}

		this.clientValidator.validate(clientForm, result);

		if (result.hasErrors()) {
			addGlobalError(request, "globalError.fieldError");
			return new ModelAndView("EditClientPage", model);
		} else {

			if (log.isDebugEnabled()) {
				log.debug("clientForm :" + clientForm);
			}

			Client client = new Client();

			if (clientForm.getId() != null && clientForm.getId() <= 0) {
				client.setId(null);
			} else {
				client = this.clientManager.getClientById(clientForm.getId());
				if (client == null) {
					addGlobalError(request, "client.notfoundError");
					return new ModelAndView("EditClientPage", model);
				}
			}

			if (employe != null) {
				client.setEmploye(employe);
			}
			client.setNom(clientForm.getNom());
			client.setTelephone(clientForm.getTelephone());
			client.setAdresse(clientForm.getAdresse());
			client.setVille(clientForm.getVille());
			client.setDepartement(clientForm.getDepartement());
			client.setPays(clientForm.getPays());
			client.setCpPostal(clientForm.getCpPostal());
			client.setSolvabilite(clientForm.getSolvabilite());
			client.setCommentaires(clientForm.getCommentaires());

			client = clientManager.saveClient(client);

			addGlobalMessage(request, "client.saveDone");

			model.addAttribute("client", client);

			return new ModelAndView(new RedirectView("/client/edit.htm?id="
					+ client.getId(), true, true, false), model);
		}

	}

	@RequestMapping(value = "/client/delete.htm", method = RequestMethod.GET)
	public ModelAndView supprimer(HttpServletRequest request,
			@RequestParam("id") Integer id) {
		if (id == null || id <= 0) {
			addGlobalError(request, "globalError.technicalError");
		} else {
			this.getClientManager().deleteClientById(id);
		}

		return new ModelAndView(new RedirectView("/client/list.htm", true,
				true, false));
	}

	public Validator getClientValidator() {
		return clientValidator;
	}

	public void setClientValidator(Validator clientValidator) {
		this.clientValidator = clientValidator;
	}
}
