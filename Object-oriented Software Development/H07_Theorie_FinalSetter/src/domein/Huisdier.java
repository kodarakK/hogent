package domein;

public class Huisdier {

	private String naam;
	
	private final static int DEF_GET = 0;
	
	public Huisdier(String naam)
	{
		setNaam(naam);
	}
	
	public String getNaam() {
		return naam;
	}
	
	public final void voorbeeldDoing() {
		
	}
	
	public final int voorbeeldKnowing() {
		return DEF_GET;
	}

	/*Als een methode final is, kan ze bij overerving 
	  niet meer gewijzigd worden. 
	
	  De setter is verantwoordelijk
	  om een juiste waarde in zijn attribuut te plaatsen.
	  Enkel de klasse die het attribuut bevat is hiervoor
	  verantwoordelijk, nooit een subklasse. 
	 */
	public final void setNaam(String naam) {
		if (naam == null || naam.isBlank())
			throw new IllegalArgumentException("naam moet ingevuld zijn");
		this.naam = naam;
	}
	
	public String maakGeluid() 
	{
		return "!";
	}
	
	@Override
	public String toString() 
	{
		return String.format("%s met naam %s", 
				this.getClass().getSimpleName(), naam);
	}
	
}
