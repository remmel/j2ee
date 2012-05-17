package fr.solutec.gestionStocks.service;

import java.util.List;

import fr.solutec.gestionStocks.bean.Client;
import fr.solutec.gestionStocks.bean.Employe;

/**
 * @author achankimponne
 * 
 */
public interface IClientManager {
	/**
	 * Récupère la liste de tous les {@link Client}
	 * 
	 * @return {@link List}
	 */

	public List<Client> getClientsEmploye(Employe employe);

	public Client getClientById(Integer id);

	public Client saveClient(Client client);

	public void deleteClientById(Integer id);
}
