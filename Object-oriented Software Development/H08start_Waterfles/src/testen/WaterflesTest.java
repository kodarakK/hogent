package testen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Waterfles;

class WaterflesTest
{
	
	private static final int MIN_CAPACITEIT = 100;
	private static final int MAX_CAPACITEIT	= 2000;
	
	private static final int CAPACITEIT = 250;	
	private Waterfles wf;

	@BeforeEach
	void before() {
		wf = new Waterfles(CAPACITEIT);
	}
	
//	geldige constuctors
//	[100, 2000] => grenzen en willekeurig tussen de grenzen(finalsl)
//	gelidige EP: 250
//	grenzen: 100 en 2000 (const)
	
	@ParameterizedTest
	@ValueSource(ints = {MIN_CAPACITEIT, 250, 500, 750, MAX_CAPACITEIT})
	void maakWaterfles_GrenzenGeldigEnWillekeurig_maaktWaterfles(int cap) {
		Waterfles wf = new Waterfles(cap);
		assertEquals(cap, wf.getCapaciteit());
		assertEquals(0,  wf.getInhoud());
	}
	
//	ongeldige constructors
//	gelidige EP: < 100 en > 2000
//	grenzen: 99 en 2001 => MIN-1, MAX+1
	
	@ParameterizedTest
	@ValueSource(ints = {50, MIN_CAPACITEIT - 1, MAX_CAPACITEIT + 1, 2500})
	void maakWaterfles_NetNietGrenzenEnErbuiten_WerptException(int cap) {
		assertThrows(IllegalArgumentException.class, () -> new Waterfles(cap));
	}
	
	/* 
	 * gedrag vulBij:
	 * 	Afspraak we starten telkens met een waterfles met capaciteit 250
	 * 
	 * EP: willekeurig
	 * 	start: Opvullen met 50 en opvullen 100
	 * 	? inhoud 150 (aE)
	 *  
	 *  grens
	 *  start: opvullen met 50 en 200
	 *  inhoud 250
	 *  
	 *  
	 *  grens
	 *  start: opvullen met 50
	 *  grens: opvullen met het minimum 1
	 *  inhoud: 51?
	 */
	
	@Test
	void vulBij_Vul150Bij_vultBij() {
		wf.vulBij(100);
		wf.vulBij(50);
		assertEquals(150, wf.getInhoud());
	}
	
	@Test
	void vulBij_Vul250Bij_vultBij() {
		wf.vulBij(50);
		wf.vulBij(200);
		assertEquals(250, wf.getInhoud());
	}
	
	@Test
	void vulBij_Vul50EnMin_vultBij() {
		wf.vulBij(50);
		wf.vulBij(1);
		assertEquals(51, wf.getInhoud());
	}
	
	/*
	 * @ParameterizedTest
	 * waterfles doen overlopen
	 * start 50
	 * willekeurig vb. 3000 EN net: 201
	 * cap 250? 
	 */
	
	@ParameterizedTest
	@ValueSource(ints = {3000, 201})
	void vulBij_OverlopenVeelTeVeelEnNetTeVeel_vulBijOp250(int teVullen) {
		wf.vulBij(50);
		wf.vulBij(teVullen);
		assertEquals(250, wf.getInhoud());
	} 
	
	/*
	 * @PAram
	 * vulBij: exception bij willekeurig: neg en grens: 0
	 */
	
	@ParameterizedTest
	@ValueSource(ints = {-500, 0})
	void vulBij_NegEnGrens_WerptException(int teVullen) {
		assertThrows(IllegalArgumentException.class, () -> wf.vulBij(teVullen));
	}
}
