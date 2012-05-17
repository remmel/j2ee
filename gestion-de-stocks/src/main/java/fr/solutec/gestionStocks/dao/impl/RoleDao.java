package fr.solutec.gestionStocks.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.solutec.gestionStocks.bean.Role;
import fr.solutec.gestionStocks.dao.IRoleDao;

/**
 * @author achankimponne
 * 
 */
@Repository
public class RoleDao extends GenericDao<Role, Integer> implements IRoleDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.solutec.gestionStocks.dao.IRoleDao#getListRolesByIdEmploye(java.lang
	 * .Integer)
	 */
	//@Override
	public List<Role> getListRolesByIdEmploye(Integer id) {

		if (id == null) {
			return null;
		}

		@SuppressWarnings("unchecked")
		List<Role> roles = this.getSession()
				.createQuery("FROM ROLE WHERE EMP_NO = '" + id + "'").list();

		return roles;
	}

}
