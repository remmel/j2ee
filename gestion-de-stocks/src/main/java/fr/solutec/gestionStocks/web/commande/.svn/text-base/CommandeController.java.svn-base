package fr.solutec.gestionStocks.web.commande;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import fr.solutec.gestionStocks.bean.Client;
import fr.solutec.gestionStocks.bean.Commande;
import fr.solutec.gestionStocks.bean.Ligne;
import fr.solutec.gestionStocks.bean.Produit;
import fr.solutec.gestionStocks.service.IClientManager;
import fr.solutec.gestionStocks.service.ICommandeManager;
import fr.solutec.gestionStocks.service.ILigneManager;
import fr.solutec.gestionStocks.service.IProduitManager;
import fr.solutec.gestionStocks.util.DateUtils;
import fr.solutec.gestionStocks.util.NumberUtils;
import fr.solutec.gestionStocks.web.BaseController;
import fr.solutec.gestionStocks.web.formBean.CommandeFormBean;
import fr.solutec.gestionStocks.web.formBean.LigneFormBean;
import fr.solutec.gestionStocks.web.formBean.ProduitFormBean;

@Controller
public class CommandeController extends BaseController {
	/**
	 * Logger
	 */
	private static final Logger log = Logger
			.getLogger(CommandeController.class);

	/**
	 * Manager de Commande
	 */
	@Autowired
	@Qualifier("commandeManager")
	private ICommandeManager commandeManager;

	/**
	 * Manager de Client
	 */
	@Autowired
	@Qualifier("clientManager")
	private IClientManager clientManager;

	@Autowired
	@Qualifier("ligneManager")
	private ILigneManager ligneManager;

	@Autowired
	@Qualifier("produitManager")
	private IProduitManager produitManager;

	public IProduitManager getProduitManager() {
		return produitManager;
	}

	public void setProduitManager(IProduitManager produitManager) {
		this.produitManager = produitManager;
	}

	public ICommandeManager getCommandeManager() {
		return commandeManager;
	}

	public void setCommandeManager(ICommandeManager commandeManager) {
		this.commandeManager = commandeManager;
	}

	public ILigneManager getLigneManager() {
		return ligneManager;
	}

	public void setLigneManager(ILigneManager ligneManager) {
		this.ligneManager = ligneManager;
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

	@RequestMapping(value = "/commande/list.htm", method = RequestMethod.GET)
	public ModelAndView afficherListe(HttpServletRequest request,
			@RequestParam(value = "id", required = false) Integer id) {

		List<Commande> commandes = this.getCommandeManager()
				.getCommandesByIdClient(id);

		ModelMap model = new ModelMap();

		model.addAttribute("commandes", commandes);

		return new ModelAndView("ListCommandesPage", model);
	}

	@RequestMapping(value = "/commande/edit.htm", method = RequestMethod.GET)
	public ModelAndView editer(HttpServletRequest request,
			@RequestParam(value = "id", required = false) Integer id,
			ModelMap model) {

		List<Ligne> lignes = null;

		CommandeFormBean commandeForm = null;

		if (id != null && id > 0) {
			Commande commande = this.getCommandeManager().getCommandeById(id);

			if (commande == null) {
				commandeForm = new CommandeFormBean();
				model.addAttribute("commande", commandeForm);
				addGlobalError(request, "commande.notfoundError");
				return new ModelAndView("EditCommandePage", model);
			}

			commandeForm = new CommandeFormBean(commande);

			lignes = ligneManager.getLignesCommande(id);
		} else {
			commandeForm = new CommandeFormBean();

			commandeForm.setDateCommande(DateUtils.dateToString(
					DateUtils.getCurrentDate(), DateUtils.FORMAT_DDMMYYYY));

		}

		LigneFormBean ligne = new LigneFormBean();

		model.addAttribute("commande", commandeForm);
		model.addAttribute("lignes", lignes);
		model.addAttribute("ligne", ligne);

		return new ModelAndView("EditCommandePage", model);
	}

	@ModelAttribute("listProduits")
	public Map<String, String> populateProduitsList() {
		Map<String, String> mapProduits = new HashMap<String, String>();
		List<Produit> produits = this.getProduitManager().getAll();

		if (produits != null) {
			for (Produit produit : produits) {
				mapProduits.put(produit.getId().toString(), produit.getNom());
			}
		}
		return mapProduits;
	}

	@RequestMapping(value = "/commande/getPrix.htm", method = RequestMethod.POST)
	public @ResponseBody
	String getPrix(@ModelAttribute(value = "id") ProduitFormBean produit,
			BindingResult result) {

		if (!result.hasErrors() && produit != null) {

			Double prix = this.getProduitManager().getPrixConseilleByIdProduit(
					produit.getId());

			return NumberUtils.doubleToString(prix,
					NumberUtils.MONTANT_2_DECIMALES);

		}
		return "erreur technique, impossible de récupérer le prix";
	}

	@RequestMapping(value = "/commande/addLigne.htm", method = RequestMethod.POST)
	public ModelAndView ajouterLigne(HttpServletRequest request,
			@ModelAttribute("ligne") LigneFormBean ligneformBean,
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "idClient", required = false) Integer idClient) {

		ModelMap model = new ModelMap();

		if (ligneformBean == null) {
			addGlobalError(request, "globalError.technicalError");
			return new ModelAndView("EditCommandePage", model);
		}

		// TODO Validation

		if (log.isDebugEnabled()) {
			log.debug("id :" + id);
			log.debug("ligneformBean :" + ligneformBean);
		}

		Commande commande = new Commande();

		if (id == null || id <= 0) {
			commande.setId(null);
			if (idClient == null) {
				addGlobalError(request, "globalError.fieldError");
				return new ModelAndView("EditCommandePage", model);
			}

			Client client = this.getClientManager().getClientById(idClient);

			if (client == null) {
				addGlobalError(request, "client.notfoundError");
				return new ModelAndView("EditCommandePage", model);
			}

			commande.setClient(client);

			commande = this.getCommandeManager().save(commande);
		} else {
			commande = this.getCommandeManager().getCommandeById(id);
			if (commande == null) {
				addGlobalError(request, "commande.notfoundError");
				return new ModelAndView("EditCommandePage", model);
			}
		}

		if (log.isDebugEnabled()) {
			log.debug("commande:" + commande);
		}

		Ligne ligne = new Ligne();

		Produit produit = this.getProduitManager().getProduitById(
				ligneformBean.getIdProduit());

		if (produit == null) {
			addGlobalError(request, "produit.notfoundError");
			return new ModelAndView("EditCommandePage", model);
		}
		ligne.setProduit(produit);

		ligne.setCommande(commande);
		ligne.setPrix(NumberUtils.stringToDouble(ligneformBean.getPrix(),
				NumberUtils.SEPARATEUR_VIRGULE_REGEX));

		ligne.setQuantite(ligneformBean.getQuantite());

		this.getLigneManager().save(ligne);

		addGlobalMessage(request, "ligne.saveDone");

		return new ModelAndView(new RedirectView("/commande/edit.htm?id="
				+ commande.getId(), true, true, false), model);

	}

	@RequestMapping(value = "/commande/edit.htm", method = RequestMethod.POST)
	public ModelAndView sauver(HttpServletRequest request,
			@ModelAttribute("commande") CommandeFormBean commandeformBean,
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "idClient", required = false) Integer idClient) {

		ModelMap model = new ModelMap();

		if (commandeformBean == null) {
			addGlobalError(request, "globalError.technicalError");
			return new ModelAndView("EditCommandePage", model);
		}

		// TODO Validation

		if (log.isDebugEnabled()) {
			log.debug("id :" + id);
			log.debug("commandeformBean :" + commandeformBean);
		}

		Commande commande = new Commande();

		if (id == null || id <= 0) {
			commande.setId(null);
			if (idClient == null) {
				addGlobalError(request, "globalError.fieldError");
				return new ModelAndView("EditCommandePage", model);
			}

			Client client = this.getClientManager().getClientById(idClient);

			if (client == null) {
				addGlobalError(request, "client.notfoundError");
				return new ModelAndView("EditCommandePage", model);
			}

			commande.setClient(client);

		} else {
			commande = this.getCommandeManager().getCommandeById(id);
			if (commande == null) {
				addGlobalError(request, "commande.notfoundError");
				return new ModelAndView("EditCommandePage", model);
			}
		}

		try {
			commande.setDateLivraison(DateUtils.stringToDate(
					commandeformBean.getDateLivraison(),
					DateUtils.FORMAT_DDMMYYYY));
		} catch (ParseException e) {
			addGlobalError(request, "globalError.technicalError");
			return new ModelAndView("EditCommandePage", model);
		}

		commande.setNtPaiement(commandeformBean.getNtPaiement());
		commande.setValidite(commandeformBean.getValidite());

		commande = this.getCommandeManager().save(commande);

		addGlobalMessage(request, "commande.saveDone");

		return new ModelAndView(new RedirectView("/commande/edit.htm?id="
				+ commande.getId(), true, true, false), model);
	}

	@RequestMapping(value = "/ligne/delete.htm", method = RequestMethod.GET)
	public ModelAndView supprimerLigne(HttpServletRequest request,
			@RequestParam(value = "idLigne", required = false) Integer id) {

		Ligne ligne = null;

		Integer idCommande = null;

		if (id != null && id > 0) {
			ligne = this.getLigneManager().getLigneById(id);

			if (ligne == null) {
				addGlobalError(request, "ligne.notfoundError");
				return new ModelAndView("EditCommandePage");
			}

			idCommande = ligne.getCommande() != null ? ligne.getCommande()
					.getId() : null;

			this.getLigneManager().deleteLigne(ligne);
		} else {
			addGlobalError(request, "ligne.notfoundError");
			return new ModelAndView("EditCommandePage");
		}

		return new ModelAndView(new RedirectView("/commande/edit.htm?id="
				+ idCommande, true, true, false));
	}

	@RequestMapping(value = "/commande/delete.htm", method = RequestMethod.GET)
	public ModelAndView supprimerCommande(HttpServletRequest request,
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "idClient", required = false) Integer idClient) {

		Commande commande = null;

		if (id != null && id > 0) {
			commande = this.getCommandeManager().getCommandeById(id);

			if (commande == null) {
				addGlobalError(request, "commande.notfoundError");
				return new ModelAndView(new RedirectView(
						"/commande/list.htm?id=" + idClient, true, true, false));
			}

			this.getCommandeManager().delete(commande);

		} else {
			addGlobalError(request, "commande.notfoundError");
			return new ModelAndView(new RedirectView("/commande/list.htm?id="
					+ idClient, true, true, false));
		}

		return new ModelAndView(new RedirectView("/commande/list.htm?id="
				+ idClient, true, true, false));

	}

}
