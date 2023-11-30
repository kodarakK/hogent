package domein;

public class Kapitaal {
	public static final double MIN_BEDRAG = 0, MIN_INTREST = 0, MAX_INTREST = 100, 	MIN_AANTAL_JAAR  = 0;
	private double bedrag, intrest;

	public Kapitaal(double bedrag, double intrest) {
		setBedrag(bedrag);
		setIntrest(intrest);
	}

	public double getBedrag() {
		return bedrag;
	}

	public final void setBedrag(double bedrag) { //bedrag moet positief zijn
		// TODO - exception werpen indien niet aan domeinregel voldaan is
		
		if (bedrag <= MIN_BEDRAG) throw new IllegalArgumentException("Bedrag moet positief zijn.");
		
		this.bedrag = bedrag;
	}

	public double getIntrest() {
		return intrest;
	}

	public final void setIntrest(double intrest) { // interest moet in het interval [0, 100] liggen
		// TODO - exception werpen indien niet aan domeinregel voldaan is
		if (intrest < MIN_INTREST && intrest > MAX_INTREST) 
			throw new IllegalArgumentException(
					String.format("Intrest moet in het interval [%.0f, %.0f] liggen.", MIN_INTREST, MAX_INTREST));
		
		this.intrest = intrest;
	}

	public double geefOpgebouwdKapitaal(int aantalJaar) {
		// TODO - recursieve invulling geven
		//K(aantalJaar) = bedrag      voor aantalJaar = 0
//		K(aantalJaar)  = (1 + interest /100) * K(aantalJaar -1) vooraantal jaar > 0
		if (aantalJaar  < 0) 
			throw new IllegalArgumentException(
					String.format("Aantal jaar moet groter of gelijk zijn aan %f", MIN_AANTAL_JAAR));
		
		if (aantalJaar == 0)
			return bedrag;
	
		return (1 + intrest / 100) * geefOpgebouwdKapitaal(aantalJaar - 1);
	}

}
