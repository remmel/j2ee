package fr.solutec.gestionStocks.dao.impl;

import org.springframework.stereotype.Repository;

import fr.solutec.gestionStocks.bean.Entrepot;
import fr.solutec.gestionStocks.dao.IEntrepotDao;

/**
 * @author achankimponne
 * 
 */
@Repository
public class EntrepotDao extends GenericDao<Entrepot, Integer> implements
		IEntrepotDao {

}
