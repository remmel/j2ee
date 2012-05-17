package fr.solutec.gestionStocks.web.formBean;

import fr.solutec.gestionStocks.bean.Client;

/**
 * @author achankimponne
 * 
 */
public class ClientFormBean {

	// TODO Ajouter continent
	private Integer id;
	private EmployeFormBean employe;
	private String nom;
	private String telephone;
	private String adresse;
	private String ville;
	private String departement;
	private String pays;
	private String cpPostal;
	private String solvabilite;
	private String commentaires;

	public ClientFormBean() {
	}

	public ClientFormBean(Client client) {
		if (client != null) {
			setId(client.getId());
			setNom(client.getNom());
			if (client.getEmploye() != null) {
				setEmploye(new EmployeFormBean(client.getEmploye()));
			}

			setTelephone(client.getTelephone());
			setAdresse(client.getAdresse());

			setVille(client.getVille());

			setDepartement(client.getDepartement());
			setPays(client.getPays());
			setCpPostal(client.getCpPostal());
			setSolvabilite(client.getSolvabilite());
			setCommentaires(client.getCommentaires());
		}
	}

	/**
	 * @return the employe
	 */
	public EmployeFormBean getEmploye() {
		return employe;
	}

	/**
	 * @param employe
	 *            the employe to set
	 */
	public void setEmploye(EmployeFormBean employe) {
		this.employe = employe;
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

	/**
	 * @return the telephone
	 */
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

	/**
	 * @return the adresse
	 */
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
	 * @return the solvabilite
	 */
	public String getSolvabilite() {
		return solvabilite;
	}

	/**
	 * @param solvabilite
	 *            the solvabilite to set
	 */
	public void setSolvabilite(String solvabilite) {
		this.solvabilite = solvabilite;
	}

	/**
	 * @return the commentaires
	 */
	public String getCommentaires() {
		return commentaires;
	}

	/**
	 * @param commentaires
	 *            the commentaires to set
	 */
	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
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
}
