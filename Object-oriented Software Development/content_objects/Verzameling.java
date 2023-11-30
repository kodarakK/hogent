package domein;

import java.security.SecureRandom;

public class Verzameling {

	private boolean plaatje1;
	private boolean plaatje2;
	private boolean plaatje3;
	private boolean plaatje4;
	private boolean plaatje5;
	private boolean plaatje6;
	
	private SecureRandom random = new SecureRandom();
	
	public int simuleerVerzamelingCompleet()
	{
		int aantal = 0;
		do {
			int nrPlaatje = random.nextInt(6) + 1; //geeft een
			//random getal terug tussen 1 en 6, grenzen inbegrepen
			
			aantal++;
			
			switch(nrPlaatje)
			{
			case 1 -> plaatje1 = true;
			case 2 -> plaatje2 = true;
			case 3 -> plaatje3 = true;
			case 4 -> plaatje4 = true;
			case 5 -> plaatje5 = true;
			case 6 -> plaatje6 = true;
			}
		}while (!compleet());
		return aantal;
	}
	
	public boolean compleet()
	{
		return (plaatje1 && plaatje2 && plaatje3 
				&& plaatje4 && plaatje5 && plaatje6);
		
	}
}
