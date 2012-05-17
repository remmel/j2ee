package fr.solutec.gestionStocks.service;

import java.util.List;

import fr.solutec.gestionStocks.bean.Employe;
import fr.solutec.gestionStocks.bean.enums.AuthorityEnum;

/**
 * Interface de la couche service d'employe
 * 
 * @author achankimponne
 * 
 */
public interface IEmployeManager {

	/**
	 * Récupère un employe par son identifiant
	 * 
	 * @param id
	 *            {@link Integer}
	 * @return {@link Employe}
	 */
	public Employe getEmployeById(Integer id);

	/**
	 * Sauvegarde un {@link Employe}
	 * 
	 * @param employe
	 *            {@link Employe}
	 * @return {@link Employe}
	 */
	public Employe saveEmploye(Employe employe);

	/**
	 * Récupère la liste de tous les {@link Employe}
	 * 
	 * @return {@link List}
	 */
	public List<Employe> getAllEmployes();

	/**
	 * Récupère la liste des employes affectés à un service
	 * 
	 * @param idService
	 * @return
	 */
	public List<Employe> getListEmployesByIdService(Integer idService);

	/**
	 * Supprime un employe
	 * 
	 * @param id
	 * @return
	 */
	public void deleteEmployeById(Integer id);

	/**
	 * @param username
	 * @param password
	 * @return
	 */
	public Employe getEmployeByUsername(String username);

	/**
	 * Vérifie l'existence d'un utilisateur
	 * 
	 * @param username
	 * @return
	 */
	public boolean existUsername(String username);

	/**
	 * Sauvegarde une liste de droits (ajoute ou supprime) d'un utilisateur
	 * 
	 * @param employe
	 * @param authorities
	 */
	public void saveAuthorities(Employe employe, List<AuthorityEnum> authorities);
}
