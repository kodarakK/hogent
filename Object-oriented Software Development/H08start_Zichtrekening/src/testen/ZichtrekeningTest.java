package testen;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Zichtrekening;

class ZichtrekeningTest
{
	private static final double KLEINSTE_GRENS = 0.05;
	
	private Zichtrekening zr;
	@BeforeEach
	void before() {
		zr = new Zichtrekening();
	}
	
	/*
	 * leeg testen
	 */
	
	@Test
	void maakZichtrekening_EersteSaldoTestenOp0_maaktZichtrekening() {
		assertEquals(BigDecimal.ZERO, zr.getSaldo());
	}
	
	/* 
	 * willekeurig storten
	 */
	
	@Test
	void maakZichtrekening_2keerStorten_stortSaldo() {
		zr.stort(BigDecimal.valueOf(10));
		zr.stort(BigDecimal.valueOf(20));
		
		assertEquals(BigDecimal.valueOf(30), zr.getSaldo());
	}
	
	/*
	 * grens storten
	 */
	
	@Test
	void maakZichtrekening_grenzenTesten_maaktZichtrekening() {
		zr.stort(BigDecimal.valueOf(22.5));
		zr.stort(BigDecimal.valueOf(KLEINSTE_GRENS));
		
		assertEquals(BigDecimal.valueOf(22.55), zr.getSaldo());
	}
	
	/*
	 * slechte testen
	 */
	
	@ParameterizedTest
	@ValueSource(doubles = {-78, 0, KLEINSTE_GRENS-0.01, 0.008, 0.000001})
	void maakZichtrekening_grensEnAndereFouteWaarden_WerptException(double aantal) {
		assertThrows(IllegalArgumentException.class, 
				() -> zr.stort(BigDecimal.valueOf(aantal)));
	}
	
	/*
	 * null testen
	 */
	
	@Test      																	
	void maaktZichtrekening_null_werptExceoption() {
		assertThrows(IllegalArgumentException.class, 
				() -> zr.stort(null));
	}

}
