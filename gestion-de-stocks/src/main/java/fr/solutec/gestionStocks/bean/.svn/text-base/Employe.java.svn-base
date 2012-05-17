package fr.solutec.gestionStocks.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Bean représentant un employe
 * 
 * @author achankimponne
 */
@Entity
@Table(name = "e_emp")
public class Employe extends GenericId {

	/**
	 * Nom de l'employe
	 */
	private String nom;

	/**
	 * Prenom de l'employe
	 */
	private String prenom;

	/**
	 * Nom d'utitlisateur de l'employe
	 */
	private String utilisateur;

	/**
	 * Date d'entrée
	 */
	private Date dateEntree;

	/**
	 * commentaires
	 */
	private String commentaires;

	/**
	 * titre de l'employe
	 */
	private Titre titre;

	/**
	 * salaire
	 */
	private Double salaire;

	/**
	 * pourcentage de la commission
	 */
	private Double pctCommission;

	/**
	 * Le service rattaché à l'employé
	 */
	private Service service;

	/**
	 * Le mot de passe de l'employé
	 */
	private String motDePasse;

	/**
	 * La liste des roles de l'employé
	 */
	private Set<Role> roles = new HashSet<Role>();

	/*
	 * (non-Javadoc) s
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer(Employe.class.getName());

		buffer.append("[");
		buffer.append("id=" + id).append(",nom=" + nom)
				.append(",prenom=" + prenom).append(",titre=" + titre)
				.append(",utilisateur=" + utilisateur)
				.append(",commentaires=" + commentaires)
				.append(",salaire=" + salaire)
				.append(",pctCommission=" + pctCommission)
				.append(",dateEntree=" + dateEntree)
				.append(",service=" + service)
				.append(",motDePasse=" + motDePasse);
		buffer.append("]");

		return buffer.toString();
	}

	/**
	 * @return nom {@link String}
	 */
	@Column(name = "NOM")
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            {@link String}
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return prenom {@link String}
	 */
	@Column(name = "PRENOM")
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            {@link String}
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the utilisateur
	 */
	@Column(name = "UTILISATEUR")
	public String getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur
	 *            the utilisateur to set
	 */
	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}

	/**
	 * @return the commentaires
	 */
	@Column(name = "COMMENTAIRES")
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
	 * @return the dateEntree
	 */
	@Column(name = "DT_ENTREE")
	public Date getDateEntree() {
		return dateEntree;
	}

	/**
	 * @param dateEntree
	 *            the dateEntree to set
	 */
	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	/**
	 * @return the titre
	 */
	@ManyToOne()
	@JoinColumn(name = "TITRE")
	public Titre getTitre() {
		return titre;
	}

	/**
	 * @param titre
	 *            the titre to set
	 */
	public void setTitre(Titre titre) {
		this.titre = titre;
	}

	/**
	 * @return the salaire
	 */
	@Column(name = "SALAIRE")
	public Double getSalaire() {
		return salaire;
	}

	/**
	 * @param salaire
	 *            the salaire to set
	 */
	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

	/**
	 * @return the pctCommission
	 */
	@Column(name = "PCT_COMMISSION")
	public Double getPctCommission() {
		return pctCommission;
	}

	/**
	 * @param pctCommission
	 *            the pctCommission to set
	 */
	public void setPctCommission(Double pctCommission) {
		this.pctCommission = pctCommission;
	}

	/**
	 * @return the service
	 */
	@ManyToOne()
	@JoinColumn(name = "SERVICE_NO")
	public Service getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(Service service) {
		this.service = service;
	}

	/**
	 * @return the motDePasse
	 */
	@Column(name = "MOT_DE_PASSE")
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse
	 *            the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * @return the roles
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employe")
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
