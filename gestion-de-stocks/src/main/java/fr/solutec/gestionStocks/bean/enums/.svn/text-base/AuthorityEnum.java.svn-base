package fr.solutec.gestionStocks.bean.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author achankimponne
 * 
 */
public enum AuthorityEnum {
	ROLE_USER("ROLE_USER"), ROLE_ADMIN("ROLE_ADMIN");

	private static final Map<String, AuthorityEnum> lookup = new HashMap<String, AuthorityEnum>();

	static {
		for (AuthorityEnum t : EnumSet.allOf(AuthorityEnum.class))
			lookup.put(t.getValue(), t);
	}

	private final String value;

	private AuthorityEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static AuthorityEnum get(String value) {
		return lookup.get(value);
	}

	public static List<AuthorityEnum> getList() {
		return new ArrayList<AuthorityEnum>(lookup.values());
	}

	public static List<String> getListValues() {
		return new ArrayList<String>(lookup.keySet());
	}
}
