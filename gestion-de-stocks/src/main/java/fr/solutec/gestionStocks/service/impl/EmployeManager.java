package fr.solutec.gestionStocks.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.solutec.gestionStocks.bean.Employe;
import fr.solutec.gestionStocks.bean.Role;
import fr.solutec.gestionStocks.bean.enums.AuthorityEnum;
import fr.solutec.gestionStocks.dao.IEmployeDao;
import fr.solutec.gestionStocks.dao.IRoleDao;
import fr.solutec.gestionStocks.service.IEmployeManager;
import fr.solutec.gestionStocks.util.StringUtils;

/**
 * Implémentation de la couche service d'employe
 * 
 * @author achankimponne
 * 
 */
@Service("employeManager")
public class EmployeManager implements IEmployeManager {

	/**
	 * Logger
	 */
	private static final Logger log = Logger.getLogger(EmployeManager.class);

	/**
	 * Dao {@link Employe}
	 */
	@Autowired
	@Qualifier("employeDao")
	private IEmployeDao employeDao;

	/**
	 * Dao {@link Role}
	 */
	@Autowired
	@Qualifier("roleDao")
	private IRoleDao roleDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.solutec.gestionStocks.service.IEmployeManager#saveEmploye(fr.solutec
	 * .gestionStocks.bean.Employe)
	 */
	public Employe saveEmploye(Employe employe) {
		if (employe == null) {
			// TODO lancer exception
			return null;
		}
		return employeDao.save(employe);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.solutec.gestionStocks.service.IEmployeManager#getAllEmployes()
	 */
	//@Override
	public List<Employe> getAllEmployes() {
		return getEmployeDao().getAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.solutec.gestionStocks.service.IEmployeManager#getEmployeById(java.
	 * lang.Integer)
	 */
	//@Override
	public Employe getEmployeById(Integer id) {
		if (id == null || id < 0) {
			// TODO lancer exception
			return null;
		}

		return employeDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.solutec.gestionStocks.service.IEmployeManager#getListEmployesByIdService
	 * (java.lang.Integer)
	 */
	//@Override
	public List<Employe> getListEmployesByIdService(Integer idService) {
		if (idService == null || idService < 0) {
			// TODO lancer exception
			return null;
		}
		return employeDao.getListEmployesByIdService(idService);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.solutec.gestionStocks.service.IEmployeManager#deleteEmployeById(java
	 * .lang.Integer)
	 */
	//@Override
	public void deleteEmployeById(Integer id) {
		if (id == null || id <= 0) {
			// TODO envoyer exception
		}

		Employe employe = this.getEmployeById(id);

		if (employe == null) {
			// TODO envoyer exception
		} else {
			employeDao.delete(employe);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.solutec.gestionStocks.service.IEmployeManager#getEmploye(java.lang
	 * .String, java.lang.String)
	 */
	public Employe getEmployeByUsername(String username) {
		if (StringUtils.isNullOrEmpty(username)) {
			return null;
		}
		return employeDao.getEmployeByUsername(username);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.solutec.gestionStocks.service.IEmployeManager#existUsername(java.lang
	 * .String)
	 */
	//@Override
	public boolean existUsername(String username) {
		Employe employe = this.getEmployeByUsername(username);

		if (employe == null) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.solutec.gestionStocks.service.IEmployeManager#saveAuthorities(fr.solutec
	 * .gestionStocks.bean.Employe, java.util.List)
	 */
	//@Override
	public void saveAuthorities(Employe employe, List<AuthorityEnum> authorities) {
		if (employe != null && authorities != null && authorities.size() > 0) {
			List<Role> rolesAGarder = new ArrayList<Role>();
			List<Role> rolesASupprimer = new ArrayList<Role>();
			List<AuthorityEnum> rolesAAjouter = new ArrayList<AuthorityEnum>();

			rolesAAjouter.addAll(authorities);

			if (employe.getRoles() != null) {
				for (Role role : employe.getRoles()) {
					boolean estPresent = false;
					for (AuthorityEnum authority : authorities) {
						if (authority.getValue().equals(role.getAuthority())) {
							rolesAGarder.add(role);
							estPresent = true;
						}
					}

					if (!estPresent) {
						rolesASupprimer.add(role);
					}

					rolesAAjouter
							.remove(AuthorityEnum.get(role.getAuthority()));
				}
			}

			for (Role role : rolesASupprimer) {
				this.getRoleDao().delete(role);
			}
			for (AuthorityEnum authority : rolesAAjouter) {
				Role role = new Role();
				role.setEmploye(employe);
				role.setAuthority(authority.getValue());
				this.getRoleDao().save(role);
			}
		}
	}

	/**
	 * @return {@link IEmployeDao}m
	 */
	public IEmployeDao getEmployeDao() {
		return employeDao;
	}

	/**
	 * @param employeDao
	 *            {@link IEmployeDao}
	 */
	public void setEmployeDao(IEmployeDao employeDao) {
		this.employeDao = employeDao;
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
