package fr.solutec.gestionStocks.service;

import java.util.List;

import fr.solutec.gestionStocks.bean.Produit;

/**
 * @author achankimponne
 * 
 */
public interface IProduitManager {

	List<Produit> getAll();

	Produit getProduitById(Integer id);

	Produit saveProduit(Produit produit);

	void deleteProduitByID(Integer id);

	/**
	 * Récupère le prix conseillé d'un produit
	 * 
	 * @param id
	 * @return
	 */
	public Double getPrixConseilleByIdProduit(Integer id);

}
