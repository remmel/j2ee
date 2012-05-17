package fr.solutec.gestionStocks.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Bean d'un client
 * 
 * @author achankimponne
 * 
 */
@Entity
@Table(name = "E_CLIENT")
public class Client extends GenericId {
	private Continent continent;
	private Employe employe;
	private String nom;
	private String telephone;
	private String adresse;
	private String ville;
	private String departement;
	private String pays;
	private String cpPostal;
	private String solvabilite;
	private String commentaires;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONTINENT_NO")
	public Continent getContinent() {
		return this.continent;
	}

	public void setContinent(Continent Continent) {
		this.continent = Continent;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMP_NO")
	public Employe getEmploye() {
		return this.employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	@Column(name = "NOM", nullable = false, length = 50)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "TELEPHONE", length = 25)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "ADRESSE", length = 400)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "VILLE", length = 30)
	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Column(name = "DEPARTEMENT", length = 20)
	public String getDepartement() {
		return this.departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	@Column(name = "PAYS", length = 30)
	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@Column(name = "CP_POSTAL", length = 5)
	public String getCpPostal() {
		return this.cpPostal;
	}

	public void setCpPostal(String cpPostal) {
		this.cpPostal = cpPostal;
	}

	@Column(name = "SOLVABILITE", length = 9)
	public String getSolvabilite() {
		return this.solvabilite;
	}

	public void setSolvabilite(String solvabilite) {
		this.solvabilite = solvabilite;
	}

	@Column(name = "COMMENTAIRES")
	public String getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

}
