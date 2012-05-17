package fr.solutec.gestionStocks.web.produit;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import fr.solutec.gestionStocks.bean.Produit;
import fr.solutec.gestionStocks.service.IProduitManager;
import fr.solutec.gestionStocks.util.NumberUtils;
import fr.solutec.gestionStocks.util.StringUtils;
import fr.solutec.gestionStocks.web.BaseController;
import fr.solutec.gestionStocks.web.formBean.ProduitFormBean;

/**
 * Controller de gestion d'un employe
 * 
 * @author achankimponne
 */
@Controller
public class ProduitController extends BaseController {

	/**
	 * Logger
	 */
	private static final Logger log = Logger.getLogger(ProduitController.class);

	/**
	 * Manager d'employe
	 */
	@Autowired
	@Qualifier("produitManager")
	private IProduitManager produitManager;

	@Autowired
	@Qualifier("produitValidator")
	private Validator produitValidator;

	private Produit produit;

	/**
	 * Affiche la liste des produits
	 * 
	 * @param id
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value = "/produit/list.htm", method = RequestMethod.GET)
	public ModelAndView lister(HttpServletRequest request, ModelMap model) {
		List<Produit> produitsBean = this.getProduitManager().getAll();

		List<ProduitFormBean> produits = new ArrayList<ProduitFormBean>();

		if (produitsBean != null) {
			for (Produit produit : produitsBean) {
				produits.add(new ProduitFormBean(produit));
			}
		}

		model.addAttribute("produits", produits);

		return new ModelAndView("ListProduitsPage", model);

	}

	@RequestMapping(value = "/produit/edit.htm", method = RequestMethod.GET)
	public ModelAndView editer(HttpServletRequest request,
			@RequestParam(value = "id", required = false) Integer id,
			ModelMap model) {

		ProduitFormBean produitForm = new ProduitFormBean();
		if (id == null) {
			model.addAttribute("produitForm", produitForm);
			addGlobalError(request, "globalError.technicalError");

			return new ModelAndView("EditProduitPage", model);
		} else {
			if (id > 0) {
				produit = produitManager.getProduitById(id);
				produitForm = new ProduitFormBean(produit);
				if (produit == null) {
					model.addAttribute("produitForm", produitForm);
					addGlobalError(request, "produit.notfoundError");
					return new ModelAndView("EditProduitPage", model);
				}
			}

		}

		model.addAttribute("produitForm", produitForm);

		return new ModelAndView("EditProduitPage", model);
	}

	@RequestMapping(value = "/produit/edit.htm", method = RequestMethod.POST)
	public ModelAndView sauver(HttpServletRequest request,
			@ModelAttribute("produitForm") ProduitFormBean produitForm,
			BindingResult result) {

		ModelMap model = new ModelMap();

		if (produitForm == null) {
			addGlobalError(request, "globalError.technicalError");
			return new ModelAndView("EditProduitPage", model);
		}

		this.produitValidator.validate(produitForm, result);

		if (result.hasErrors()) {
			addGlobalError(request, "globalError.fieldError");
			return new ModelAndView("EditProduitPage", model);
		} else {

			if (log.isDebugEnabled()) {
				log.debug("produitForm :" + produitForm);
			}

			Produit produit = new Produit();

			if (produitForm.getId() != null && produitForm.getId() <= 0) {
				produit.setId(null);
			} else {
				produit = this.produitManager.getProduitById(produitForm
						.getId());
				if (produit == null) {
					addGlobalError(request, "produit.notfoundError");
					return new ModelAndView("EditProduitPage", model);
				}
			}

			produit.setNom(produitForm.getNom());
			produit.setDescription(produitForm.getDescription());
			if (StringUtils.isNotNullOrEmpty(produitForm.getPrixConseille())) {
				produit.setPrixConseille(NumberUtils.stringToDouble(
						produitForm.getPrixConseille(),
						NumberUtils.SEPARATEUR_VIRGULE_REGEX));
			}

			produit = produitManager.saveProduit(produit);

			addGlobalMessage(request, "produit.saveDone");

			model.addAttribute("produit", produit);

			return new ModelAndView(new RedirectView("/produit/edit.htm?id="
					+ produit.getId(), true, true, false), model);
		}

	}

	@RequestMapping(value = "/produit/delete.htm", method = RequestMethod.GET)
	public ModelAndView supprimer(HttpServletRequest request,
			@RequestParam("id") Integer id) {
		if (id == null || id <= 0) {
			addGlobalError(request, "globalError.technicalError");
		} else {
			this.getProduitManager().deleteProduitByID(id);
		}

		return new ModelAndView(new RedirectView("/produit/list.htm", true,
				true, false));
	}

	/**
	 * @return the produitManager
	 */
	public IProduitManager getProduitManager() {
		return produitManager;
	}

	/**
	 * @param produitManager
	 *            the produitManager to set
	 */
	public void setProduitManager(IProduitManager produitManager) {
		this.produitManager = produitManager;
	}

}
