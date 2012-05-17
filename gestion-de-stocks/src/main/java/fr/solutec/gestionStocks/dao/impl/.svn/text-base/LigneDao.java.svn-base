package fr.solutec.gestionStocks.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.solutec.gestionStocks.bean.Commande;
import fr.solutec.gestionStocks.bean.Ligne;
import fr.solutec.gestionStocks.dao.ILigneDao;

/**
 * @author achankimponne
 * 
 */
@Repository
public class LigneDao extends GenericDao<Ligne, Integer> implements ILigneDao {

	/**
	 * Logger
	 */
	private static final Logger log = Logger.getLogger(Ligne.class);

	@Transactional
	public List<Ligne> getLignesCommande(Commande commande)
	{
		@SuppressWarnings("unchecked")
		List<Ligne> result =  getSession().createCriteria(Ligne.class)
		.add(Restrictions.eq("commande", commande)).list();

		return result;
	}

}
