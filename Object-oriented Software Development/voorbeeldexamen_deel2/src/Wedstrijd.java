public class Wedstrijd
{

	private Spel spel;
	private String naamSpeler;
	private int aantalSpelletjes;
	private int scores;

	public String getNaamSpeler()
	{
		return this.naamSpeler;
	}

	public void setNaamSpeler(string value)
	{
		this.naamSpeler = value;
	}

	public int getAantalSpelletjes()
	{
		return this.aantalSpelletjes;
	}

	public void setAantalSpelletjes(int value)
	{
		this.aantalSpelletjes = value;
	}

	public int getScores()
	{
		return this.scores;
	}

	public Wedstrijd()
	{
		throw new UnsupportedOperationException();
	}

	public int geefKeuzeComputer()
	{
		throw new UnsupportedOperationException();
	}

	public boolean geefWinnaarSpel()
	{
		throw new UnsupportedOperationException();
	}
}
