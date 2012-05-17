package fr.solutec.gestionStocks.web.formBean;

import fr.solutec.gestionStocks.bean.Ligne;
import fr.solutec.gestionStocks.util.NumberUtils;

/**
 * @author achankimponne
 * 
 */
public class LigneFormBean {
	private Integer id;
	private Integer idCommande;
	private Integer idProduit;
	private String prix;
	private Integer quantite;

	public LigneFormBean() {
		setQuantite(0);
		setPrix("-");
	}

	public LigneFormBean(Ligne ligne) {
		if (ligne != null) {
			setId(ligne.getId());
			if (ligne.getCommande() != null) {
				setIdCommande(ligne.getCommande().getId());

			}

			if (ligne.getProduit() != null) {
				setIdProduit(ligne.getProduit().getId());
			}

			if (ligne.getPrix() != null) {
				setPrix(NumberUtils.doubleToString(ligne.getPrix(),
						NumberUtils.MONTANT_2_DECIMALES));
			}
			setQuantite(ligne.getQuantite());
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
	 * @return the idCommande
	 */
	public Integer getIdCommande() {
		return idCommande;
	}

	/**
	 * @param idCommande
	 *            the idCommande to set
	 */
	public void setIdCommande(Integer idCommande) {
		this.idCommande = idCommande;
	}

	/**
	 * @return the idProduit
	 */
	public Integer getIdProduit() {
		return idProduit;
	}

	/**
	 * @param idProduit
	 *            the idProduit to set
	 */
	public void setIdProduit(Integer idProduit) {
		this.idProduit = idProduit;
	}

	/**
	 * @return the prix
	 */
	public String getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(String prix) {
		this.prix = prix;
	}

	/**
	 * @return the quantite
	 */
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
}
