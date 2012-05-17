package fr.solutec.gestionStocks.dao;

import java.util.List;

import fr.solutec.gestionStocks.bean.Client;
import fr.solutec.gestionStocks.bean.Employe;

/**
 * @author achankimponne
 * 
 */
public interface IClientDao extends IGenericDao<Client, Integer> {

	public List<Client> getAllClientsEmploye(Employe employe);
}
