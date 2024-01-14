package testen;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Categorie;
import domein.Snack;
import static domein.Categorie.*;

class SnackTest {

	//Domeinregels nieuwe snack
		//de naam van een snack moet ingevuld zijn en 
		//mag niet uit enkel en alleen spaties bestaan

		//de categorie van een snack moet ingevuld zijn
	
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"  "})
	void maakSnack_OngeldigeNaam_WerptException(String naam)
	{
		assertThrows(IllegalArgumentException.class, () -> new Snack(naam, SNOEP));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"abc", "a bc", "  a"})
	void maakSnack_GeldigeNaam_mS(String naam)
	{
		// creatie Object
		Snack sn = new Snack(naam, FRUIT);
		
		// ALLE attributen controleren: naam en categorie
		assertEquals(naam, sn.getNaam());
		assertEquals(FRUIT, sn.getCategorie());
	}
	
	@Test
	void maaksnakc_nullInCat_we() {
		assertThrows(IllegalArgumentException.class, () -> new Snack("naam", null));	
	}
//	OF
	@ParameterizedTest
	@NullSource
	void maaksnakc_nullInCat_we2(Categorie cat) {
		assertThrows(IllegalArgumentException.class, () -> new Snack("naam", cat));	
	}
	
	//Gedrag isGezond
	    //snacks van de categorieën fruit en groente zijn gezond, andere niet
	
	@Test
	void isGezond_FRUITENGROETNE_true() {
		assertTrue(new Snack("naam", FRUIT).isGezond());
		assertTrue(new Snack("naam", GROENTE).isGezond());
		
	}
	
	@Test
	void isGezond_nietGzzond_false()
	{
		assertFalse(new Snack("naam", SNOEP).isGezond());
	}
}
