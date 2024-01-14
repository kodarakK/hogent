package testen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Resultatenlijst;

class ResultatenlijstTest {

	private Resultatenlijst rl;
	private final static int MIN_RESULTAAT = 0;
	private final static int MAX_RESULTAAT = 20;
	
	@BeforeEach
	void before() {
		rl = new Resultatenlijst();
	}

	//Een nieuwe Resultatenlijst bevat een lijst met 0 resultaten. namen mogen afgekort zijn op examen
	@Test
	void maakLijst_lijstMet0Resusltaten_maaktLijst() {
		assertTrue(rl.getResultaten().isEmpty());
	}
	
	//gedrag voegResultaatToe(resultaat : int) : void
		//een resultaat ligt in het interval [0, 20]
	//hulpmethode
	private void vulLijst(int[] resultaten) {
		//de elementen van "resultaten" worden toegevoegd (methode voegResultaatToe)
		//aan rl
		for (int res : resultaten)
		{
			rl.voegResultaatToe(res);
		}
	}
	
	//hulpmethode
	private int[] lijstNaarArray() //van List<Integer> naar int[]
	{
		return rl.getResultaten().stream().mapToInt(Integer::intValue).toArray();		
	}
	
	@ParameterizedTest
	@ValueSource(ints = { MIN_RESULTAAT, MAX_RESULTAAT, 10 })
	void voegResultaatToe_GeldigResultaatEnResultatenlijstNietVol_VoegtResultaatToe(int resultaat) {
		// vul de lijst op met new int[] { 2, 2, 3 }
		vulLijst(new int[] { 2, 2, 3 });
		
		//voeg resultaat toe aan de lijst
		rl.voegResultaatToe(resultaat);
		
		//? bestaat de lijst uit 4 elementen
		assertEquals(4, rl.getResultaten().size());
		
		//Is de lijst opgevuld met {2, 2, 3, resultaat}? :
		assertArrayEquals(new int[] { 2, 2, 3, resultaat}, lijstNaarArray());	
	}

	//een resultatenlijst kan niet meer dan 5 resultaten bevatten
	@Test
	void voegResultaatToe_limietOpsporen_vindLimiet() {
		// startitutatie met 4 getallen
		// 5de eln toevoegen
		vulLijst(new int[] { 2, 2, 3, 4 });
		rl.voegResultaatToe(10);
		
		// ?5
		assertEquals(5, rl.getResultaten().size());
		
		//?array
		assertArrayEquals(new int[] { 2, 2, 3, 4 , 10}, lijstNaarArray());	
	}
	
	@Test
	void voegResultaatToe_TeVol_ViegtResultaatToe() {
		// startsit 5 getallen
		vulLijst(new int[] { 2, 2, 3, 4, 5 });
		
		// 6de getal -> IAE
		assertThrows(IllegalArgumentException.class, 
				() -> rl.voegResultaatToe(6));
	}
	
	@ParameterizedTest
	@ValueSource(ints = { MIN_RESULTAAT-1 , MAX_RESULTAAT + 1, -20, 30})
	void voegResultaat_slechteWaarden_we(int res) {
		assertThrows(IllegalArgumentException.class, () -> rl.voegResultaatToe(res));
	}
	
	//gedrag geefGemiddelde() : double
		//het gemiddelde is tot op 3 decimalen na de komma correct
		//indien er geen resultaten zijn kan het gemiddelde niet berekend worden
	
	//5  4  10   15  13   => 9.4
	@Test
	void geefGemiddelde_bereknGemid_berektkGem() {
		vulLijst(new int[] {5, 4, 10, 15, 13});
		assertEquals(9.4, rl.geefGemiddelde());
	}
	//2  2  3    => 2.3333333333333  => 2.333 (afwijking voorzien)
	@Test
	void geefGemiddelde_bereknGemid2_berektkGem() {
		vulLijst(new int[] {2, 2, 3});
		assertEquals(2.333, rl.geefGemiddelde(), 0.001);
	}
	//grenzen
	@Test
	void gem_1get_voegLijst() {
		vulLijst(new int[] {1});
		assertEquals(1, rl.geefGemiddelde());
	}
	
	//lijst max ingevuld met dezeflde getallen
	@Test
	void gem_maxIngevuldDezelfdeGet_IDK() {
		vulLijst(new int[] {10, 10, 10, 10, 10});
		
		assertEquals(10, rl.geefGemiddelde());
	}
	
	// lijst met een paar nulllen
	@Test
	void gem_0_doeothet() {
		vulLijst(new int[] {0, 0, 0, 0, 0});
		
		assertEquals(0, rl.geefGemiddelde());
	}
	
	//lijst leeg IAE
	@Test
	void lijst_leeg_we() {
		assertThrows(IllegalArgumentException.class, 
				() -> rl.geefGemiddelde());
	}
}
