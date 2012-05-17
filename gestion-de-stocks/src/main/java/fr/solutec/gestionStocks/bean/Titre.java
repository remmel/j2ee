package fr.solutec.gestionStocks.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Bean représentant un titre de civilité
 * 
 * @author achankimponne
 * 
 */
@Entity
@Table(name = "E_TITRE")
public class Titre {

	private String titre;

	@Id
	@Column(name = "TITRE", unique = true, nullable = false, length = 25)
	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	/*
	 * (non-Javadoc) s
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer(Titre.class.getName());

		buffer.append("[");
		buffer.append("titre=" + titre);
		buffer.append("]");

		return buffer.toString();
	}
}
