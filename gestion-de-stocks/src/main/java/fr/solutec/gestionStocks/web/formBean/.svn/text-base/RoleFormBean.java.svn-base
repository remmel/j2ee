package fr.solutec.gestionStocks.web.formBean;

import fr.solutec.gestionStocks.bean.Role;
import fr.solutec.gestionStocks.bean.enums.AuthorityEnum;

/**
 * @author achankimponne
 * 
 */
public class RoleFormBean {

	private Integer id;

	private AuthorityEnum authority;

	public RoleFormBean() {
	}

	public RoleFormBean(Role role) {
		if (role != null) {
			this.setId(role.getId());

			this.setAuthority(AuthorityEnum.get(role.getAuthority()));
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
	 * @return the authority
	 */
	public AuthorityEnum getAuthority() {
		return authority;
	}

	/**
	 * @param authority
	 *            the authority to set
	 */
	public void setAuthority(AuthorityEnum authority) {
		this.authority = authority;
	}
}
