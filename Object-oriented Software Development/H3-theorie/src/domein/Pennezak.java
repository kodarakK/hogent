package domein;

public class Pennezak
{
	/*
	 * eigenschappen: attributen 
	 */
	
	/*
	 * data is verborgen
	 */
	
	private String kleur; // null
	private int lengte; // 0
	private boolean open; // false
	
	// final = const
	private final static String DEFAULT_KLEUR = "Blauw";
	private final static int DEFAULT_LENGTE = 10;
	
	/*
	 * constructor  = speciale methode om een object te creëren
	 */
	public Pennezak(String kleur, int lengte) {
		/*
		 * zelden: this.kleur = kleur;
		 * 
		 */
		setKleur(kleur);
		setLengte(lengte);
	}
	
	/*
	 * We schrijven 2 constructor met de meeste argumenten uit (setters oproepen)
	 * alle andere constructors roepen de constructor op met de meeste argumenten
	 */
	
	public Pennezak(int lengte) {
		/* 
		 * NOOTIT COPY PASTE CODE
		 */
		
		this(DEFAULT_KLEUR, lengte);
	}
	
	public Pennezak() {
		this(DEFAULT_KLEUR, DEFAULT_LENGTE);
	}

	/*
	 * kleur mag nadien niet gewijzigd worden ==> private
	 */
	private void setKleur(String kleur)
	{
		/*
		if (kleur == null || kleur.isBlank()) 
			this.kleur = "Blauw";
		else 
			this.kleur = kleur;
		*/
		
		this.kleur = (kleur == null || kleur.isBlank())?DEFAULT_KLEUR:kleur;
		
		/*
		 * this.kleur is attribuut
		 * 
		 * kleur is het argument
		 */
	}

	public final void setLengte(int lengte2)
	{
		this.lengte = (lengte2 <= 0)?DEFAULT_LENGTE:lengte2; // this. moet
	}

	// getters
	public String getKleur() {
		return this.kleur; // this. mag
	}

	public int getLengte() {
		return this.lengte;
	}

	// opvragen van een de waarde van een boolean begint niet met get maar met is
	
	public boolean isOpen() {
		return this.open;
	}
	
	/*
	 * gedrag
	 */
	
	public void maakOpen() {
		this.open = true;
	}

	public void maakDicht() {
		this.open = false;
	}
/* 
	public void lol() {
		System.out.println("OwO");
	}
*/
}
