package fr.solutec.gestionStocks.dao.impl;

import org.springframework.stereotype.Repository;

import fr.solutec.gestionStocks.bean.Continent;
import fr.solutec.gestionStocks.dao.IContinentDao;

/**
 * @author achankimponne
 * 
 */
@Repository
public class ContinentDao extends GenericDao<Continent, Integer> implements
		IContinentDao {

}
