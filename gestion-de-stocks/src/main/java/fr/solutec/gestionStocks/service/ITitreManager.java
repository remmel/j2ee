package fr.solutec.gestionStocks.service;

import java.util.List;

import fr.solutec.gestionStocks.bean.Titre;

/**
 * Interface de la couche service de Titre
 * 
 * @author achankimponne
 * 
 */
public interface ITitreManager {

	/**
	 * R�cup�re un titre par son identifiant
	 * 
	 * @param id
	 *            {@link String}
	 * @return {@link Titre}
	 */
	public Titre getTitreById(String id);

	/**
	 * R�cup�re la liste de tous les {@link Titre}
	 * 
	 * @return {@link List}
	 */
	public List<Titre> getAllTitres();

	/**
	 * V�rifie qu'un titre existe par son identifiant
	 * 
	 * @param titre
	 * @return
	 */
	public boolean exists(String titre);

}
