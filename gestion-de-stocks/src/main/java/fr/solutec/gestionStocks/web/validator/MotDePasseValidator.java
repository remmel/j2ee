package fr.solutec.gestionStocks.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.solutec.gestionStocks.util.StringUtils;
import fr.solutec.gestionStocks.web.formBean.ModificationMotDePasseFormBean;

/**
 * @author achankimponne
 * 
 */
@Component
public class MotDePasseValidator implements Validator {

	private static final int MOT_DE_PASSE_MAX_LENGTH = 14;

	//@Override
	public boolean supports(Class<?> c) {
		return ModificationMotDePasseFormBean.class.equals(c);
	}

	//@Override
	public void validate(Object o, Errors e) {

		ValidationUtils.rejectIfEmptyOrWhitespace(e, "mpActuel",
				"mpActuel.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "mpNouveau",
				"mpNouveau.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "mpConfirmationNouveau",
				"mpConfirmationNouveau.required");

		ModificationMotDePasseFormBean mpForm = (ModificationMotDePasseFormBean) o;

		if (StringUtils.isNotNullOrEmpty(mpForm.getMpNouveau())
				&& StringUtils.isNotNullOrEmpty(mpForm
						.getMpConfirmationNouveau())) {

			if (mpForm.getMpNouveau().length() > MOT_DE_PASSE_MAX_LENGTH) {
				e.rejectValue(
						"mpActuel",
						"motDePasse.max.lenght",
						new String[] { String.valueOf(MOT_DE_PASSE_MAX_LENGTH) },
						null);
			}

			if (!mpForm.getMpNouveau()
					.equals(mpForm.getMpConfirmationNouveau())) {
				e.rejectValue("mpConfirmationNouveau", "motDePasse.notmatched");
			}
		}
	}
}
