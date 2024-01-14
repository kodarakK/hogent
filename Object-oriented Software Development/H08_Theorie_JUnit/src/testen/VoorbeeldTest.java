package testen;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/*
 * geen public
 * Testklassen zijn enkel gekend in de package zelf 
 */

class VoorbeeldTest
{
   /*
	* alle methoden met @Test zal JUnit uitvoeren
	* methode met @Test is ATLIJD VOID methode
	* ALTIJD methode met 0 argumenten
	*/
	
/*
	@Test
	// geen public
	void test()
	{
		fail("Not yet implemented");
	}
	
	@Test
	void test2() {
		fail("not yes implemented");
	}
	
	/*
	 * Welke volgorde worden de testenmethoden opgroepen? / JUnit kiest zelf => willekeurig
	 * testmethoden mogen Niet afhangen van elkaar!
	 * testmethode test 1 iets uit
	 */

}
