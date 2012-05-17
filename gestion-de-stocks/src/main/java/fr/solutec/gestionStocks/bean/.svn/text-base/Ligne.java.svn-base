package fr.solutec.gestionStocks.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author achankimponne
 * 
 */
@Entity
@Table(name = "E_LIGNE")
public class Ligne extends GenericId {

	private Commande commande;
	private Produit produit;
	private Double prix;
	private Integer quantite;

	@Deprecated
	private Integer qteLivree;

	/**
	 * @return the commande
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMMANDE_NO")
	public Commande getCommande() {
		return commande;
	}

	/**
	 * @param commande
	 *            the commande to set
	 */
	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	/**
	 * @return the produit
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUIT_NO")
	public Produit getProduit() {
		return produit;
	}

	/**
	 * @param produit
	 *            the produit to set
	 */
	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	/**
	 * @return the prix
	 */
	@Column(name = "PRIX")
	public Double getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(Double prix) {
		this.prix = prix;
	}

	/**
	 * @return the quantite
	 */
	@Column(name = "QUANTITE")
	public Integer getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite
	 *            the quantite to set
	 */
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	/**
	 * @return the qteLivree
	 */
	@Column(name = "QTE_LIVREE")
	public Integer getQteLivree() {
		return qteLivree;
	}

	/**
	 * @param qteLivree
	 *            the qteLivree to set
	 */
	public void setQteLivree(Integer qteLivree) {
		this.qteLivree = qteLivree;
	}

}
