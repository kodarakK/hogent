package domein;

import utils.Kleur;

// afspraak: geen validatie
public class KauwgomAutomaat extends Automaat
{
	public KauwgomAutomaat(int aantalBallen) {
//		super();
		super(aantalBallen);
	}
	
	public String bepaalKleur() {
		return Kleur.values()[random.nextInt(Kleur.values().length)].name().toLowerCase();
	}
		
	
}
