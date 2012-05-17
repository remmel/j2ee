package fr.solutec.gestionStocks.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.solutec.gestionStocks.dao.IServiceDao;
import fr.solutec.gestionStocks.service.IServiceManager;

/**
 * Implémentation de la couche service de service
 * 
 * @author achankimponne
 * 
 */
@Service("serviceManager")
public class ServiceManager implements IServiceManager {

	/**
	 * Logger
	 */
	private static final Logger log = Logger.getLogger(ServiceManager.class);

	/**
	 * Dao {@link Service}
	 */
	@Autowired
	@Qualifier("serviceDao")
	private IServiceDao serviceDao;

	/**
	 * @return the serviceDao
	 */
	public IServiceDao getServiceDao() {
		return serviceDao;
	}

	/**
	 * @param serviceDao
	 *            the serviceDao to set
	 */
	public void setServiceDao(IServiceDao serviceDao) {
		this.serviceDao = serviceDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.solutec.gestionStocks.service.IServiceManager#getServiceById(java.
	 * lang.Integer)
	 */
	//@Override
	public fr.solutec.gestionStocks.bean.Service getServiceById(Integer id) {
		if (id == null || id < 0) {
			// TODO lancer exception
			return null;
		}
		return this.getServiceDao().getById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.solutec.gestionStocks.service.IServiceManager#saveService(fr.solutec
	 * .gestionStocks.bean.Service)
	 */
	//@Override
	public fr.solutec.gestionStocks.bean.Service saveService(
			fr.solutec.gestionStocks.bean.Service service) {
		if (service == null) {
			return null;
		}
		return this.getServiceDao().save(service);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.solutec.gestionStocks.service.IServiceManager#getAllServices()
	 */
	//@Override
	public List<fr.solutec.gestionStocks.bean.Service> getAllServices() {
		return this.getServiceDao().getAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.solutec.gestionStocks.service.IServiceManager#exists(java.lang.Integer
	 * )
	 */
	//@Override
	public boolean exists(Integer id) {
		if (log.isDebugEnabled()) {
			log.debug("id:" + id);
		}

		if (id == null || id < 0) {
			// TODO lancer exception
			return false;
		}

		if (log.isDebugEnabled()) {
			log.debug("this.getServiceDao().getById(id):"
					+ this.getServiceDao().getById(id));
		}

		if (this.getServiceDao().getById(id) != null) {
			return true;
		}
		return false;
	}
}
