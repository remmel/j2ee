package fr.solutec.gestionStocks.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.solutec.gestionStocks.bean.Client;
import fr.solutec.gestionStocks.bean.Commande;
import fr.solutec.gestionStocks.dao.ICommandeDao;

/**
 * @author achankimponne
 * 
 */
@Repository
public class CommandeDao extends GenericDao<Commande, Integer> implements
		ICommandeDao {

	/**
	 * Logger
	 */
	private static final Logger log = Logger.getLogger(Commande.class);
	
	@Transactional
	public List<Commande> getCommandeByClient(Client client)
	{

		@SuppressWarnings("unchecked")
		List<Commande> result =  getSession().createCriteria(Commande.class)
				.add(Restrictions.eq("client", client)).list();

		return result;
		
	}
}
