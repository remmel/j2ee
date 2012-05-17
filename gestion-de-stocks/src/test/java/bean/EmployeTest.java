/**
 * 
 */
package bean;

import junit.framework.TestCase;
import fr.solutec.gestionStocks.bean.Employe;

/**
 * @author achankimponne
 * 
 */
public class EmployeTest extends TestCase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testNom() {
		String nom = "testNom";
		Employe employe = new Employe();
		employe.setNom(nom);
		assertEquals(employe.getNom(), nom);
	}

	public void testPrenom() {
		String prenom = "testPrenom";
		Employe employe = new Employe();
		employe.setPrenom(prenom);
		assertEquals(employe.getPrenom(), prenom);
	}

}
