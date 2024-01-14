package domein;

public class Voorwerp {
    private final String naam;
    private double gewicht;
    private int niveau;

    private static final int MAX_NIVEAU = 10;
    private static final int MAX_GEWICHT = 1000;
    private static final int MIN_GEWICHT = 0;
    private static final int MIN_NIVEAU = 1;
    
    private static final int DEFAULT_NIVEAU = 1;

    

    public Voorwerp(String naam, double gewicht, int niveau)
	{
    	controleerNaam(naam);
		this.naam = naam;
		setGewicht(gewicht);
		setNiveau(niveau);
	}
    
    public Voorwerp(String naam, double gewicht) {
    	this(naam, gewicht, DEFAULT_NIVEAU);
    }

	public String getNaam()
	{
		return naam;
	}

	public double getGewicht()
	{
		return gewicht;
	}

	public int getNiveau()
	{
		return niveau;
	}

	private void controleerNaam(String naam) {
		if (naam == null || naam.isBlank())
			throw new IllegalArgumentException("Naam mag niet leeg zijn.");
	}
	

    @Override
    public String toString() {
        return String.format("%s %s met gewicht %.3f kg uit niveau %d",
        		this.getClass().getSimpleName(),
        		naam,
        		gewicht, 
        		niveau);
    }

    private void setGewicht(double gewicht) {
    	if (gewicht < MIN_GEWICHT || gewicht >= MAX_GEWICHT) 
    		throw new IllegalArgumentException(
    				String.format("getal moet groter dan %d zijn en kleiner dan %d zijn", MIN_GEWICHT, MAX_GEWICHT));
    	this.gewicht = gewicht;
    	
    }

    private void setNiveau(int niveau) {
    	if (niveau < MIN_NIVEAU || niveau > MAX_NIVEAU)
    		throw new IllegalArgumentException(
    				String.format("Niveau moet groter zijn dan %d en kleiner dan %d", MIN_NIVEAU, MAX_NIVEAU)
    				);
    	this.niveau = niveau;
    }
}
