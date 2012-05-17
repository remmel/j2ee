package fr.solutec.gestionStocks.dao.impl;

import org.springframework.stereotype.Repository;

import fr.solutec.gestionStocks.bean.Titre;
import fr.solutec.gestionStocks.dao.ITitreDao;

/**
 * Implementation Hibernate de la couche dao de Titre
 * 
 * @author achankimponne
 * 
 */
@Repository
public class TitreDao extends GenericDao<Titre, String> implements ITitreDao {

}
