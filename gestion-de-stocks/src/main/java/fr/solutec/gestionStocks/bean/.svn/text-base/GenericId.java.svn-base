package fr.solutec.gestionStocks.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * Classe générique des identifiants
 * 
 * @author achankimponne
 * 
 */
@MappedSuperclass
public abstract class GenericId {
	/**
	 * Identifiant
	 */
	protected Integer id;

	/**
	 * @return id {@link Integer}
	 */
	@Id
	@GenericGenerator(name = "genId", strategy = "increment")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "genId")
	@Column(name = "NO", precision = 7, scale = 0)
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            {@link Integer}
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
