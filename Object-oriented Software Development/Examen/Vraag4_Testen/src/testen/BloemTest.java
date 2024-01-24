package testen;

import domein.Bloem;
import static utils.Kleur.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;

class BloemTest
{
	
	// naam:
	// null, "  ", "h", "5q"
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"   ", "h", "5qq hite"})
	void maakBloem_grenzenEnWillekeurig_werptException(String naam)
	{
		assertThrows(IllegalArgumentException.class, () -> new Bloem(naam, WIT));
	}
	// naam:
	// "li", "lily", "l  ily", ""
	
	@ParameterizedTest
	@ValueSource(strings = {})
	void maakBloem_grenzenEnWillekeurig_maaktBloem(String naam) 
	{
		Bloem bloem = new Bloem(naam, GEEL);
		assertEquals(naam, bloem.getNaam());
	}

	// kleur:
	// null
	@Test
	void maakBloem_KleurIsNull_werptException()
	{
		assertThrows(IllegalArgumentException.class, () -> new Bloem("lily of the valey", null));
	}

	// kleur: 
	// "ROOD", "GEEL", "WIT"
	@Test
	void maakBloem_KleurIsGeldigWIT_maaktBloem()
	{
		Bloem bloem = new Bloem("lily", WIT);
		assertEquals(WIT, bloem.getKleur());
	}
	
	@Test
	void maakBloem_KleurIsGeldigGEEL_maaktBloem()
	{
		Bloem bloem = new Bloem("lily", GEEL);
		assertEquals(GEEL, bloem.getKleur());
	}
	
	@Test
	void maakBloem_KleurIsGeldigROOD_maaktBloem()
	{
		Bloem bloem = new Bloem("lily", ROOD);
		assertEquals(ROOD, bloem.getKleur());
	}
	
	@Test
	void bloeitInLente_WIT_geeftTrue()
	{
		Bloem bloem = new Bloem("lily", WIT);
		assertTrue(bloem.bloeitInLente());
	}
	
	@Test
	void bloeitInLente_GEEL_geeftTrue()
	{
		Bloem bloem = new Bloem("lily", GEEL);
		assertTrue(bloem.bloeitInLente());
	}
	
	@Test
	void bloeitInLente_ROOD_geeftFalse()
	{
		Bloem bloem = new Bloem("lily", ROOD);
		assertFalse(bloem.bloeitInLente());
	}
	
	@Test
	void bloeitInLente_MEERKLEURIG_geeftFalse()
	{
		Bloem bloem = new Bloem("lily", MEERKLEURIG);
		assertFalse(bloem.bloeitInLente());
	}
}
