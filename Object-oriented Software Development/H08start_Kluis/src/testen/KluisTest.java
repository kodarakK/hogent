package testen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Kluis;

class KluisTest {
	
	private static final String GELDIGE_CODE = "1286";
	
	private Kluis kluis;
	
	@BeforeEach
	void before() {
		kluis = new Kluis(GELDIGE_CODE);
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"  ", "1", "123", "1234567", "12345", "12A3", "3333"})
	void maakKluis_OngeldigeCode_WerptException(String code) {
		assertThrows(IllegalArgumentException.class, 
				() -> new Kluis(code)
				);
	}
	
/*
	@Test
	void maakKluis_GeenCode_WerptException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Kluis(null));		
	}
	
	@Test
	void maakKluis_CodeLegeString_WerptException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Kluis(""));		
	}
	
	@Test
	void maakKluis_MetSpaties_WerptException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Kluis("   "));		
	}
	
	@Test
	void maakKluis_CodeIsTeKort_WerptException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Kluis("1"));		
	}
	
	@Test
	void maakKluis_CodeNetTeKort_WerptException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Kluis("123"));		
	}
	
	@Test
	void maakKluis_CodeIsTeLang_WerptException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Kluis("123456789"));		
	}
	
	@Test
	void maakKluis_CodeIsNetTeLang_WerptException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Kluis("12345"));		
	}

	@Test
	void maakKluis_CodeBevatEenTekenDatGeenCijferIs_WerptException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Kluis("I234"));		
	}
	
	@Test
	void maakKluis_CodeMetVierDezelfdeCijfers_WerptException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Kluis("1111"));		
	}
*/
	/*
	 * Kluis kluis = new Kluis(geldigeCode);
	 * assertEquals(gelidgeCode, kluis.code());
	 * Uitzondering: getcode mag niet voorzien worden anders
	 * kent iedreen de code om de kluis te openen
	 * Normaal geval: waarden van de attributen controleren dmv getters

	 *
	 */
	
	@ParameterizedTest
	@ValueSource(strings = {"1234", "1112"})
	void maakKluis_CodeGeldif_MaaktKluis(String code) {
		assertDoesNotThrow(() -> new Kluis(code));
	}
/*
	@Test
	void maakKluis_CodeBestaatUitCijfers_WerptException() {
		assertDoesNotThrow(() -> new Kluis("1234"));		
	}
	
	 @Test // GRENS
	void maakKluis_CodeBestaatUitNetGeen4GelijkeCijfers_WerptException() {
		assertDoesNotThrow(() -> new Kluis("1112"));		
	}*/

	@Test
	void valideer_CodesKomenOvereen_RetourneerdTrue() {
//		String gelidgeCode = "1286";
//		Kluis kluis = new Kluis(gelidgeCode);
		assertTrue(kluis.valideerCode(GELDIGE_CODE));
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"1222", "1234", "  "})
	void valideer_CodesKomenNietOvereen_RetourneertFalse(String code) {
//		Kluis Kluis = new Kluis("1234");
		assertFalse(kluis.valideerCode(code));
	}
/*
	@Test
	void valideer_CodesKomenNietOvereen_RetourneerdFalse() {
		Kluis kluis = new Kluis("1286");
		assertFalse(kluis.valideerCode("1234"));
	}

	@Test
	void valideer_CodesNull_RetourneerdFalse() {
		Kluis kluis = new Kluis("1286");
		assertFalse(kluis.valideerCode(null));
	}

	@Test
	void valideer_CodeLegeString_RetourneerdFalse() {
		Kluis kluis = new Kluis("1286");
		assertFalse(kluis.valideerCode(""));
	}

	@Test
	void valideer_CodeSpaties_RetourneerdFalse() {
		Kluis kluis = new Kluis("1286");
		assertFalse(kluis.valideerCode("   "));
	}
*/
	
}