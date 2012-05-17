package fr.solutec.gestionStocks.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author achankimponne
 * 
 */
@Entity
@Table(name = "E_PRODUIT")
public class Produit extends GenericId {
	private String nom;
	private String description;
	private Double prixConseille;

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
	 * @return the description
	 */
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the prixConseille
	 */
	@Column(name = "PRIX_CONSEILLE")
	public Double getPrixConseille() {
		return prixConseille;
	}

	/**
	 * @param prixConseille
	 *            the prixConseille to set
	 */
	public void setPrixConseille(Double prixConseille) {
		this.prixConseille = prixConseille;
	}

}
