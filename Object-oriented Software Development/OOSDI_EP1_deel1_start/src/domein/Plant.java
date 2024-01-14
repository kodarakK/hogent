package domein;

public class Plant 
{
	private final String naam;
	private char soortCode;
	private int hoogteInCm;
	private int aantalInVoorraad;
	private double prijsInEuro;
	
	private final static int MIN_HOOGTE = 0;
	private final static int MAX_HOOGTE = 400;
	private final static int BTW_PERCENTAGE = 21;
	
	private final static int DEFAULT = 0;
	private final static int DEFAULT_HOOGTE = 100;
	
	
	public Plant(String naam, char soortCode) {
		this(naam, soortCode, DEFAULT_HOOGTE, DEFAULT, DEFAULT);
	}
	
	public Plant(String naam, char soortCode, int hoogteInCm, double prijsInEuro, int aantalInVoorraad)
	{
		super();
		// final
		controleerNaam(naam);
		this.naam  = naam;
		setSoortCode(soortCode);
		setHoogteInCm(hoogteInCm);
		setAantalInVoorraad(aantalInVoorraad);
		setPrijsInEuro(prijsInEuro);
		
	}
	
	private void setHoogteInCm(int hoogteInCm2)
	{
		if (hoogteInCm2 <= MIN_HOOGTE || hoogteInCm2 >= MAX_HOOGTE)
			throw new IllegalArgumentException(String.format("hoogte is strikt positief en kleiner dan %d.", MAX_HOOGTE));
		this.hoogteInCm = hoogteInCm2;
		
	}

	private void setSoortCode(char soortCode2)
	{
		if (soortCode2 < 64 || soortCode2 > 67)
			throw new IllegalArgumentException(String.format("code moet A, B of C zijn"));
		this.soortCode = soortCode2;
		
	}

	public int getAantalInVoorraad()
	{
		return aantalInVoorraad;
	}
	public void setAantalInVoorraad(int aantalInVoorraad)
	{
		if (aantalInVoorraad < 0)
			throw new IllegalArgumentException(String.format("aantal in voorraad moet positief zijn"));
		this.aantalInVoorraad = aantalInVoorraad;
	}
	public double getPrijsInEuro()
	{
		return prijsInEuro;
	}
	public void setPrijsInEuro(double prijsInEuro)
	{
		this.prijsInEuro = prijsInEuro;
	}
	public String getNaam()
	{
		return naam;
	}
	public char getSoortCode()
	{
		return soortCode;
	}
	public int getHoogteInCm()
	{
		return hoogteInCm;
	}
	
	/*
	 * gedrag
	 */
	
	public double berekenVerkoopprijs() {
		return prijsInEuro + prijsInEuro * BTW_PERCENTAGE / 100;
	}
	
	private void controleerNaam(String naam) {
		if (naam == null || naam.isBlank())
			throw new IllegalArgumentException(String.format("naam mag niet leeg zijn en ook niet uistluitend uit blancos zijn"));
	}
	
}
