package fr.solutec.gestionStocks.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.solutec.gestionStocks.bean.Employe;
import fr.solutec.gestionStocks.dao.IEmployeDao;

/**
 * Implémentation Hibernate de la couche DAO d'employe
 * 
 * @author achankimponne
 * 
 */
@Repository("employeDao")
public class EmployeDao extends GenericDao<Employe, Integer> implements
		IEmployeDao {

	/**
	 * Logger
	 */
	private static final Logger log = Logger.getLogger(EmployeDao.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.solutec.gestionStocks.dao.IEmployeDao#getListEmployesByIdService(java
	 * .lang.Integer)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Employe> getListEmployesByIdService(Integer idService) {
		if (idService == null) {
			return null;
		}

		@SuppressWarnings("unchecked")
		List<Employe> employes = this
				.getSession()
				.createQuery(
						"FROM Employe WHERE service_no = '" + idService + "'")
				.list();

		return employes;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Employe getEmployeByUsername(String username) {
		Employe result = (Employe) getSession().createCriteria(Employe.class)
		// .add(Restrictions.and(Restrictions.eq("utilisateur", username),
		// Restrictions.eq("motDePasse", password)))
				.add(Restrictions.eq("utilisateur", username)).uniqueResult();
		return result;
	}

}
