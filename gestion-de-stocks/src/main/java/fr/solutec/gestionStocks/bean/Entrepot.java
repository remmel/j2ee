package fr.solutec.gestionStocks.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * bean d'un entrepot
 * 
 * @author achankimponne
 * 
 */
@Entity
@Table(name = "E_ENTREPOT")
public class Entrepot extends GenericId {

	private Continent continent;
	private String adresse;
	private String ville;
	private String departement;
	private String pays;
	private String cpPostal;
	private String telephone;

	/**
	 * @return the continent
	 */
	@ManyToOne(fetch = FetchType.LAZY)
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

	/**
	 * @return the adresse
	 */
	@Column(name = "ADRESSE")
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the ville
	 */
	@Column(name = "VILLE")
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville
	 *            the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the departement
	 */
	@Column(name = "DEPARTEMENT")
	public String getDepartement() {
		return departement;
	}

	/**
	 * @param departement
	 *            the departement to set
	 */
	public void setDepartement(String departement) {
		this.departement = departement;
	}

	/**
	 * @return the pays
	 */
	@Column(name = "PAYS")
	public String getPays() {
		return pays;
	}

	/**
	 * @param pays
	 *            the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * @return the cpPostal
	 */
	@Column(name = "CP_POSTAL")
	public String getCpPostal() {
		return cpPostal;
	}

	/**
	 * @param cpPostal
	 *            the cpPostal to set
	 */
	public void setCpPostal(String cpPostal) {
		this.cpPostal = cpPostal;
	}

	/**
	 * @return the telephone
	 */
	@Column(name = "TELEPHONE")
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
