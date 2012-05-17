package fr.solutec.gestionStocks.web.formBean;

import org.springframework.stereotype.Component;

import fr.solutec.gestionStocks.bean.Service;

/**
 * Bean d'affichage d'un service
 * 
 * @author achankimponne
 * 
 */
@Component
public class ServiceFormBean {

	private Integer id;

	private String nom;

	public ServiceFormBean() {
	}

	public ServiceFormBean(Service service) {
		if (service != null) {
			setId(service.getId());
			setNom(service.getNom());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer(ServiceFormBean.class.getName());

		string.append("[");
		string.append("id=" + id).append(",nom=" + nom);
		string.append("]");

		return string.toString();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
}
