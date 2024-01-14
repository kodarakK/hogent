package testen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Gebruiker;

class GebruikerTest
{
	/*
	 * de gebruikersnaam moet minstens 6 tekens bevatten
	 * de gebruikersnaam moet minstens 1 punt bevatten
	 * de gebruikersnaam mag niet beginnnen of eindigen met een punt
	 * de gebruikersnaam mag geen spaties bevatten
	 */
	
	/*
	 * testen die slagen
	 */
	
	@ParameterizedTest
	@ValueSource(strings = {"Hallo.goed",
							"Een.langere_test_met-meedere.tekens",
							"go.ed?",
							"Dit.zijn.meerdere.zonder.spaties",
							"nog.een-kleintje",
							"E.en-goede",
							"Nog-een-goed.e"})
	void maakGebruiker_minstens6Tekens_maaktGebruiker(String naam) {
		assertEquals(naam, new Gebruiker(naam).getGebruikersnaam());
	}
	
	/*
	 * slechte waarden
	 */
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"  ",
							"s.s",
							"s.ech",
							"slecht",
							".slecht",
							"slecht.",
							"Deze heeft spa.ties"})
	void maakGebruiker_slechteWaardenGeven_werptException(String naam) {
		assertThrows(IllegalArgumentException.class, 
				() -> new Gebruiker(naam));
	}
}
