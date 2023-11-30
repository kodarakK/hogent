package domein;

public class DomeinController
{

	private Spel spel;

	public void startNieuwSpel()
	{
		spel = new Spel();
	}

	public void rolDobbelstenen()
	{
		spel.rolDobbelstenen();
	}

	public int geefAantalOgen()
	{
		return spel.geefAantalOgen();
	}

	public boolean isEindeSpel()
	{
		return spel.isEindeSpel();
	}

	public int geefScore()
	{
		return spel.getScore();
	}
}
