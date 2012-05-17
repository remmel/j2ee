package fr.solutec.gestionStocks.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Interface de la couche DAO générique
 * 
 * @author achankimponne
 */
public interface IGenericDao<T, PK extends Serializable> {
	/**
	 * Récupere un objet T par son identifiant
	 * 
	 * @param id
	 *            {@link Integer} l'identifiant
	 * @return T
	 */
	public T getById(PK id);

	/**
	 * Récupère tous les objets T
	 * 
	 * @return {@link List}
	 */
	public List<T> getAll();

	/**
	 * Sauvegarde un objet T (crée ou met à jour)
	 * 
	 * @param persistentObject
	 * @return T l'objet sauvé
	 */
	public T save(T persistentObject);

	/**
	 * Supprime un objet T
	 * 
	 * @param persistentObject
	 */
	public void delete(T persistentObject);
}
