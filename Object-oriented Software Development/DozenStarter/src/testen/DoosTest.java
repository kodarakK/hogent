package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Doos;

@TestMethodOrder(OrderAnnotation.class)
public class DoosTest {
	private final static String DEFAULT_KLEUR = "rood";
	private final static double DEFAULT_RIBBE = 1.0;

	@Test
	public void maakDoos_geldigeAfmetingenEnKleur_maaktDoosMetOpgegevenAfmetingenEnKleur() {
		Doos doos = new Doos(1, 2, 3, "groen");
		Assertions.assertEquals(1, doos.getLengte());
		Assertions.assertEquals(2, doos.getBreedte());
		Assertions.assertEquals(3, doos.getHoogte());
		Assertions.assertEquals("groen", doos.getKleur());
	}

	@Test
	public void maakDoos_geenAfmetingenEnKleur_maaktDoosMetDefaultdAfmetingenEnKleur() {
		Doos doos = new Doos();
		Assertions.assertEquals(DEFAULT_RIBBE, doos.getLengte());
		Assertions.assertEquals(DEFAULT_RIBBE, doos.getBreedte());
		Assertions.assertEquals(DEFAULT_RIBBE, doos.getHoogte());
		Assertions.assertEquals(DEFAULT_KLEUR, doos.getKleur());
	}

	@Test
	public void maakDoos_geldigeAfmetingenEnGeenKleur_maaktDoosMetOpgegevenAfmetingenEnDefaultKleur() {
		Doos doos = new Doos(1, 2, 3);
		Assertions.assertEquals(1.0, doos.getLengte());
		Assertions.assertEquals(2.0, doos.getBreedte());
		Assertions.assertEquals(3.0, doos.getHoogte());
		Assertions.assertEquals(DEFAULT_KLEUR, doos.getKleur());
	}

	@Test
	public void maakDoos_geldigeKleurEnGeenAfmetingen_maaktDoosMetOpgegevenKleurEnDefaultAfmetingen() {
		Doos doos = new Doos("groen");
		Assertions.assertEquals(DEFAULT_RIBBE, doos.getLengte());
		Assertions.assertEquals(DEFAULT_RIBBE, doos.getBreedte());
		Assertions.assertEquals(DEFAULT_RIBBE, doos.getHoogte());
		Assertions.assertEquals("groen", doos.getKleur());
	}

	@ParameterizedTest
	@ValueSource(ints = { -100, -2, 0 })
	public void maakDoos_ongeldigeLengte_werptException(int lengte) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Doos(lengte, 1, 1);
		});
	}

	@ParameterizedTest
	@ValueSource(ints = { -100, -2, 0 })
	public void maakDoos_ongeldigeBreedte_werptException(int breedte) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Doos(1, breedte, 1);
		});

	}

	@ParameterizedTest
	@ValueSource(ints = { -100, -2, 0 })
	public void maakDoos_ongeldigeHoogte_werptException(int hoogte) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Doos(1, 1, hoogte);
		});

	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "   ", "\t\t" })
	public void maakDoos_ongeldigeKleur_werptException(String kleur) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Doos(1, 2, 3, kleur));
	}

	// De waarde van de static variabele aantalDozenGemaakt verhoogt telkens
	// er in een test-methode 1 of meerdere dozen worden gemaakt.
	// Via de @order kunnen we aangeven dat onderstaande testen steeds als
	// eerste twee testen moeten uitgevoerd worden.
	// Zo kunnen we exact bepalen welke waarde we verwachten in de
	// static variable aantalDozenGemaakt.
	@Order(1)
	@Test
	public void maakDoos_nieuweDoosGemaakt_verhoogtAantalDozenGemaakt() {
		Assertions.assertEquals(0, Doos.getAantalDozenGemaakt());
		new Doos(); // eerste doos
		Assertions.assertEquals(1, Doos.getAantalDozenGemaakt());
		new Doos(1, 2, 3, "groen"); // tweede doos
		new Doos("groen"); // derde doos
		new Doos(1, 2, 3); // vierde doos
		Assertions.assertEquals(4, Doos.getAantalDozenGemaakt());
	}

	@Order(2)
	@Test
	public void maakDoos_vijfdeDoos_maaktDoosMetCorrecteCode() {
		Doos d1 = new Doos(); // vijfde doos
		Assertions.assertEquals("D000000000000005", d1.getCode());
	}

}
