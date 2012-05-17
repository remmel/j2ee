/**
 * @author achankimponne
 * 
 */
public class test {

	public static void main(String[] args) {
	}

	public boolean isNullOrZero(String chaine) {
		boolean f = false;
		chaine = chaine.trim();
		if (chaine == null) {
			return true;
		}
		if (chaine.trim().length() == 0) {
			return true;
		}
		int i = 0;
		while (chaine.trim().length() > i) {
			if (chaine.trim().charAt(i) == '0') {
				return true;
			}
		}

		return f;
	}
}
