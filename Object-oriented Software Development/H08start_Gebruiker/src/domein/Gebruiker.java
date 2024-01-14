package domein;

public class Gebruiker {
	private String gebruikersnaam;

	public Gebruiker(String gebruikersnaam) {
		setGebruikersnaam(gebruikersnaam);
	}

	public String getGebruikersnaam() {
		return gebruikersnaam;
	}

	private void setGebruikersnaam(String gebruikersnaam) {
		if (gebruikersnaam == null)
			throw new IllegalArgumentException("Je moet een gebruikersnaam opgeven");
		if (gebruikersnaam.length() < 6)
			throw new IllegalArgumentException("De naam moet minstens 6 tekens bevatten");
		
		int indexPunt = gebruikersnaam.indexOf('.');
		if (indexPunt == -1)
			throw new IllegalArgumentException("De naam moet minstens een punt bevatten");
		if (indexPunt == 0 || gebruikersnaam.lastIndexOf('.') == gebruikersnaam.length() - 1)
			throw new IllegalArgumentException("De gebruikersnaam mag niet beginnnen of eindigen met een punt");
		if (gebruikersnaam.indexOf(' ') != -1)
			throw new IllegalArgumentException("De naam mag geen spaties bevatten");

		this.gebruikersnaam = gebruikersnaam;
	}

}