package fr.solutec.gestionStocks.service;

import java.util.List;

import fr.solutec.gestionStocks.bean.Commande;

/**
 * @author achankimponne
 * 
 */
public interface ICommandeManager {

	public List<Commande> getCommandesByIdClient(Integer id);

	/**
	 * Récupère une commande par son identifiant
	 * 
	 * @param id
	 * @return
	 */
	public Commande getCommandeById(Integer id);

	/**
	 * Sauvegarde une commande
	 * 
	 * @param commande
	 * @return
	 */
	public Commande save(Commande commande);

	/**
	 * Calcule le montant total d'une commande
	 * 
	 * @param commande
	 */
	public Double calculTotal(Commande commande);

	/**
	 * Supprime une commande
	 * 
	 * @param commande
	 */
	public void delete(Commande commande);
}
