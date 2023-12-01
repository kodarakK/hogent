package domein;

public class Huisdier {

	private String naam;
	
	public Huisdier(String naam)
	{
		setNaam(naam);
	}
	
	public String getNaam() {
		return naam;
	}

	public final void setNaam(String naam) {
		if (naam == null || naam.isBlank())
			throw new IllegalArgumentException("naam moet ingevuld worden");
		this.naam = naam;
	}
	
	public String maakGeluid() 
	{
		return "!";
	}
	
	public boolean luisterNaarNaam(String naam)
	{
		return naam.equals(this.naam);
	}
	
	@Override
	public String toString() 
	{
		return String.format("%s met naam %s", 
				this.getClass().getSimpleName(), naam);
	}
	
}
