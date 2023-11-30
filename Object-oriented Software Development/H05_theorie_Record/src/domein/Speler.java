package domein;

import java.math.BigDecimal;

public class Speler {

	private String naam;
	private String voornaam;
	private String email;
	private BigDecimal krediet;
	private boolean adminRechten;
	
	private static final String DEFAULTWAARDE = "onbekend";
	
	public Speler(String naam, String voornaam, String email) {
		super();
		setNaam(naam);
		setVoornaam(voornaam);
		setEmail(email);
		krediet = BigDecimal.valueOf(100);
	}

	public String getNaam() {
		return naam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public String getEmail() {
		return email;
	}

	public BigDecimal getKrediet() {
		return krediet;
	}

	public boolean isAdminRechten() {
		return adminRechten;
	}

	private void setNaam(String naam) {
		this.naam = (naam == null || naam.isBlank())? DEFAULTWAARDE: naam;
	}
	
	private void setVoornaam(String voornaam) {
		this.voornaam = (voornaam == null || voornaam.isBlank())? 
				DEFAULTWAARDE: voornaam;
	}
	
	private void setEmail(String email) {
		this.email = (email == null || email.isBlank() || !email.contains("@"))?
				DEFAULTWAARDE: email;
	}

}
