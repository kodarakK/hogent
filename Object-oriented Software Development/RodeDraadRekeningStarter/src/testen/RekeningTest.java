package testen;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Rekening;

public class RekeningTest {
	private Rekening rekeningMet500Euro;
	private Rekening rekeningMet0Euro;

	@BeforeEach
	void setUp() {
		rekeningMet500Euro = new Rekening(101010101010L, "Mali", new BigDecimal(500));
		rekeningMet0Euro = new Rekening(101010101010L, "Tamu");
	}

	@Test
	void maakRekening_ZonderInitieelSaldo_MaaktRekening() {
		Rekening r = new Rekening(123456789123L, "Mali");
		Assertions.assertEquals(BigDecimal.ZERO, r.getSaldo());
		Assertions.assertEquals(123456789123L, r.getRekeningnummer());
		Assertions.assertEquals("Mali", r.getHouder());
	}

	@Test
	void maakRekening_MetInitieelSaldo_MaaktRekening() {
		Rekening r = new Rekening(123456789123L, "Mali", new BigDecimal("1000"));
		Assertions.assertEquals(new BigDecimal("1000"), r.getSaldo());
		Assertions.assertEquals(123456789123L, r.getRekeningnummer());
		Assertions.assertEquals("Mali", r.getHouder());
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "   ", "\t\t" })
	public void maakRekening_ongeldigeHouder_werptException(String houder) {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Rekening(123456789123L, houder, new BigDecimal("1000")));
	}
	
	@Test
	void maakRekening_NegatiefSaldo_WerptException() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Rekening(123456789123L, "Tamu", new BigDecimal("-1000")));
	}

	@Test
	void maakRekening_NegatiefGrensSaldo_WerptException() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Rekening(123456789123L, "Tamu", new BigDecimal("-0.0001")));
	}
	
	@Test
	void maakRekening_RekeningNummerTeLang_WerptException() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Rekening(12345678912345L, "Tamu", new BigDecimal("1000")));
	}

	@Test
	void stort_PositiefBedrag_VerhoogtSaldo() {
		rekeningMet500Euro.stort(new BigDecimal("100.10"));
		Assertions.assertEquals(new BigDecimal("600.10"), rekeningMet500Euro.getSaldo());
	}

	@Test
	void stort_NegatiefBedrag_WijzigtSaldoNiet() {
		rekeningMet500Euro.stort(new BigDecimal("-100.10"));
		Assertions.assertEquals(new BigDecimal("500"), rekeningMet500Euro.getSaldo());
	}

	@Test
	void stort_GrensBedragNul_WijzigtSaldoNiet() {
		rekeningMet500Euro.stort(new BigDecimal("0.0"));
		Assertions.assertEquals(new BigDecimal("500"), rekeningMet500Euro.getSaldo());
	}
	
	@Test
	void haalAf_PositiefBedragEnSaldoVoldoende_VerlaagtSaldo() {
		rekeningMet500Euro.haalAf(new BigDecimal("100.10"));
		Assertions.assertEquals(new BigDecimal("399.90"), rekeningMet500Euro.getSaldo());
	}

	@Test
	void haalAf_PositiefBedragEnSaldoOnvoldoende_WerptException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		             rekeningMet500Euro.haalAf(new BigDecimal("600")));
	}

	@Test
	void haalAf_PositiefBedragEnGrensSaldoOnvoldoende_WerptException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		             rekeningMet500Euro.haalAf(new BigDecimal("500.01")));
	}
	
	@Test
	void haalAf_NegatiefBedrag_WijzigtSaldoNiet() {
		rekeningMet500Euro.haalAf(new BigDecimal("-100.10"));
		Assertions.assertEquals(new BigDecimal("500"), rekeningMet500Euro.getSaldo());
	}

	@Test
	void schrijfOver_SaldoVoldoende_PastRekeningenAan() {
		rekeningMet500Euro.schrijfOver(new BigDecimal("100.10"), rekeningMet0Euro);
		Assertions.assertEquals(new BigDecimal("399.90"), rekeningMet500Euro.getSaldo());
		Assertions.assertEquals(new BigDecimal("100.10"), rekeningMet0Euro.getSaldo());
	}

	@Test
	void schrijfOver_SaldoGrensVoldoende_PastRekeningenAan() {
		rekeningMet500Euro.schrijfOver(new BigDecimal("500"), rekeningMet0Euro);
		Assertions.assertEquals(new BigDecimal("0"), rekeningMet500Euro.getSaldo());
		Assertions.assertEquals(new BigDecimal("500"), rekeningMet0Euro.getSaldo());
	}
	
	@Test
	void schrijfOver_SaldoOnvoldoende_WerptException() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> rekeningMet500Euro.schrijfOver(new BigDecimal("600"), rekeningMet0Euro));
	}

	@Test
	void schrijfOver_SaldoGrensOnvoldoende_WerptException() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> rekeningMet500Euro.schrijfOver(new BigDecimal("500.01"), rekeningMet0Euro));
	}
	
	@Test
	void schrijfOver_NegatiefBedrag_PastRekeningenNietAan() {
		rekeningMet500Euro.schrijfOver(new BigDecimal("-600"), rekeningMet0Euro);
		Assertions.assertEquals(new BigDecimal("500"), rekeningMet500Euro.getSaldo());
		Assertions.assertEquals(new BigDecimal("0"), rekeningMet0Euro.getSaldo());
	}
}