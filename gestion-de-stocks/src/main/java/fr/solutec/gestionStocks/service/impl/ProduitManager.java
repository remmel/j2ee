package fr.solutec.gestionStocks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.solutec.gestionStocks.bean.Produit;
import fr.solutec.gestionStocks.dao.IProduitDao;
import fr.solutec.gestionStocks.service.IProduitManager;

/**
 * @author achankimponne
 * 
 */
@Service
public class ProduitManager implements IProduitManager {

	@Autowired
	@Qualifier("produitDao")
	private IProduitDao produitDao;

	public IProduitDao getProduitDao() {
		return produitDao;
	}

	public void setProduitDao(IProduitDao produitDao) {
		this.produitDao = produitDao;
	}

	//@Override
	public List<Produit> getAll() {
		return produitDao.getAll();
	}

	//@Override
	public Produit getProduitById(Integer id) {
		return produitDao.getById(id);
	}

	//@Override
	public Produit saveProduit(Produit produit) {
		return produitDao.save(produit);
	}

	//@Override
	public void deleteProduitByID(Integer id) {
		Produit produit = produitDao.getById(id);
		produitDao.delete(produit);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.solutec.gestionStocks.service.IProduitManager#getPrixConseilleByIdProduit
	 * (java.lang.Integer)
	 */
	//@Override
	public Double getPrixConseilleByIdProduit(Integer id) {
		if (id == null) {
			return null;
		}

		Produit produit = this.getProduitById(id);
		if (produit != null) {
			return produit.getPrixConseille();
		}

		return null;

	}

}
