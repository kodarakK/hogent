package domein;

import utils.Kleur;

public class Bloem {

	private final String naam;
	private final Kleur kleur;
	
	public Bloem(String naam, Kleur kleur)
	{
		controleerNaam(naam);
		controleerKleur(kleur);
		this.naam = naam;
		this.kleur = kleur;
	}

	private void controleerNaam(String naam) {
		if (naam == null || naam.isBlank() || naam.length() < 2)
			throw new IllegalArgumentException();
	}
	
	private void controleerKleur(Kleur kleur) {
		throw new UnsupportedOperationException();
	}
	
	public String getNaam() {
		return naam;
	}

	public Kleur getKleur() {
		return kleur;
	}

    public boolean bloeitInLente()
    {
    	throw new UnsupportedOperationException();
    }
    

	
}
