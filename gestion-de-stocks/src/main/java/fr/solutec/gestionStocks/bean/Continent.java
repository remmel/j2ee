package fr.solutec.gestionStocks.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Bean représentant un continent
 * 
 * @author achankimponne
 * 
 */
@Entity
@Table(name = "E_CONTINENT")
public class Continent extends GenericId {

	private String nom;

	@Column(name = "NOM", nullable = false, length = 50)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}