package fr.solutec.gestionStocks.web.formBean;

import java.util.ArrayList;
import java.util.List;

import fr.solutec.gestionStocks.bean.Employe;
import fr.solutec.gestionStocks.bean.Role;
import fr.solutec.gestionStocks.bean.enums.AuthorityEnum;
import fr.solutec.gestionStocks.util.DateUtils;
import fr.solutec.gestionStocks.util.NumberUtils;

/**
 * Bean d'affichage d'un employe
 * 
 * @author achankimponne
 * 
 */
public class EmployeFormBean {

	/**
	 * Identifiant de l'employe
	 */
	private Integer id;

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
	 * Mot de passe de l'employé
	 */
	private String motDePasse;

	/**
	 * Confirmation du mot de passe de l'employé
	 */
	private String confirmationMotDePasse;

	/**
	 * Date d'entrée
	 */
	private String dateEntree;

	/**
	 * commentaires
	 */
	private String commentaires;

	/**
	 * titre de l'employe
	 */
	private String titre;

	/**
	 * salaire
	 */
	private String salaire;

	/**
	 * pourcentage de la commission
	 */
	private String pctCommission;

	/**
	 * Le nom du service
	 */
	private ServiceFormBean service;

	/**
	 * Liste des roles de l'employé
	 */
	private List<AuthorityEnum> authorities;

	public EmployeFormBean() {
	}

	public EmployeFormBean(Employe employe) {
		if (employe != null) {
			setId(employe.getId());
			setNom(employe.getNom());
			setPrenom(employe.getPrenom());
			if (employe.getTitre() != null) {
				setTitre(employe.getTitre().getTitre());
			}

			setUtilisateur(employe.getUtilisateur());
			setCommentaires(employe.getCommentaires());
			if (employe.getSalaire() != null) {
				setSalaire(NumberUtils.doubleToString(employe.getSalaire(),
						NumberUtils.MONTANT_2_DECIMALES));
			}
			if (employe.getPctCommission() != null) {
				setPctCommission(NumberUtils.doubleToString(
						employe.getPctCommission(),
						NumberUtils.MONTANT_2_DECIMALES));
			}
			if (employe.getDateEntree() != null) {
				setDateEntree(DateUtils.dateToString(employe.getDateEntree(),
						DateUtils.FORMAT_DDMMYYYY));
			}
			ServiceFormBean serviceInfoData = null;
			if (employe.getService() != null) {
				serviceInfoData = new ServiceFormBean(employe.getService());

			} else {
				// serviceInfoData = new ServiceInfoData();
			}
			setService(serviceInfoData);

			if (employe.getRoles() != null) {
				authorities = new ArrayList<AuthorityEnum>();
				for (Role role : employe.getRoles()) {
					authorities.add(AuthorityEnum.get(role.getAuthority()));
				}
			}
		}
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

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the utilisateur
	 */
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
	 * @return the dateEntree
	 */
	public String getDateEntree() {
		return dateEntree;
	}

	/**
	 * @param dateEntree
	 *            the dateEntree to set
	 */
	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
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
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre
	 *            the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the salaire
	 */
	public String getSalaire() {
		return salaire;
	}

	/**
	 * @param salaire
	 *            the salaire to set
	 */
	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}

	/**
	 * @return the pctCommission
	 */
	public String getPctCommission() {
		return pctCommission;
	}

	/**
	 * @param pctCommission
	 *            the pctCommission to set
	 */
	public void setPctCommission(String pctCommission) {
		this.pctCommission = pctCommission;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer(EmployeFormBean.class.getName());

		string.append("[");
		string.append("id=" + id).append(",nom=" + nom)
				.append(",prenom=" + prenom).append(",titre=" + titre)
				.append(",utilisateur=" + utilisateur)
				.append(",commentaires=" + commentaires)
				.append(",salaire=" + salaire)
				.append(",pctCommission=" + pctCommission)
				.append(",dateEntree=" + dateEntree)
				.append(",service=" + service)
				.append(",motDePasse=" + motDePasse)
				.append(",confirmationMotDePasse=" + confirmationMotDePasse);
		string.append("]");

		return string.toString();
	}

	/**
	 * @return the service
	 */
	public ServiceFormBean getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(ServiceFormBean service) {
		this.service = service;
	}

	/**
	 * @return the motDePasse
	 */
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
	 * @return the confirmationMotDePasse
	 */
	public String getConfirmationMotDePasse() {
		return confirmationMotDePasse;
	}

	/**
	 * @param confirmationMotDePasse
	 *            the confirmationMotDePasse to set
	 */
	public void setConfirmationMotDePasse(String confirmationMotDePasse) {
		this.confirmationMotDePasse = confirmationMotDePasse;
	}

	/**
	 * @return the authorities
	 */
	public List<AuthorityEnum> getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities
	 *            the authorities to set
	 */
	public void setAuthorities(List<AuthorityEnum> authorities) {
		this.authorities = authorities;
	}

}
