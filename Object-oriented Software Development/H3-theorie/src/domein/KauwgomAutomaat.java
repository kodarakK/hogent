package domein;

public class KauwgomAutomaat
{

	private int aantalBallen;
	private String kleur;
	private boolean vergrendeld = true;
	
	private static final String DEFAULT_KLEUR = "rood";

	private void setAantalBallen(int aantalBallen2)
	{
		// [0, 150]
		
		if (aantalBallen2 >= 0 && aantalBallen2 < 150) 
			this.aantalBallen = aantalBallen2;
	}
	
	public int getAantalBallen()
	{
		return this.aantalBallen;
	}
	
	private void setKleur(String kleur2)
	{
		if (kleur2 != null && !kleur2.isBlank()) {
			this.kleur = kleur2;
		}
	}

	public String getKleur()
	{
		return this.kleur;
	}

	public boolean isVergrendeld()
	{
		return this.vergrendeld;
	}

	public void setVergrendeld(boolean value)
	{
		this.vergrendeld = value;
	}
	
	public KauwgomAutomaat(int aantalBallen, String kleur)
	{
		setAantalBallen(aantalBallen);
		setKleur(kleur);
	}
	
	public KauwgomAutomaat(int aantalBallen)
	{
		this(aantalBallen, DEFAULT_KLEUR);
	}

	public KauwgomAutomaat()
	{
		this(0, DEFAULT_KLEUR);
	}

	public KauwgomAutomaat(String kleur) {
		this(0, kleur);
	}
	
	/*
	 * gedrag
	 */

	public boolean isLeeg()
	{
		/*
		 * SLECHTE CODE
		 * if (this.aantalBallen == 0) retrurn true;
		 * return false;
		 */
		
		return this.aantalBallen == 0;
	}
	
	// Overloaded methoden

	public void vulBij(int aantalBallen)
	{
		if (!isVergrendeld() && aantalBallen > 0)
		{
			// this.aantalBallen += aantalBallen;
			setAantalBallen(this.aantalBallen + aantalBallen);
		}
	}
	
	public void vulBij(double percentage) {
		int aantal = (int)(this.aantalBallen * percentage / 100); // type casting
		vulBij(aantal);
	}
	
	public void vulBij(int aantalBallen, boolean geldig) {
		
	}

	public void draaiHendel()
	{
		if (!isVergrendeld() && !isLeeg())	this.aantalBallen--;
		// of setAantalBallen(this.aantalBallen - 1);
	}
}
