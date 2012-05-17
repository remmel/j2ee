package fr.solutec.gestionStocks.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Bean représentant un service
 * 
 * @author achankimponne
 * 
 */
@Entity
@Table(name = "E_SERVICE")
public class Service extends GenericId {

	/**
	 * Nom du service
	 */
	private String nom;

	/**
	 * Le continent associé au service
	 */
	private Continent continent;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("Service");

		buffer.append("[");
		buffer.append("id=" + id).append(",nom=" + nom)
				.append(",continent=" + continent);
		buffer.append("]");

		return buffer.toString();
	}

	/**
	 * @return the nom
	 */
	@Column(name = "NOM")
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

	/**
	 * @return the continent
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CONTINENT_NO")
	public Continent getContinent() {
		return continent;
	}

	/**
	 * @param continent
	 *            the continent to set
	 */
	public void setContinent(Continent continent) {
		this.continent = continent;
	}
}
