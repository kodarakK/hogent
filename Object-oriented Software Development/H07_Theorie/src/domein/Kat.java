package domein;

public class Kat extends Huisdier {
	
//	private String naam;

	public Kat(String naam) {
		super(naam);
//		werkt niet meer omdat super() wordt opgeroepen
//		defaultconstructor in Huisdier bestaat niet
//		setNaam(naam);
	}

//	public String getNaam() {
//		return naam;
//	}
//
//	public final void setNaam(String naam) {
//		this.naam = naam;
//	}

	@Override // informatief
	public String maakGeluid() {
		return String.format("miauw%s", super.maakGeluid());
	}
//
//	public boolean luisterNaarNaam(String naam) {
//		return naam.equals(this.naam);
//	}


//	gespecialiseerd gedrag: enkel voor de Kat klasse
	public String spin() {
		int getal = random.nextInt();
		voorbeeldProtected();
		
//		super.getNaam() ==> meth heet "spin" en neit getNaam() dus geen conflicten
		return String.format("%s spint", getNaam());
	}

	@Override
	public String toString() {
//		doubele code
//		return String.format("%s met naam %s %s", this.getClass().getSimpleName(), getNaam(), spin());
		
		return String.format("%s %s", super.toString() /*super. is van moeten*/,
									  spin());
	}
}