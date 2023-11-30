package domein;

public class Rekening
{
	private long rekeningNummer;
	private double saldo = 0;
	private String naamHouder;
	
	private static final long DEFAULT_REKENINGNUMMER = 123456789L;
	private static final String DEFAULT_NAAMHOUDER = "onbekend";
	
	public Rekening()
	{
		this(DEFAULT_REKENINGNUMMER, DEFAULT_NAAMHOUDER);
	}
	
	public Rekening(long rekeningNummer) {
		this(rekeningNummer, DEFAULT_NAAMHOUDER);
	}
	
	public Rekening(long rekeningNummer, String naamHouder) {
		setNaamHouder(naamHouder);
		setRekeningNummer(rekeningNummer);
	}
	
	
	
	private void setRekeningNummer(long rekeningNummer) {
		this.rekeningNummer = rekeningNummer;
	}
	
	public String getNaamHouder()
	{
		return naamHouder;
	}
	public final void setNaamHouder(String naamHouder)
	{
		if (naamHouder != null && !naamHouder.isBlank()) {
			this.naamHouder = naamHouder;
		}
	}
	public long getRekeningNummer()
	{
		return rekeningNummer;
	}
	public double getSaldo()
	{
		return saldo;
	}
	
	
	public boolean stort(double bedrag) {
		if (bedrag <= 0) {
			return false;
		} 
		this.saldo += bedrag;
		return true;
	}
	
	public boolean haalAf(double bedrag) {
		if (bedrag > this.saldo || bedrag < 0) {
			return false;
		}
		this.saldo -= bedrag;
		return true;
	}
	
}
