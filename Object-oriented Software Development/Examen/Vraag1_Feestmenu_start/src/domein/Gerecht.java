package domein;

import utils.Gang;

public class Gerecht
{
	private String naam;
	private Gang gang;
	
	public Gerecht(String naam, Gang gang)
	{
		this.naam = naam;
		this.gang = gang;
	}

	public String getNaam() { return naam; }
	public Gang getGang() { return gang; }
}
