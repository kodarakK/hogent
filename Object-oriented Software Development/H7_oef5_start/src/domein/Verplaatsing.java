package domein;

public class Verplaatsing
{
    private String van;
    private String naar;
 
    private double aantalKM;
    
    

	public Verplaatsing(String van, String naar, double aantalKM)
	{
		super();
		setVan(van);
		setNaar(naar);
		setAantalKm(aantalKM);
	}

	public String getVan()
	{
		return van;
	}

	public void setVan(String van)
	{
		if (van == null || van.isBlank()) {
			throw new IllegalArgumentException(String.format("%s moet bestaan", van));
		}
		this.van = van;
	}

	public String getNaar()
	{
		return naar;
	}

	public void setNaar(String naar)
	{
		if (naar == null || naar.isBlank()) {
			throw new IllegalArgumentException(String.format("%s moet bestaan", naar));
		}
		this.naar = naar;
	}

	public double getAantalKm()
	{
		return aantalKM;
	}

	public void setAantalKm(double aantalKM)
	{
		if (aantalKM <= 0) 
			throw new IllegalArgumentException(
					String.format(
							"aantalKM moet strikt positief zijn"));
		this.aantalKM = aantalKM;
	}
    
	@Override
	public String toString() {
		return String.format("verplaatsing van %s naar %s", van, naar);
	}
    
}
