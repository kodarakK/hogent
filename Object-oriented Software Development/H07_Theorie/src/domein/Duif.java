package domein;

public class Duif extends Huisdier
{
	private final long ringnr;
	
	public Duif(String naam, long ringnr)
	{
		/*
		 * als we niks schrijven wordk super() opgeroepen
		 * compileerfout: 
		 */
		
		super(naam);
		
		/*
		 * H6: werkt inet, final attr. moet ingevuld worden in de constructor
		 * setControleerRingnr(RingNr);
		 * 
		 */
		
		
		controleerRingnr(ringnr);
		this.ringnr = ringnr;
	}
	
	public String maakGeluid() 
	{
		return String.format("roekoekoe%s", super.maakGeluid());
	}

	public long getRingnr() 
	{
		return ringnr;
	}

	private void controleerRingnr(long ringnr) 
	{
		if (ringnr <= 19000000000L || ringnr > 99999999999L)
			throw new IllegalArgumentException("Geen geldig ringnummer");
	}

	@Override
	public String toString() 
	{                                              // super. MOETEN
		return String.format("%s met ringnummer %d", super.toString(), ringnr);
	}
}