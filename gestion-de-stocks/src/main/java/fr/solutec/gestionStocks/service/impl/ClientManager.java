package fr.solutec.gestionStocks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.solutec.gestionStocks.bean.Client;
import fr.solutec.gestionStocks.bean.Employe;
import fr.solutec.gestionStocks.dao.IClientDao;
import fr.solutec.gestionStocks.service.IClientManager;

/**
 * @author achankimponne
 * 
 */
@Service
public class ClientManager implements IClientManager {

	/**
	 * Dao {@link Client}
	 */
	@Autowired
	@Qualifier("clientDao")
	private IClientDao ClientDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.solutec.gestionStocks.service.IClientManager#getClientsEmploye(Employe
	 * employe)
	 */
	public List<Client> getClientsEmploye(Employe employe) {
		return ClientDao.getAllClientsEmploye(employe);
	}

	public Client getClientById(Integer id) {
		return ClientDao.getById(id);
	}

	public Client saveClient(Client client) {
		return ClientDao.save(client);
	}

	public void deleteClientById(Integer id) {
		if (id != null && id > 0) {
			Client client = ClientDao.getById(id);

			if (client != null) {
				ClientDao.delete(client);
			}
		}

	}

	/**
	 * @return the clientDao
	 */
	public IClientDao getClientDao() {
		return ClientDao;
	}

	/**
	 * l
	 * 
	 * @param clientDao
	 *            the clientDao to set
	 */
	public void setClientDao(IClientDao clientDao) {
		ClientDao = clientDao;
	}

}
