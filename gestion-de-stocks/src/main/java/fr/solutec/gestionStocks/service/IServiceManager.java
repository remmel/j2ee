package fr.solutec.gestionStocks.service;

import java.util.List;

import fr.solutec.gestionStocks.bean.Service;

/**
 * Interface de la couche service de service
 * 
 * @author achankimponne
 * 
 */
public interface IServiceManager {

	/**
	 * R�cup�re un service par son identifiant
	 * 
	 * @param id
	 *            {@link Integer}
	 * @return {@link Service}
	 */
	public Service getServiceById(Integer id);

	/**
	 * Sauvegarde un {@link Service}
	 * 
	 * @param employe
	 *            {@link Service}
	 * @return {@link Service}
	 */
	public Service saveService(Service service);

	/**
	 * R�cup�re la liste de tous les {@link Service}
	 * 
	 * @return {@link List}
	 */
	public List<Service> getAllServices();

	/**
	 * V�rifie qu'un service existe par son identifiant
	 * 
	 * @param id
	 * @return
	 */
	public boolean exists(Integer id);
}
