package domein;

public class VerplaatsingPerBusTram extends Verplaatsing
{
	private int lijnnr;
	private boolean bus;
	private boolean stadslijn;
	
	private final static double PRIJS_PER_HALTE = 0.32;
	
	private final static double KORTING_MET_STADSLIJN = 0.2;
	
	

	public VerplaatsingPerBusTram(String van, String naar, double aantalKM, int lijnnr, boolean bus, boolean stadslijn)
	{
		super(van, naar, aantalKM);
		setLijnnr(lijnnr);
		setBus(bus);
		setStadslijn(stadslijn);
	}

	public int getLijnnr()
	{
		return lijnnr;
	}

	public void setLijnnr(int lijnnr)
	{
		if (lijnnr <= 0)
			throw new IllegalArgumentException("lijnr moet strikt positief zijn");
		
		this.lijnnr = lijnnr;
	}

	public boolean isBus()
	{
		return bus;
	}

	public boolean isStadslijn()
	{
		return stadslijn;
	}
	
	private void setBus(boolean bus) {
		this.bus = bus;
	}

	private void setStadslijn(boolean stadslijn) {
		this.stadslijn = stadslijn;
	}
	
	@Override 
	public String toString() {
		return String.format(
				"%s met stads%s %d%nKosten voor deze verplaatsing %.2f",
				super.toString(),
				bus?"bus":"tram",
				lijnnr,
				berekenPrijs());
	}
	
	public double berekenPrijs() {
		int aantalHaltes = (int)Math.ceil(super.getAantalKm());
		
		double prijs = 2 * aantalHaltes * PRIJS_PER_HALTE;
		
		double korting = 0;
		
		if (stadslijn)
			korting = KORTING_MET_STADSLIJN;
		
		return prijs - (prijs) * korting;
	}
}
