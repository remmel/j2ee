package fr.solutec.gestionStocks.web.validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.solutec.gestionStocks.service.IEmployeManager;
import fr.solutec.gestionStocks.service.IServiceManager;
import fr.solutec.gestionStocks.service.ITitreManager;
import fr.solutec.gestionStocks.util.NumberUtils;
import fr.solutec.gestionStocks.util.StringUtils;
import fr.solutec.gestionStocks.web.formBean.EmployeFormBean;

/**
 * Validation d'employe
 * 
 * @author achankimponne
 * 
 */
@Component
public class EmployeValidator implements Validator {

	/**
	 * Logger
	 */
	private static final Logger log = Logger.getLogger(EmployeValidator.class);

	/**
	 * Manager des services
	 */
	@Autowired
	@Qualifier("serviceManager")
	private IServiceManager serviceManager;

	/**
	 * Manager des employés
	 */
	@Autowired
	@Qualifier("employeManager")
	private IEmployeManager employeManager;

	/**
	 * Manager des titres
	 */
	@Autowired
	@Qualifier("titreManager")
	private ITitreManager titreManager;

	private static final int NOM_MAX_LENGTH = 25;
	private static final int PRENOM_MAX_LENGTH = 25;
	private static final int UTILISATEUR_MAX_LENGTH = 8;
	private static final int COMMENTAIRE_MAX_LENGTH = 255;
	private static final int MOT_DE_PASSE_MAX_LENGTH = 14;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	//@Override
	public boolean supports(Class<?> c) {
		return EmployeFormBean.class.equals(c);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	//@Override
	public void validate(Object o, Errors e) {

		ValidationUtils.rejectIfEmptyOrWhitespace(e, "nom", "nom.required");

		ValidationUtils.rejectIfEmptyOrWhitespace(e, "authorities",
				"droits.required");

		EmployeFormBean employe = (EmployeFormBean) o;

		if (log.isDebugEnabled()) {
			log.debug("employeForm: " + employe);
		}

		if (employe.getId() <= 0) {
			ValidationUtils.rejectIfEmptyOrWhitespace(e, "utilisateur",
					"utilisateur.required");
		}

		if (employe.getMotDePasse() != null
				&& employe.getConfirmationMotDePasse() != null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(e, "motDePasse",
					"motDePasse.required");
			ValidationUtils
					.rejectIfEmptyOrWhitespace(e, "confirmationMotDePasse",
							"confirmationMotDePasse.required");

			if (employe.getMotDePasse().length() > MOT_DE_PASSE_MAX_LENGTH) {
				e.rejectValue(
						"motDePasse",
						"motDePasse.max.lenght",
						new String[] { String.valueOf(MOT_DE_PASSE_MAX_LENGTH) },
						null);
			}
			if (!employe.getMotDePasse().equals(
					employe.getConfirmationMotDePasse())) {
				e.rejectValue("confirmationMotDePasse", "motDePasse.notmatched");
			}
		}

		if (employe.getNom().length() > NOM_MAX_LENGTH) {
			e.rejectValue("nom", "nom.max.lenght",
					new String[] { String.valueOf(NOM_MAX_LENGTH) }, null);
		}

		if (StringUtils.isNotNullOrEmpty(employe.getPrenom())
				&& employe.getPrenom().length() > PRENOM_MAX_LENGTH) {
			e.rejectValue("prenom", "prenom.max.lenght",
					new String[] { String.valueOf(PRENOM_MAX_LENGTH) }, null);
		}

		if (StringUtils.isNotNullOrEmpty(employe.getTitre())
				&& !this.getTitreManager().exists(employe.getTitre())) {
			e.rejectValue("titre", "titre.format", null);
		}

		if (StringUtils.isNotNullOrEmpty(employe.getUtilisateur())) {
			if (employe.getUtilisateur().length() > UTILISATEUR_MAX_LENGTH) {
				e.rejectValue(
						"utilisateur",
						"utilisateur.max.lenght",
						new String[] { String.valueOf(UTILISATEUR_MAX_LENGTH) },
						null);
			}

			if (this.getEmployeManager()
					.existUsername(employe.getUtilisateur())
					&& employe.getId() <= 0) {
				e.rejectValue("utilisateur", "utilisateur.exist");
			}
		}

		if (StringUtils.isNotNullOrEmpty(employe.getCommentaires())
				&& employe.getCommentaires().length() > COMMENTAIRE_MAX_LENGTH) {
			e.rejectValue("commentaires", "commentaires.max.lenght",
					new String[] { String.valueOf(COMMENTAIRE_MAX_LENGTH) },
					null);
		}

		if (StringUtils.isNotNullOrEmpty(employe.getSalaire())) {
			try {
				NumberUtils.stringToDouble(employe.getSalaire(),
						NumberUtils.SEPARATEUR_VIRGULE_REGEX);
			} catch (NumberFormatException ex) {
				e.rejectValue("salaire", "salaire.format", null);
			}
		}

		if (StringUtils.isNotNullOrEmpty(employe.getPctCommission())) {
			try {
				NumberUtils.stringToDouble(employe.getPctCommission(),
						NumberUtils.SEPARATEUR_VIRGULE_REGEX);
			} catch (NumberFormatException ex) {
				e.rejectValue("pctCommission", "pctCommission.format", null);
			}
		}

		if (employe.getService() != null
				&& employe.getService().getId() != null) {

			if (!(this.getServiceManager().exists(employe.getService().getId()))) {
				e.rejectValue("service", "service.notfound", null);
			}
		}

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
}
