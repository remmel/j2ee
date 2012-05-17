package fr.solutec.gestionStocks.dao;

import java.util.List;

import fr.solutec.gestionStocks.bean.Employe;

/**
 * Interface de la couche DAO d'employe
 * 
 * @author achankimponne
 */
public interface IEmployeDao extends IGenericDao<Employe, Integer> {

	/**
	 * Récupère la liste des employes affectés à un service
	 * 
	 * @param idService
	 * @return
	 */
	public List<Employe> getListEmployesByIdService(Integer idService);

	/**
	 * @param username
	 * @return
	 */
	public Employe getEmployeByUsername(String username);

}
