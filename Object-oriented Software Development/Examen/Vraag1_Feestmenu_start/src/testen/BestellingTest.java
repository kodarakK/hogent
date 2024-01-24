package testen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Bestelling;
import domein.Gerecht;
import utils.Gang;

class BestellingTest
{
	private static final String GELDIGE_NAAM = "Janssens Guido";
	private static final int GELDIG_AANTAL_PERSONEN = 4;
	private static final String GELDIGE_NAAM_KOUD_VOORGERECHT = Gang.KOUD_VOORGERECHT.getGerechtnamen()[1];
	private static final Gerecht GELDIG_KOUD_VOORGERECHT = new Gerecht(GELDIGE_NAAM_KOUD_VOORGERECHT, Gang.KOUD_VOORGERECHT);
	private static final String GELDIGE_NAAM_WARM_VOORGERECHT = Gang.WARM_VOORGERECHT.getGerechtnamen()[0];
	private static final Gerecht GELDIG_WARM_VOORGERECHT = new Gerecht(GELDIGE_NAAM_WARM_VOORGERECHT, Gang.WARM_VOORGERECHT);
	private static final String GELDIGE_NAAM_HOOFDGERECHT = Gang.HOOFDGERECHT.getGerechtnamen()[2];
	private static final Gerecht GELDIG_HOOFDGERECHT = new Gerecht(GELDIGE_NAAM_HOOFDGERECHT, Gang.HOOFDGERECHT);
	private static final String GELDIGE_NAAM_DESSERT = Gang.DESSERT.getGerechtnamen()[1];
	private static final Gerecht GELDIG_DESSERT = new Gerecht(GELDIGE_NAAM_DESSERT, Gang.DESSERT);
	private static final String[] GELDIGE_GERECHTNAMEN_4GANGEN = {GELDIGE_NAAM_KOUD_VOORGERECHT, GELDIGE_NAAM_WARM_VOORGERECHT, 
																  GELDIGE_NAAM_HOOFDGERECHT, GELDIGE_NAAM_DESSERT};	
	private static final Gerecht[] GELDIGE_GERECHTEN_4GANGEN = {GELDIG_KOUD_VOORGERECHT, GELDIG_WARM_VOORGERECHT, GELDIG_HOOFDGERECHT, GELDIG_DESSERT};
	private static final String[] GELDIGE_GERECHTNAMEN_3GANGEN = {GELDIGE_NAAM_KOUD_VOORGERECHT, GELDIGE_NAAM_HOOFDGERECHT, GELDIGE_NAAM_DESSERT};	
	private static final Gerecht[] GELDIGE_GERECHTEN_3GANGEN = {GELDIG_KOUD_VOORGERECHT, GELDIG_HOOFDGERECHT, GELDIG_DESSERT};
	
	private Bestelling b;
	
	@BeforeEach
	void setUp()
	{
		b = new Bestelling(GELDIGE_NAAM, GELDIG_AANTAL_PERSONEN, GELDIGE_GERECHTNAMEN_4GANGEN);
	}
	
	private void assertGerechten(Gerecht[] verwacht, Gerecht[] eigenlijk)
	{
		for (int i=0; i<verwacht.length; i++)
		{
			assertEquals(verwacht[i].getNaam(), eigenlijk[i].getNaam());
			assertEquals(verwacht[i].getGang(), eigenlijk[i].getGang());
		}
	}
	
	@Test
	void maakBestelling_alleParametersOK4gangen_maaktBestelling()
	{
		assertEquals(GELDIGE_NAAM, b.getNaam());
		assertEquals(GELDIG_AANTAL_PERSONEN, b.getAantalPersonen());
		assertGerechten(GELDIGE_GERECHTEN_4GANGEN, b.getKeuzeGerechten());
	}
	
	@Test
	void maakBestelling_alleParametersOK3gangen_maaktBestelling()
	{
		b = new Bestelling(GELDIGE_NAAM, GELDIG_AANTAL_PERSONEN, GELDIGE_GERECHTNAMEN_3GANGEN);
		assertEquals(GELDIGE_NAAM, b.getNaam());
		assertEquals(GELDIG_AANTAL_PERSONEN, b.getAantalPersonen());
		assertGerechten(GELDIGE_GERECHTEN_3GANGEN, b.getKeuzeGerechten());
	}
	
	@Test
	void maakBestelling_alleParametersOKLengteNaamRandgeval_maaktBestelling()
	{
		b = new Bestelling("Abcde", GELDIG_AANTAL_PERSONEN, GELDIGE_GERECHTNAMEN_4GANGEN);
		assertEquals("Abcde", b.getNaam());
		assertEquals(GELDIG_AANTAL_PERSONEN, b.getAantalPersonen());
		assertGerechten(GELDIGE_GERECHTEN_4GANGEN, b.getKeuzeGerechten());
	}
	
	@Test
	void maakBestelling_alleParametersOKAantalPersonenRandgeval_maaktBestelling()
	{
		b = new Bestelling(GELDIGE_NAAM, 2, GELDIGE_GERECHTNAMEN_4GANGEN);
		assertEquals(GELDIGE_NAAM, b.getNaam());
		assertEquals(2, b.getAantalPersonen());
		assertGerechten(GELDIGE_GERECHTEN_4GANGEN, b.getKeuzeGerechten());
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource (strings = {" ", "  \t   \n\t   ", "a", "A Bc"})
	void maakBestelling_ongeldigeNaam_gooitException(String naam)
	{
		assertThrows (IllegalArgumentException.class, () -> new Bestelling(naam, GELDIG_AANTAL_PERSONEN, GELDIGE_GERECHTNAMEN_4GANGEN));
	}
	
	@ParameterizedTest
	@ValueSource (ints = {1, -5})
	void maakBestelling_ongeldigAantalPersonen_gooitException(int aantalPersonen)
	{
		assertThrows (IllegalArgumentException.class, () -> new Bestelling(GELDIGE_NAAM, aantalPersonen, GELDIGE_GERECHTNAMEN_4GANGEN));
	}
	
	@Test
	void maakBestelling_keuzesIsNull_gooitException()
	{
		assertThrows (IllegalArgumentException.class, () -> new Bestelling(GELDIGE_NAAM, GELDIG_AANTAL_PERSONEN, null));
	}

	@ParameterizedTest
	@ValueSource (ints = {1, 2, 5, 10})
	void maakBestelling_ongeldigAantalGangen_gooitException(int aantalGangen)
	{
		assertThrows (IllegalArgumentException.class, () -> new Bestelling(GELDIGE_NAAM, GELDIG_AANTAL_PERSONEN, new String[aantalGangen]));
	}	
	
	@Test
	void maakBestelling_gangBevatVerkeerdeKeuze_gooitException()
	{
		String[] keuzes = {GELDIGE_NAAM_WARM_VOORGERECHT, GELDIGE_NAAM_HOOFDGERECHT, GELDIGE_NAAM_DESSERT};
		assertThrows (IllegalArgumentException.class, () -> new Bestelling(GELDIGE_NAAM, GELDIG_AANTAL_PERSONEN, keuzes));
	}
	
	@Test
	void maakBestelling_meerdereGangenBevattenVerkeerdeKeuze_gooitException()
	{
		String[] keuzes = {GELDIGE_NAAM_KOUD_VOORGERECHT, GELDIGE_NAAM_WARM_VOORGERECHT, GELDIGE_NAAM_DESSERT, GELDIGE_NAAM_HOOFDGERECHT};
		assertThrows (IllegalArgumentException.class, () -> new Bestelling(GELDIGE_NAAM, GELDIG_AANTAL_PERSONEN, keuzes));
	}
	
	@Test
	void geefGerechtnamen_returntDeNamenVanDeGerechten()
	{
		assertArrayEquals(GELDIGE_GERECHTNAMEN_4GANGEN, b.geefGerechtnamen().toArray(new String[0]));
	}
	
	@Test
	void geefAantalPersonenVoorGerecht_bestellingVoor4personen_gerechtnaamKomtVoor_returnt4()
	{
		assertEquals(4, b.geefAantalPersonenVoorGerecht(GELDIGE_NAAM_HOOFDGERECHT));
	}
	
	@Test
	void geefAantalPersonenVoorGerecht_bestellingVoor4personen_gerechtnaamKomtNietVoor_returnt0()
	{
		assertEquals(0, b.geefAantalPersonenVoorGerecht(Gang.DESSERT.getGerechtnamen()[0]));
	}	
}