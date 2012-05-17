package fr.solutec.gestionStocks.web.formBean;

import fr.solutec.gestionStocks.bean.Commande;
import fr.solutec.gestionStocks.util.DateUtils;
import fr.solutec.gestionStocks.util.NumberUtils;

/**
 * @author achankimponne
 * 
 */
public class CommandeFormBean {
	private Integer id;

	private String dateCommande;

	private String dateLivraison;

	private String total;

	private String ntPaiement;

	private Boolean validite;

	public CommandeFormBean() {
	}

	public CommandeFormBean(Commande commande) {
		if (commande != null) {
			setId(commande.getId());
			setDateCommande(DateUtils.dateToString(commande.getDateCommande(),
					DateUtils.FORMAT_DDMMYYYY));
			setDateLivraison(DateUtils.dateToString(
					commande.getDateLivraison(), DateUtils.FORMAT_DDMMYYYY));
			setTotal(NumberUtils.doubleToString(commande.getTotal(),
					NumberUtils.MONTANT_2_DECIMALES));
			setNtPaiement(commande.getNtPaiement());
			setValidite(commande.getValidite());

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
	 * @return the dateCommande
	 */
	public String getDateCommande() {
		return dateCommande;
	}

	/**
	 * @param dateCommande
	 *            the dateCommande to set
	 */
	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}

	/**
	 * @return the dateLivraison
	 */
	public String getDateLivraison() {
		return dateLivraison;
	}

	/**
	 * @param dateLivraison
	 *            the dateLivraison to set
	 */
	public void setDateLivraison(String dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	/**
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(String total) {
		this.total = total;
	}

	/**
	 * @return the ntPaiement
	 */
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
