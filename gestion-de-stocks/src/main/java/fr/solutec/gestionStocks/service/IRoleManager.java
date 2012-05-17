package fr.solutec.gestionStocks.service;

import java.util.List;

import fr.solutec.gestionStocks.bean.Role;

/**
 * @author achankimponne
 * 
 */
public interface IRoleManager {

	/**
	 * R�cup�re la liste des roles d'un employ�
	 * 
	 * @return
	 */
	public List<Role> getListRolesByIdEmploye(Integer id);
}
