package fr.solutec.gestionStocks.service.impl;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.solutec.gestionStocks.service.IAuthentificationManager;

/**
 * @author achankimponne
 * 
 */
@Service("authentificationManager")
public class AuthentificationManager implements IAuthentificationManager {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.solutec.gestionStocks.service.IAuthentificationManager#stringToMD5
	 * (java.lang.String)
	 */
	//@Override
	public String encodePassword(String password) {

		if (password != null) {
			ShaPasswordEncoder encoder = new ShaPasswordEncoder();

			return encoder.encodePassword(password, null);
		}
		return null;
	}
}
