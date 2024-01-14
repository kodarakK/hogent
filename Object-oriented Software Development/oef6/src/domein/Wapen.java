package domein;

import domein.Voorwerp;

public class Wapen extends Voorwerp
{
	private int kracht;
	private boolean gebruikt;
	
	private static final int MAX_NIVEAU = 5;
	
	private static final int MIN_KRACHT = 0;
	


	public Wapen(String naam, double gewicht, int niveau, int kracht, boolean gebruikt)
	{
		super(naam, gewicht, niveau);
		controleerNiveau(niveau);
		setKracht(kracht);
		setGebruikt(gebruikt);
	}


	public int getKracht()
	{
		return kracht;
	}

	public void setKracht(int kracht)
	{
		if (kracht < MIN_KRACHT)
			throw new IllegalArgumentException(String.format(
					"kracht moet groter zijn dan %d",
					MIN_KRACHT));
		
		this.kracht = kracht;
	}

	public boolean isGebruikt()
	{
		return gebruikt;
	}
	
	private void setGebruikt(boolean gebruikt) {
		this.gebruikt = gebruikt;
	}
	
	private void controleerNiveau(int niveau)
	{
		if (niveau >= MAX_NIVEAU)
			throw new IllegalArgumentException(String.format(
					"niveau moet groter zijn dan %d",
					MAX_NIVEAU
					));		
	}

	@Override
	public String toString() {
		return String.format(
				"%s en met kracht %d %s gebruikt.",
				super.toString(),
				kracht,
				gebruikt?"al":"nog niet"
				);
	}
	
	
	
}
