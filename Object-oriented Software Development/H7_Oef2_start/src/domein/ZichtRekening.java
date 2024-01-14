package domein;

public class ZichtRekening extends Rekening
{
	private double maxKredietOnderNul;
	
	public ZichtRekening(long rekeningNr, String houder, double maxKredietOnderNul) {
		super(rekeningNr, houder);
		setMaxKredietOnderNul(maxKredietOnderNul);
	}

	public double getMaxKredietOnderNul()
	{
		return maxKredietOnderNul;
	}

	public final void setMaxKredietOnderNul(double maxKredietOnderNul)
	{
		if (maxKredietOnderNul > 0 || maxKredietOnderNul > getSaldo()) 
			throw new IllegalArgumentException("Max krediet onder nul moet negatief zijn en kleiner of gelijk aan "
					+ "huidig saldo");
		this.maxKredietOnderNul = maxKredietOnderNul;
	}
	
	@Override
	public boolean haalAf(double bedrag) {
		if (getSaldo() - bedrag < maxKredietOnderNul)
			return false;
		return super.haalAf(bedrag);
	}
	
	@Override
	public String toString() {
		return String.format("%s. Max krediet onder nul = %.2f", super.toString(), getMaxKredietOnderNul());
	}
	
	
}
