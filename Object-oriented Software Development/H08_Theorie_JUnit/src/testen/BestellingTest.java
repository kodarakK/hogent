package testen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Bestelling;

class BestellingTest {

/*
een goede naam voor een test methode bestaat uit 3 delen
       1. de naam van de methode die zal getest worden
             voor een constructor kiezen we “maak” gevolgd door de naam van de constructor
       2. een omschrijving van de test case
       3. een omschrijving van het verwachte resultaat van de test
*/

//Equivalentiepartities (EP)
	/*
	 Een geldige EP is een EP waarvoor je een normaal gedrag
	 van een methode verwacht.

     Een ongeldige EP is een EP waarvoor je geen normaal gedrag
     van een methode verwacht, dit betekent dat de methode
     een exception zal werpen.
	 */
	
//Boundary Values (BV)
// Een boundary value is een waarde die zich aan de grens van 
// een equivalentie partitie bevindt.

//Constructor testen
//Geldige EP: 5
//Ongeldige EPs: -5 en 20

//BV: geldige EP: 1 en 10
//BV: ongeldige EPs: 0 en 11
	
	@ParameterizedTest
//	1 argument, primitieve datatypen (int, double, char, long, String)
	@ValueSource(ints = {5, 1, 10})
//	int ==> itns , double , ==> double, longs, chars, strings
	void maakBestelling_GeldigAantal_MaakBestelling(int aantal)
	{
		assertEquals(aantal, new Bestelling(aantal).getAantal());
	}
	
	@Test
	void maakBestelling_GeldigAantal_MaakBestelling() {
		// arange
		Bestelling bestelling = new Bestelling(5);
		// act && assert
		
		// assert             act
		assertEquals(5, bestelling.getAantal());
		
		/*
		 * a = b dan is b = a?
		 */
		// assertEquals(bestelling.getAantal(), 5); NIET!!!
		/*
		 * 1ste argument: ALTIJD verwachte resultaat
		 * 2de arg.: afkomstig van ons programma
		 * waarom?
		 * junit maakt de foutboodschap indien ze niet gelijk zijn
		 * verwacht 5 maar was 10
		 * 
		 * 
		 * RAAR 
		 * ik verwacht 10 maar was 5
		 */
		

		
		
		// static methoden
		// klasse Assertions
		// Assertions.assertEquals();
		
		/*
		 * import static ... door de static
		 * import kunnen we de naam van de methode zonder de klasse te vermelden
		 * oproepen
		 * 
		 * Assertions.
		 * Ctrl + spatie balk en dan zien we  alle methoden van de klasse 
		 * Assertions (weer door de static import)
		 */
		
	}
	/*
	@Test
	void maakBestelling_KleinstToegelatenAantal_MaakBestelling() {
		Bestelling bestelling = new Bestelling(1);
		assertEquals(1, bestelling.getAantal());
	}
	
	@Test
	void maakBestelling_GrootstToegelatenAantal_MaakBestelling() {
		Bestelling bestelling = new Bestelling(10);
		assertEquals(10, bestelling.getAantal());
	}
	*/
	@ParameterizedTest
	@ValueSource(ints = {-5,20,0,11})
	void maakBestelling_OngeldigeWaarden(int aantal)
	{
		assertThrows(IllegalArgumentException.class, 
				() -> new Bestelling(aantal));
	}
	/*
	@Test
	void maakBestelling_AantalTeKlein_WerptException() {
		assertThrows(IllegalArgumentException.class, 
				() -> new Bestelling(-5));
	}
	
	@Test
	void maakBestelling_AantalTeGroot_WerptException() {
		assertThrows(IllegalArgumentException.class, 
				() -> new Bestelling(20));
	}
	
	@Test
	void maakBestelling_AantalNetTeKlein_WerptException() {
		assertThrows(IllegalArgumentException.class, 
				() -> new Bestelling(0));
	}
	
	@Test
	void maakBestelling_AantalNetTeGroot_WerptException() {
		assertThrows(IllegalArgumentException.class, 
				() -> new Bestelling(11));
	}
	*/
	//enkel bestellingen van 5 of meer pizza’s geven recht op korting
    //geldig EP (false): 2
	//BV (false): 4
	//geldig EP (true): 7
	//BV (true): 5
	/*
	@Test
	void geeftRechtOpKorting_BestellingMetRechtOpKorting_RetourneertTrue() {
		Bestelling bestelling = new Bestelling(7);
		assertTrue(bestelling.geeftRechtOpKorting());
	}
	
	@Test
	void geeftRechtOpKorting_BestellingNetGrootGenoegVoorRechtOpKorting_RetourneertTrue() {
		Bestelling bestelling = new Bestelling(5);
		assertTrue(bestelling.geeftRechtOpKorting());
	}
	*/

	@ParameterizedTest
	@ValueSource(ints = {7,5})
	void geeftRechtOpKorting_BestellingMetRechtOpKorting_RetourneertTrue(int aantal)
	{
		Bestelling bestelling = new Bestelling(7);
		assertTrue(bestelling.geeftRechtOpKorting());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2, 4})
	void geefRechtOpKorting_BestellingNetNietGrootEnGeenRechtOpKorting_RetourneertFalse(int aantal) {
		Bestelling bestelling = new Bestelling(aantal);
		assertFalse(bestelling.geeftRechtOpKorting());
	}
	/*
	@Test
	void geeftRechtOpKorting_BestellingZonderRechtOpKorting_RetourneertFalse() {
		Bestelling bestelling = new Bestelling(2);
		assertFalse(bestelling.geeftRechtOpKorting());
	}
	
	@Test
	void geeftRechtOpKorting_BestellingNetNietGrootGenoegVoorRechtOpKorting_RetourneertFalse() {
		Bestelling bestelling = new Bestelling(4);
		assertFalse(bestelling.geeftRechtOpKorting());
	}
	*/

}
