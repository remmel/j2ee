package fr.solutec.gestionStocks.web.formBean;

import fr.solutec.gestionStocks.bean.Produit;
import fr.solutec.gestionStocks.util.NumberUtils;

/**
 * @author achankimponne
 * 
 */
public class ProduitFormBean {

	private Integer id;
	private String nom;
	private String description;
	private String prixConseille;

	public ProduitFormBean() {
	}

	public ProduitFormBean(Produit produit) {
		if (produit != null) {
			setId(produit.getId());
			setNom(produit.getNom());
			setDescription(produit.getDescription());

			if (produit.getPrixConseille() != null) {
				setPrixConseille(NumberUtils.doubleToString(
						produit.getPrixConseille(),
						NumberUtils.MONTANT_2_DECIMALES));
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
	 * @return the description
	 */
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
	public String getPrixConseille() {
		return prixConseille;
	}

	/**
	 * @param prixConseille
	 *            the prixConseille to set
	 */
	public void setPrixConseille(String prixConseille) {
		this.prixConseille = prixConseille;
	}
}
