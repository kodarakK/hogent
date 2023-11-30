package domein;

public class Rechthoek {
	private double lengte;
	private double breedte;
	
	//static attribuut -> STATIC = alle instanties(=objecten) van Rechthoek
	//hebben 0 als aantalRechthoeken, waarde kan gewijzigd worden: 
	private static int aantalRechthoeken;
	
	//static constante -> FINAL = waarde kan niet gewijzigd worden
	//STATIC = alle instanties van Rechthoek hebben 10 als DEFAULT_BOVENGRENS 
	private static final int DEFAULT_BOVENGRENS = 10;
	//Idem voor BOVENGRENS
	private static final int BOVENGRENS = 100;
	
	private final int WAARDE;
	

	public Rechthoek(double lengte, double breedte, int waarde) {
		setLengte(lengte);
		setBreedte(breedte);
		
//		setWaarde(waarde);   WERKT NIET
		controleerEenWaarde("Waarde", BOVENGRENS, waarde);
//		een final attr MOET in de contructor worden opgevuld
		WAARDE = waarde;
		aantalRechthoeken++;
	}

	/*
	private void setWaarde(int waarde)
	{
		this.WAARDE = waarde;
		
	}
	*/


	public Rechthoek(double lengte, double breedte) {
		this(lengte, breedte, DEFAULT_BOVENGRENS);
	}
	
	public Rechthoek() {
		this(DEFAULT_BOVENGRENS, DEFAULT_BOVENGRENS, DEFAULT_BOVENGRENS);
	}
	
	public double getLengte() {
		return lengte;
	}

	public double getBreedte() {
		return breedte;
	}

	public final void setLengte(double lengte) {
		//this.lengte = (lengte <= 0 || lengte > BOVENGRENS)? DEFAULT_BOVENGRENS: lengte;
		controleerEenWaarde("lengte", BOVENGRENS, lengte);
		this.lengte = DEFAULT_BOVENGRENS;
		
//		niet goed: 
//			if (correct) this.lengte = lengte;
//			else 
//				throw new IllegalArgumentExcpetion();
	}

	public final void setBreedte(double breedte) {
//		this.breedte = (breedte <= 0 || breedte > BOVENGRENS)? DEFAULT_BOVENGRENS: breedte;
		controleerEenWaarde("breedte", BOVENGRENS, breedte);
		this.breedte = breedte;
	}

	private void controleerEenWaarde(String woord, int max, double echtWaarde) {
		if (echtWaarde <= 0 || echtWaarde > max)
			throw new IllegalArgumentException(
String.format("%s moet strikt positief zijn en kleiner of gelijk aan %d%n",woord, max));
	}
//STATIC methode
	public static int getAantalRechthoeken() {
		return aantalRechthoeken;
	}

	public double geefOppervlakte() {
		return lengte * breedte;
	}

	public double geefOmtrek() {
		return 2 * (lengte + breedte);
	}

	@Override
	public String toString() {
		return String.format("Rechthoek van %.2f op %.2f.", lengte, breedte);
	}
}