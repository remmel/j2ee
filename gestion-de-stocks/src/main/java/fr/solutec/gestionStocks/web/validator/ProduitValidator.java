package fr.solutec.gestionStocks.web.validator;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.solutec.gestionStocks.web.formBean.ProduitFormBean;

@Component
public class ProduitValidator implements Validator {
	/**
	 * Logger
	 */
	private static final Logger log = Logger.getLogger(ProduitValidator.class);

	@Override
	public boolean supports(Class<?> c) {
		return ProduitFormBean.class.equals(c);
	}

	@Override
	public void validate(Object o, Errors e) {

		ValidationUtils.rejectIfEmptyOrWhitespace(e, "nom", "nom.required");

		ProduitFormBean produitForm = (ProduitFormBean) o;

		if (log.isDebugEnabled()) {
			log.debug("ProduitFormBean: " + produitForm);
		}
	}

}
