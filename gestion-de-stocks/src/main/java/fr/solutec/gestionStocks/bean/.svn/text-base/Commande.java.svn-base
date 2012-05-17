package fr.solutec.gestionStocks.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Bean d'une commande
 * 
 * @author achankimponne
 * 
 */
@Entity
@Table(name = "E_COMMANDE")
public class Commande extends GenericId {
	private Client client;
	private Date dateCommande;
	private Date dateLivraison;
	private Employe employe;
	private Double total;
	private String ntPaiement;
	private Boolean validite;

	/**
	 * @return the client
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENT_NO")
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the dateCommande
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_commande")
	public Date getDateCommande() {
		return dateCommande;
	}

	/**
	 * @param dateCommande
	 *            the dateCommande to set
	 */
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	/**
	 * @return the dateLivraison
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_livraison")
	public Date getDateLivraison() {
		return dateLivraison;
	}

	/**
	 * @param dateLivraison
	 *            the dateLivraison to set
	 */
	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	/**
	 * @return the employe
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMP_NO")
	public Employe getEmploye() {
		return employe;
	}

	/**
	 * @param employe
	 *            the employe to set
	 */
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	/**
	 * @return the total
	 */
	@Column(name = "total")
	public Double getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}

	/**
	 * @return the ntPaiement
	 */
	@Column(name = "nt_paiement")
	public String getNtPaiement() {
		return ntPaiement;
	}

	/**
	 * @param ntPaiement
	 *            the ntPaiement to set
	 */
	public void setNtPaiement(String ntPaiement) {
		this.ntPaiement = ntPaiement;
	}

	/**
	 * @return the validite
	 */
	@Column(name = "validite")
	public Boolean getValidite() {
		return validite;
	}

	/**
	 * @param validite
	 *            the validite to set
	 */
	public void setValidite(Boolean validite) {
		this.validite = validite;
	}
}
