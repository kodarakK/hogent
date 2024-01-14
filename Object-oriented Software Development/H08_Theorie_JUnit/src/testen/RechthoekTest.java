package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Rechthoek;

class RechthoekTest {

	private Rechthoek r;
	
	private static final int MIN_PERCENTAGE = 1;
	private static final int MAX_PERCENTAGE = 200;

	@BeforeEach
	void before() {
		r = new Rechthoek(10,5);
	}
	
//	2 argumenten nodig, 1TI: copy&paste, leerstof 2de jaar
	@Test
	void maakRechthoek_LengteEnBreedtePositief_MaaktRechthoek() {
//		Rechthoek r = new Rechthoek(10,5);
		assertEquals(10, r.getLengte());
		assertEquals(5, r.getBreedte());
	}

	@Test
	void maakRechthoek_LengteNetGroterDanNul_MaaktRechthoek() {
		Rechthoek r = new Rechthoek(Double.MIN_VALUE, 10);
		assertEquals(Double.MIN_VALUE, r.getLengte());
		assertEquals(10, r.getBreedte());
		
//		assertEquals om ene diecimaal te vegelijken bestaat ook met 3 argumenten
//		3de arg: toegelaten afwijking
		assertEquals(10, r.getBreedte(), 0.1);
	}

	@Test
	void maakRechthoek_BreedteNetGroterDanNul_MaaktRechthoek() {
		Rechthoek r = new Rechthoek(10, Double.MIN_VALUE);
		assertEquals(10, r.getLengte());
		assertEquals(Double.MIN_VALUE, r.getBreedte());
	}

	@ParameterizedTest
	@ValueSource(doubles = { 0, -10 })
	void maakRechthoek_LengteNietStriktPositief_WerptException(double lengte) {
		assertThrows(IllegalArgumentException.class, () -> new Rechthoek(lengte, 5));
	}

	@ParameterizedTest
	@ValueSource(doubles = { 0, -10 })
	void maakRechthoek_BreedteNietStriktPositief_WerptException(double breedte) {
		assertThrows(IllegalArgumentException.class, () -> new Rechthoek(10, breedte));
	}

	@Test
	void geefOmtrek_RetourneertDeOmtrek() {
//		Rechthoek r = new Rechthoek(10,5);
		assertEquals(30, r.geefOmtrek());
	}

	
	
	@Test
	void geefOppervlakte_RetourneertDeOppervlakte() {
//		Rechthoek r = new Rechthoek(10,5);
//		NOOIT berekeningen als verwachte resultaat schrijven
//		assertEquals(10*5, r.geefOppenvlakte());		
		
//		ALTIJD het eindresultaat als verwachte resultaat schrijven
		assertEquals(50, r.geefOppervlakte());
	}

	@Test
	void schaal_GeldigPrecentage_SchaaltDeRechthoek() {
//		Rechthoek r = new Rechthoek(10,5);
		r.schaal(50);
		assertEquals(5, r.getLengte());
		assertEquals(2.5, r.getBreedte());
	}

	@Test
	void schaal_PercentageGrootstMogelijk_SchaaltDeRechthoek() {
//		Rechthoek r = new Rechthoek(10,5);
		r.schaal(MAX_PERCENTAGE);
//		assertEquals(20, r.getLengte());
//		assertEquals(10, r.getBreedte());
		
		controleLengteBreedte(20, 10);
	}

//	hulpmehtoden mogen geschrven in tesklasse
//	junit roep enkle de methoden op met @
	private void controleLengteBreedte(double lengte, double breedte) {
		assertEquals(lengte, r.getLengte());
		assertEquals(breedte, r.getBreedte());
	}
	
	@Test
	void schaal_PercentageKleinstMogelijk_SchaaltDeRechthoek() {
//		Rechthoek r = new Rechthoek(10,5);
		r.schaal(MIN_PERCENTAGE);
		assertEquals(0.1, r.getLengte(), 0.01); // 0.1 - 0.01 - 
		assertEquals(0.05, r.getBreedte(), 0.01);
	}

	@ParameterizedTest
	@ValueSource(ints = { 0, -10, 201, 210 })
	void schaal_OngeldigSchalingsPercentage_WerptException(int percentage) {
//		Rechthoek r = new Rechthoek(10,5);
		assertThrows(IllegalArgumentException.class, () -> r.schaal(percentage));
	}
}
