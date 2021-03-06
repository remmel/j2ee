package fr.solutec.gestionStocks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.solutec.gestionStocks.bean.Commande;
import fr.solutec.gestionStocks.bean.Ligne;
import fr.solutec.gestionStocks.dao.ICommandeDao;
import fr.solutec.gestionStocks.dao.ILigneDao;
import fr.solutec.gestionStocks.service.ICommandeManager;
import fr.solutec.gestionStocks.service.ILigneManager;

/**
 * @author achankimponne
 * 
 */
@Service
public class LigneManager implements ILigneManager {

	@Autowired
	@Qualifier("ligneDao")
	private ILigneDao ligneDao;

	@Autowired
	@Qualifier("commandeDao")
	private ICommandeDao commandeDao;

	@Autowired
	@Qualifier("commandeManager")
	private ICommandeManager commandeManager;

	public ILigneDao getLigneDao() {
		return ligneDao;
	}

	public void setLigneDao(ILigneDao ligneDao) {
		this.ligneDao = ligneDao;
	}

	public ICommandeDao getCommandeDao() {
		return commandeDao;
	}

	public void setCommandeDao(ICommandeDao commandeDao) {
		this.commandeDao = commandeDao;
	}

	public List<Ligne> getLignesCommande(Integer id) {
		Commande commande = commandeDao.getById(id);

		return ligneDao.getLignesCommande(commande);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.solutec.gestionStocks.service.ILigneManager#getLigneById(java.lang
	 * .Integer)
	 */
	//@Override
	public Ligne getLigneById(Integer id) {
		if (id == null) {
			return null;
		}
		return this.getLigneDao().getById(id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.solutec.gestionStocks.service.ILigneManager#save(fr.solutec.gestionStocks
	 * .bean.Ligne)
	 */
	//@Override
	public Ligne save(Ligne ligne) {
		Ligne newLigne = null;
		if (ligne != null) {
			newLigne = this.getLigneDao().save(ligne);

			this.getCommandeManager().save(ligne.getCommande());

			return newLigne;
		}
		return null;
	}

	/**
	 * @return the commandeManager
	 */
	public ICommandeManager getCommandeManager() {
		return commandeManager;
	}

	/**
	 * @param commandeManager
	 *            the commandeManager to set
	 */
	public void setCommandeManager(ICommandeManager commandeManager) {
		this.commandeManager = commandeManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.solutec.gestionStocks.service.ILigneManager#deleteLigne(fr.solutec
	 * .gestionStocks.bean.Ligne)
	 */
	//@Override
	public void deleteLigne(Ligne ligne) {
		if (ligne != null) {
			Commande commande = ligne.getCommande();

			this.getLigneDao().delete(ligne);

			this.getCommandeManager().save(commande);

		}
	}
}
