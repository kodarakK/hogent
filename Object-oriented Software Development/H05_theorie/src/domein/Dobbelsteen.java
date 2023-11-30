package domein;

import java.security.SecureRandom;

public class Dobbelsteen
{

	private int aantalOgen;

	private SecureRandom random;
	private static final int MAX = 6;

	public int getAantalOgen()
	{
		return this.aantalOgen;
	}

	public Dobbelsteen()
	{
		random = new SecureRandom();
	}

	public void rol()
	{
		aantalOgen = random.nextInt(1, MAX + 1);
	}
}
