package fr.solutec.gestionStocks.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.solutec.gestionStocks.bean.Titre;
import fr.solutec.gestionStocks.dao.ITitreDao;
import fr.solutec.gestionStocks.service.ITitreManager;

/**
 * @author achankimponne
 * 
 */
@Service
public class TitreManager implements ITitreManager {
	/**
	 * Logger
	 */
	private static final Logger log = Logger.getLogger(TitreManager.class);

	/**
	 * Dao
	 */
	@Autowired
	@Qualifier("titreDao")
	private ITitreDao titreDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.solutec.gestionStocks.service.ITitreManager#getAllTitres()
	 */
	//@Override
	public List<Titre> getAllTitres() {
		return this.getTitreDao().getAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.solutec.gestionStocks.service.ITitreManager#exists(java.lang.String)
	 */
	//@Override
	public boolean exists(String titre) {
		if (this.getTitreDao().getById(titre) != null) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.solutec.gestionStocks.service.ITitreManager#getTitreById(java.lang
	 * .String)
	 */
	//@Override
	public Titre getTitreById(String id) {
		if (id == null) {
			// TODO lancer exception
			return null;
		}

		return this.getTitreDao().getById(id);
	}

	/**
	 * @return the titreDao
	 */
	public ITitreDao getTitreDao() {
		return titreDao;
	}

	/**
	 * @param titreDao
	 *            the titreDao to set
	 */
	public void setTitreDao(ITitreDao titreDao) {
		this.titreDao = titreDao;
	}

}
