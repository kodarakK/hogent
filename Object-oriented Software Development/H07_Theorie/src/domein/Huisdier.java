package domein;

import java.security.SecureRandom;

public class Huisdier { // extends Object
//	superklasse

	private String naam;   // data is verborgen
	
	public static final int WAARDE = 10;
	
//	technisch attribuut
//	we willen niet per subklasse een securerandom object declareren en creëeren
//	protected: alle klassen in dezelfde package En de subklassen (al staan ze in een 
//	andere package)
	protected SecureRandom random;
	
	/*
	 * package toegankelijk: kan gebruikt worden in dezelfde package
	 */
	int getal;
	
	// voorbeeld
	protected void voorbeeldProtected() {
		
	}
	
	/*
	 * package toegankelijk: kan gebruikt worden in dezelfde package
	 */
	void voorbeeldPackage() {
		
	}

	public Huisdier(String naam)
	{
		// TODO Auto-generated constructor stub
//		default constructor van Object wodrd opgeroepen
//		super();
		setNaam(naam);
		random = new SecureRandom();
	}

	public String getNaam() 
	{
		return naam;
	}
	
	public final void setNaam(String naam) 
	{
		this.naam = naam;
	}
	
	
//	2de semester: abstracte klasse Huisdier	
//		Hierdoor kunnen we geen huisdier-object creëren
//		abstracte methode: public abstract String maakGeluid();
//		hierdoor verplichten we alle subklassen om maakGeluid() uit te werken
	
//	Ieder huisdier kan geluid maken
	public String maakGeluid(/*String geluid*/) 
	{
		return /*geluid*/ "!"; // TIJDELIJK
	}
	
//  zelfde code voor Hond en Kat
	public boolean luisterNaarNaam(String naam)
	{
//		lokale var naam
//		attr met param vgl
		return this.naam.equals(naam);
	}
	
	@Override
	public String toString() 
	{
		return String.format("%s met naam %s", this.getClass().getSimpleName(), naam);
	}
	
	//this.getClass().getSimpleName()
	//JAVA weet naar welk object je toString hebt gestuurd
	//in geval van Kat kat = new Kat("..."); 
	             //kat.toString() ==> Kat
	//Analoog voor de hond ==> Hond
	
	//getSimpleName(): geeft de naam van de klasse terug
}
