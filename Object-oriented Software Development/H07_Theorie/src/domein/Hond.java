package domein;

public class Hond extends Huisdier
// subklasse
// ervan van Huisdier => overerving
// is-een relatie: Hond is een Huidier
// We kunnen maar erven van 1 klasse!

{
//	private String naam;
//
	public Hond(String naam)
	{
//		default constructor van superklasse operoepen
//		super(); moet als EERSTE staan
		super(naam); 
//		setNaam(naam);
	}
//	
//	public String getNaam() 
//	{
//		return naam;
//	}
//	
//	public final void setNaam(String naam) 
//	{
//		this.naam = naam;
//	}
	
//	methode maakGeluid is overgeschreven
	
	@Override // MAG, moet niet
	public String maakGeluid() 
	{
//		return "waf waf";
//		klasse hond: maakGeluid()
//		klasse Huisdier: maakGeluid()
		
//		super.maakGeluid() roepen we de methode maakGeluid() 
//		van Huisdier
		return String.format("waf waf%s", super.maakGeluid());
	}
////	
//	public boolean luisterNaarNaam(String naam)
//	{
//		return naam.equals(this.naam);
//	}
//	
//	
//	gespecialiseerd gedrag: enkel voor de Hond klasse
	public String kwispel()
	{
		return "kwispel-kwispel-kwispel";
	}
	
//	public String toString() 
//	{
//		return String.format("%s met naam %s", this.getClass().getSimpleName(), naam);
//	}
}