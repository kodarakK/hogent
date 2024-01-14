package domein;

public class Kat extends Huisdier{

	public Kat(String naam) {
		super(naam);
//		100% zeker dat de naam correct is
		setNaam(naam.toUpperCase());
	}
	
	/*
	 * final methode kunnen we niet overshccrijven
	@Override 
	public void voorbeeldDoing() {
		
	}
	
	@Override
	public int voorbeeldKnowing() {
		return 10;
	}*/

	
	//We mogen NOOIT een setter overschrijven
	//De validatie van de oorspronkelijke klasse
	//moet steeds worden uitgevoerd
//	public void setNaam(String naam) {
//		super.setNaam(naam.toUpperCase());
//	}

	@Override
	public String maakGeluid() {
		return String.format("miauw%s", 
				super.maakGeluid());
	}

	public String spin() {
		return String.format("%s spint", getNaam());
	}

	@Override
	public String toString() {
		return String.format("%s, %s", super.toString(), spin());
	}
}