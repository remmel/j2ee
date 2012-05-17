package fr.solutec.gestionStocks.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.solutec.gestionStocks.bean.Client;
import fr.solutec.gestionStocks.bean.Employe;
import fr.solutec.gestionStocks.dao.IClientDao;

/**
 * @author achankimponne
 * 
 */
@Repository
public class ClientDao extends GenericDao<Client, Integer> implements
		IClientDao {

	/**
	 * Logger
	 */
	private static final Logger log = Logger.getLogger(ClientDao.class);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Client> getAllClientsEmploye(Employe employe) {

		@SuppressWarnings("unchecked")
		List<Client> result = getSession().createCriteria(Client.class)
				.add(Restrictions.eq("employe", employe)).list();

		return result;
	}

}
