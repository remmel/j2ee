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
@Table(name = "E_ROLE")
public class Role extends GenericId {

	private Employe employe;

	private String authority;

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
	 * @return the authority
	 */
	@Column(name = "AUTHORITY")
	public String getAuthority() {
		return this.authority;
	}

	/**
	 * @param authority
	 *            the authority to set
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	/*
	 * (non-Javadoc) s
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer(Role.class.getName());

		buffer.append("[");
		buffer.append("id=" + id).append(",employe=" + employe)
				.append(",authority=" + authority);
		buffer.append("]");

		return buffer.toString();
	}

}
