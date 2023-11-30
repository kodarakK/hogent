package testen;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Bank;
import domein.Rekening;

public class BankTest {

	private Bank deBank;
	private Rekening r1, r2, r3, r4, r5;

	@BeforeEach
	void setUp() {
		deBank = new Bank();
		r1 = new Rekening(123456789123L, "Mali");
		r2 = new Rekening(123456789121L, "Tamu");
		r3 = new Rekening(123456789122L, "Evelyn");
		r4 = new Rekening(123456789124L, "Ethel");
		r5 = new Rekening(123456789125L, "Mazvita");
	}

	@Test
	void maakBank_MaaktEenLegeBank() {
		List<Rekening> alleRekeningen = new ArrayList<>();
		Assertions.assertEquals(alleRekeningen, deBank.getRekeningen());
	}

	@Test
	void voegRekeningToe_BankMet2Rekeningen_VoegtRekeningToe() {
		voegRekeningen1En2Toe();
		List<Rekening> alleRekeningen = List.of(r1, r2 );
		Assertions.assertEquals(alleRekeningen, deBank.getRekeningen());
	}

	@Test
	void voegRekeningToe_BankMet5Rekeningen_VoegtRekeningToe() {
		voegRekeningen1En2Toe();
		deBank.voegRekeningToe(r3);
		deBank.voegRekeningToe(r4);
		deBank.voegRekeningToe(r5);
		List<Rekening> alleRekeningen = List.of(r1, r2, r3, r4, r5);
		Assertions.assertEquals(alleRekeningen, deBank.getRekeningen());
	}

	@Test
	void geefRekening_IndexVanRekeningOK_RetourneertRekening() {
		voegRekeningen1En2Toe();
		Rekening r = deBank.geefRekening(1);
		Assertions.assertEquals(r2, r);
	}

	@Test
	void geefRekening_IndexVanRekeningNegatief_RetourneertNUll() {
		deBank.voegRekeningToe(r1);
		Assertions.assertNull(deBank.geefRekening(-1));
	}

	@Test
	void geefRekening_IndexVanRekeningTeGroot_RetourneertNUll() {
		voegRekeningen1En2Toe();
		Assertions.assertNull(deBank.geefRekening(2));
	}

	private void voegRekeningen1En2Toe()
	{
		deBank.voegRekeningToe(r1);
		deBank.voegRekeningToe(r2);
	}
}
