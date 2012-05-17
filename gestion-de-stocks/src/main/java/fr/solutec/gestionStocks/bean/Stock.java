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
@Table(name = "E_STOCK")
@Deprecated
public class Stock extends GenericId {
	private Entrepot entrepot;
	private int qteStockee;
	private int maxStockee;
	private String detailSortie;
	private int stockSecurite;
	private Produit produit;

	/**
	 * @return the entrepot
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ENTREPOT_NO")
	public Entrepot getEntrepot() {
		return entrepot;
	}

	/**
	 * @param entrepot
	 *            the entrepot to set
	 */
	public void setEntrepot(Entrepot entrepot) {
		this.entrepot = entrepot;
	}

	/**
	 * @return the qteStockee
	 */
	@Column(name = "QTE_STOCKEE")
	public int getQteStockee() {
		return qteStockee;
	}

	/**
	 * @param qteStockee
	 *            the qteStockee to set
	 */
	public void setQteStockee(int qteStockee) {
		this.qteStockee = qteStockee;
	}

	/**
	 * @return the maxStockee
	 */
	@Column(name = "MAX_STOCKEE")
	public int getMaxStockee() {
		return maxStockee;
	}

	/**
	 * @param maxStockee
	 *            the maxStockee to set
	 */
	public void setMaxStockee(int maxStockee) {
		this.maxStockee = maxStockee;
	}

	/**
	 * @return the detailSortie
	 */
	@Column(name = "DETAIL_SORTIE")
	public String getDetailSortie() {
		return detailSortie;
	}

	/**
	 * @param detailSortie
	 *            the detailSortie to set
	 */
	public void setDetailSortie(String detailSortie) {
		this.detailSortie = detailSortie;
	}

	/**
	 * @return the stockSecurite
	 */
	@Column(name = "STOCK_SECURITE")
	public int getStockSecurite() {
		return stockSecurite;
	}

	/**
	 * @param stockSecurite
	 *            the stockSecurite to set
	 */
	public void setStockSecurite(int stockSecurite) {
		this.stockSecurite = stockSecurite;
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
}
