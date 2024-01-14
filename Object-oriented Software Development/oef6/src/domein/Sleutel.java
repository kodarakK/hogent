package domein;

import domein.Wapen;

public class Sleutel extends Voorwerp
{
	private int deur;
	private static int aantalInOmloop;
	
	private static final int MIN_DEUR = 0;
	
	public Sleutel(String naam, double gewicht, int niveau, int deur)
	{
		super(naam, gewicht, niveau);
		setDeur(deur);
		aantalInOmloop++;
	}

	public int getDeur()
	{
		return deur;
	}

	public final void setDeur(int deur)
	{
		if (deur < MIN_DEUR)
			throw new IllegalArgumentException(
					String.format(
							"deur moet groter of gelijk aan %d zijn",
							MIN_DEUR
							)
					);
		this.deur = deur;
	}

	public static int getAantalInOmloop()
	{
		return aantalInOmloop;
	}

	public final static void setAantalInOmloop(int aantalInOmloop)
	{
		Sleutel.aantalInOmloop = aantalInOmloop;
	}
	
	public boolean pastOp(int deur) {
		return this.deur == deur;
	}
	
	
	@Override 
	public String toString() {
		return String.format(
				"%s past op deur %d",
				super.toString(),
				deur
				);
	}
	
	
}
