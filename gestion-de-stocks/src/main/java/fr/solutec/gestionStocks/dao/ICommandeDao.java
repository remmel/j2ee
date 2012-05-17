package fr.solutec.gestionStocks.dao;

import java.util.List;

import fr.solutec.gestionStocks.bean.Client;
import fr.solutec.gestionStocks.bean.Commande;

/**
 * @author achankimponne
 * 
 */
public interface ICommandeDao extends IGenericDao<Commande, Integer> {

	List<Commande> getCommandeByClient(Client client);

}
