package testen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Lift;

class LiftTest
{
	private static final int HOOGSTE_VERD = 20;
	private static final int LAAGSTE_VERD = -5;
	
	private Lift lift;
	@Before
	void before() {
		lift = new Lift(LAAGSTE_VERD, HOOGSTE_VERD);
	}
	
	/*
	 * grenzen + fouten
	 */
	
	@ParameterizedTest
	@ValueSource(ints = {0, -1, -2, -3, -4, -5})
	void maakLift_GrensEnFouteWaarden_werptException(int verdiep) {
		assertThrows(IllegalArgumentException.class,
				() -> lift.gaNaarOmhoog(verdiep));
	}
	
	/*
	 * alles goed
	 */
	
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5})
	void maaktLift_gaatOmhoog_gaatOmhoog(int verdiep) {
		lift.gaNaarOmhoog(verdiep);
		assertEquals(verdiep, lift.getVerdieping());
	}
	
	/*
	 * gewone test
	 */
	
	@Test
	void maakLift_gaatOmhoogGrens_gaatOmhoog() {
		lift.gaNaarOmhoog(10);
		lift.gaNaarOmhoog(1);
		assertEquals(11, lift.getVerdieping());
	}
	
	@Test
	void maakLift_gaatOmhoog_gaatOmhoog() {
		lift.gaNaarOmhoog(10);
		lift.gaNaarOmhoog(5);
		assertEquals(15, lift.getVerdieping());
	}
	
	/*
	 * plafoneerings test
	 */
	
	@ParameterizedTest
	@ValueSource(ints = {10, 20, 11, 1000})
	void maakLift_plafoneer_plafoneert(int verdiep) {
		lift.gaNaarOmhoog(10);
		lift.gaNaarOmhoog(verdiep);
		assertEquals(HOOGSTE_VERD, lift.getVerdieping());
	}
}
