package domein;

import java.math.BigDecimal;

public class Rekening {
	
	private long rekeningnummer;
	private String houder;
	private BigDecimal saldo;

	public Rekening(long rekeningnummer, String houder) {
		this(rekeningnummer, houder, new BigDecimal("0"));
	}

	public Rekening(long rekeningnummer, String houder, BigDecimal saldo) {
		setRekeningnummer(rekeningnummer);
		setHouder(houder);
		setSaldo(saldo);
	}

	private void setRekeningnummer(long rekeningnummer) {
		// TODO
		//rekeningnummer: mag niet meer dan 12 cijfers bevatten
		if (rekeningnummer > 999999999999L)
			throw new IllegalArgumentException(
					"rekeningnummer mag niet meer dan 12 cijfers bevatten");
		this.rekeningnummer = rekeningnummer;
	}

	private void setHouder(String houder) {
		// TODO
		if (houder == null || houder.isBlank())
			throw new IllegalArgumentException(
					"houder moet ingevuld zijn");
		this.houder = houder;
	}

	private void setSaldo(BigDecimal saldo) {
		// TODO
		if (saldo != null && saldo.signum() < 0)
			throw new IllegalArgumentException(
					"saldo moet positief zijn");
		this.saldo = saldo;
	}

	public long getRekeningnummer() {
		return rekeningnummer;
	}

	public String getHouder() {
		return houder;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}
	
	public void stort(BigDecimal bedrag) {
		// TODO
		if (bedrag != null && bedrag.signum() > 0) //bedrag > 0 -> signum
			setSaldo( saldo.add(bedrag) ); //saldo + bedrag -> 	add
	}

	public void haalAf(BigDecimal bedrag) {
		// TODO
		if (bedrag != null && bedrag.signum() > 0) //bedrag > 0 -> signum
			setSaldo( saldo.subtract(bedrag) ); //saldo - bedrag -> subtract
	}

	public void schrijfOver(BigDecimal bedrag, Rekening naarRekening) {
		// TODO	
		if (naarRekening != null)
		{
			haalAf( bedrag   );
			naarRekening.stort(bedrag);
			//bedrag moet gestort worden bij naarRekening (stort)
		}
	}

}