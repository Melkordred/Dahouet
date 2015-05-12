package JUnit;

import org.junit.Test;

import Dahouapp.Appouet;
import Model.Personne;
import static org.junit.Assert.*;

public class Jtest 
{

	@Test
	public void testIsValidEMail() {
		
		assertEquals(true, Personne.ctlMail("lionel.duboeuf@gmail.com"));
		
		assertEquals(false, Personne.ctlMail("lionel.duboeufgmail.com"));
		
		assertEquals(false, Personne.ctlMail("l$gmail.com"));
		
		assertEquals(false, Personne.ctlMail("l$ @gmail.com"));
		
		assertEquals(false, Personne.ctlMail("l785@gmai@l.com"));
		
	}
	
	@Test
	public void testIsDateValid(){
		
		assertEquals(true, Appouet.isValidDate("2004/01/01"));
		assertEquals(false, Appouet.isValidDate("20111/01/01"));
		assertEquals(false, Appouet.isValidDate("2011/011/01"));
		assertEquals(false, Appouet.isValidDate("2011/01/001"));
		assertEquals(false, Appouet.isValidDate("2011/001/001"));
		assertEquals(false, Appouet.isValidDate("01/01/2004"));
		assertEquals(false, Appouet.isValidDate("01/01948/2004"));
		
	}
	
	
	
	
}
