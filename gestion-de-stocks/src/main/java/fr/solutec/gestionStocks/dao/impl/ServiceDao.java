package fr.solutec.gestionStocks.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import fr.solutec.gestionStocks.bean.Service;
import fr.solutec.gestionStocks.dao.IServiceDao;

/**
 * Implémentation Hibernate de la couche DAO de service
 * 
 * @author achankimponne
 * 
 */
@Repository("serviceDao")
public class ServiceDao extends GenericDao<Service, Integer> implements
		IServiceDao {

	/**
	 * Logger
	 */
	private static final Logger log = Logger.getLogger(ServiceDao.class);

}
