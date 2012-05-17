package fr.solutec.gestionStocks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.solutec.gestionStocks.bean.Role;
import fr.solutec.gestionStocks.dao.IRoleDao;
import fr.solutec.gestionStocks.service.IRoleManager;

/**
 * @author achankimponne
 * 
 */
@Service
public class RoleManager implements IRoleManager {

	/**
	 * Dao {@link Role}
	 */
	@Autowired
	@Qualifier("roleDao")
	private IRoleDao roleDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.solutec.gestionStocks.service.IRoleManager#getListRoles()
	 */
	//@Override
	public List<Role> getListRolesByIdEmploye(Integer id) {
		return this.getRoleDao().getListRolesByIdEmploye(id);
	}

	/**
	 * @return the roleDao
	 */
	public IRoleDao getRoleDao() {
		return roleDao;
	}

	/**
	 * @param roleDao
	 *            the roleDao to set
	 */
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

}
