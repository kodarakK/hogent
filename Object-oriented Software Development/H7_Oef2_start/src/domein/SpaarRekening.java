
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
		if (aangroeiIntrest < 0.0)
			throw new IllegalArgumentException("moet positief zijn");
		this.aangroeiIntrest = aangroeiIntrest;
	}
	
	@Override 
	public boolean haalAf(double bedrag) {
		if (bedrag > 0)
        {
            super.haalAf(bedrag);
            return true;
        }

        return false;
	}
	
	@Override 
	public String toString() {
		return super.toString() + String.format("aangroeintrest = .2f", aangroeiIntrest);
	}
	
}
