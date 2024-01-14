
package domein;

public class SpaarRekening extends Rekening
{
	private static double aangroeiIntrest = 0.0;

	public SpaarRekening(long rekeningNr, String houder)
	{
		super(rekeningNr, houder);
	}

	public static double getAangroeiIntrest()
	{
		return aangroeiIntrest;
	}

	public static void setAangroeiIntrest(double aangroeiIntrest)
	{
		if (aangroeiIntrest < 0)
			throw new IllegalArgumentException("Intrest mag niet negatief zijn!");
		SpaarRekening.aangroeiIntrest = aangroeiIntrest; // static: klasse niveau => niet 'this.'
	}
	
	@Override 
	public boolean haalAf(double bedrag) {
		if (bedrag > getSaldo())
        {
            return false;
        }

        return super.haalAf(bedrag);
	}
	
	@Override 
	public String toString() {
		return String.format("%s. Aangroeintrest = .2f", super.toString(), aangroeiIntrest);
	}
	
}
