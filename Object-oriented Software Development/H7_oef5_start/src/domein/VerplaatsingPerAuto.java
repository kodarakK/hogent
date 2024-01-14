package domein;

public class VerplaatsingPerAuto extends Verplaatsing
{
	private double benzinePrijs;
	private double verbruik;
	
	public static final double MIN_BENZINEPRIJS = 0.5;
	public static final double MAX_BENZINEPRIJS = 2.0;
	public static final double MIN_VERBUIK= 0.02;
	public static final double MAX_VERBRUIK= 0.07;
	
	
	
	public VerplaatsingPerAuto(String van, String naar, double aantalKM, double benzinePrijs, double verbruik)
	{
		super(van, naar, aantalKM);
		setBenzineprijs(benzinePrijs);
		setVerbruik(verbruik);
	}
	public double getBenzineprijs()
	{
		return benzinePrijs;
	}
	public void setBenzineprijs(double benzinePrijs)
	{
		if (benzinePrijs < MIN_BENZINEPRIJS || benzinePrijs > MAX_BENZINEPRIJS)
			throw new IllegalArgumentException("benzineprijs buiten grenzen");
		this.benzinePrijs = benzinePrijs;
	}
	public double getVerbruik()
	{
		return verbruik;
	}
	public void setVerbruik(double verbruik)
	{

		if (verbruik < MIN_VERBUIK || verbruik > MAX_VERBRUIK)
			throw new IllegalArgumentException("verbruik buiten grenzen");
		this.verbruik = verbruik;
	}
	
	@Override 
	public String toString() {
		return String.format("%s per auto%nKosten voor deze verplaatsing %.2f",
								super.toString(),
								berekenPrijs());
	}
	
	public double berekenPrijs() {
		return verbruik * benzinePrijs * super.getAantalKm() * 2;
	}
	
	
}
