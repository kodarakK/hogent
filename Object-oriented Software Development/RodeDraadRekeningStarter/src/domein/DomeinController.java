package domein;

import java.math.BigDecimal;

import dto.RekeningDTO;

public class DomeinController {
	private Bank miniBank = new Bank();

	public void voegRekeningToe(long rekeningNummer, String houder) {
		Rekening rekening = new Rekening(rekeningNummer, houder);
		miniBank.voegRekeningToe(rekening);
	}

	public void voegRekeningToe(long rekeningNummer, String houder, BigDecimal saldo) {
		Rekening rekening = new Rekening(rekeningNummer, houder, saldo);
		miniBank.voegRekeningToe(rekening);
	}

	// TODO
	public RekeningDTO[] geefRekeningen() {
		RekeningDTO[] rekDTO = new RekeningDTO[miniBank.getRekeningen().size()];
		
		int index = 0;
		for (Rekening rek : miniBank.getRekeningen())
		{
			rekDTO[index++] = new RekeningDTO(rek.getRekeningnummer(), rek.getHouder(), rek.getSaldo());
		}
		
		return rekDTO;
	}

	public void stort(int indexVanRekening, BigDecimal bedrag) {
		miniBank.geefRekening(indexVanRekening).stort(bedrag);
	}

	public void haalAf(int indexVanRekening, BigDecimal bedrag) {
		miniBank.geefRekening(indexVanRekening).haalAf(bedrag);
	}

	public void schrijfOver(int indexVanRekening, int indexNaarRekening, BigDecimal bedrag) {
		miniBank.geefRekening(indexVanRekening).schrijfOver(bedrag, miniBank.geefRekening(indexNaarRekening));
	}

}
