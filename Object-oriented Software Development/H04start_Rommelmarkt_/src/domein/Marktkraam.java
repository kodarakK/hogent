package domein;

public class Marktkraam {
	private String kraamhouder;
	private int breedte;
	private double inkomsten;
	
	private static final int DEFAULT_BREEDTE = 10;

	public static final int MAX_BREEDTE = 10;
	public static final int MIN_BREEDTE = 2;

	private static final int NORMAAL_KRAAM_PRIJS = 10;
	private static final int BREED_KRAAM_PRIJS = 2;
	
	
	
	public Marktkraam(String kraamhouder, int breedte)
	{
		setKraamhouder(kraamhouder);
		setBreedte(breedte);
	}

	public Marktkraam(String kraamhouder)
	{
		this(kraamhouder, DEFAULT_BREEDTE);
	}
	
	private void setKraamhouder(String kraamhouder) {
		if (kraamhouder != null && !kraamhouder.isBlank()) {
			this.kraamhouder = kraamhouder;
		} else {
			this.kraamhouder = "anoniem";
		}
	}
	
	private void setBreedte(int breedte ) {
		if (breedte >= MIN_BREEDTE && breedte <= MAX_BREEDTE) {
			this.breedte = breedte;
		} else {
			this.breedte = DEFAULT_BREEDTE;
		}
	}
	
	public String getKraamhouder()
	{
		return this.kraamhouder;
	}

	public int getBreedte()
	{
		return this.breedte;
	}
	
	public void ontvang(double bedrag) {
		if (bedrag > 0) {
			this.inkomsten += bedrag;
		}
	}
	
	public double geefWinst() {
		double prijsPerMeter = breedte <= MAX_BREEDTE/2? NORMAAL_KRAAM_PRIJS : BREED_KRAAM_PRIJS;
		
		double kostPrijs = breedte * prijsPerMeter;
		
//		double kostPrijs;
//		if (this.breedte <= MAX_BREEDTE/2) {
//			kostPrijs = breedte * 3;
//		} else {
//			kostPrijs = breedte * 2.5;
//		}
		return this.inkomsten - kostPrijs;
	}
	
	
}
