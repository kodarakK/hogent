package domein;

public class Auto
{
    private boolean elektrisch;
    private double aantalKilometers;
    private int vergoeding;

    private static final double DEFAULT_AANTAL_KILOMETERS = 400.50;
    private static final int    DEFAULT_VERGOEDING = 2;
    private static final boolean DEFAULT_ELEKTRISCH = true;
    private static final int MIN_VERGOEDING = 0;
    private static final int MAX_VERGOEDING = 5;
    private static final int MIN_AANTAL_KILOMETERS = 0;
    private static final int MAX_AANTAL_KILOMETERS = 1000;
    
    
    
    
	public Auto(boolean elektrisch, double aantalKilometers, int vergoeding)
	{
		setElektrisch(elektrisch);
        setAantalKilometers(aantalKilometers);
        setVergoeding(vergoeding);
	}

    public Auto(double aantalKilometers, int vergoeding) {
        this(DEFAULT_ELEKTRISCH, aantalKilometers, vergoeding);
    }

    public Auto(int vergoeding) {
        this(DEFAULT_ELEKTRISCH, DEFAULT_AANTAL_KILOMETERS, vergoeding);
    }

	public boolean isElektrisch()
	{
		return elektrisch;
	}
	public double getAantalKilometers()
	{
		return aantalKilometers;
	}
	public int getVergoeding()
	{
		return vergoeding;
	}
	public void setAantalKilometers(double aantalKilometers)
	{
		this.aantalKilometers = (aantalKilometers >= MIN_AANTAL_KILOMETERS && aantalKilometers <= MAX_AANTAL_KILOMETERS)?aantalKilometers:DEFAULT_AANTAL_KILOMETERS;
	}
	public void setVergoeding(int vergoeding)
	{
		this.vergoeding = (vergoeding > MIN_VERGOEDING && vergoeding <= MAX_VERGOEDING)?vergoeding:DEFAULT_VERGOEDING;
	}

    public boolean heeftExtraVergoeding() {
        return (isElektrisch()?(aantalKilometers <= DEFAULT_AANTAL_KILOMETERS)?true:false:false);
    }

    public double berekenTotaleVergoeding() {
        double totaleVergoeding = (MAX_AANTAL_KILOMETERS - aantalKilometers) * vergoeding;
        return (heeftExtraVergoeding())?(2*totaleVergoeding):totaleVergoeding;
    }

    private void setElektrisch(boolean elektrisch) {
        this.elektrisch = elektrisch;
    }
    
    
}
