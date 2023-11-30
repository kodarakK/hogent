package domein;

import java.security.SecureRandom;

public class Verzameling {
/*
	private boolean plaatje1;
	private boolean plaatje2;
	private boolean plaatje3;
	private boolean plaatje4;
	private boolean plaatje5;
	private boolean plaatje6;
	*/
	
	private final static int AANTAL_PLAATJES = 100;
	
	private boolean[] plaatjes = new boolean[AANTAL_PLAATJES];
	
	// AANTAL_PLAATJES x boolean  => alle AANTAL_PLAATJES = false
	
	
	private SecureRandom random = new SecureRandom();
	
	public int simuleerVerzamelingCompleet()
	{
		int aantal = 0;
		do {/*
			int nrPlaatje = random.nextInt(6) + 1; //geeft een
			//random getal terug tussen 1 en 6, grenzen inbegrepen
			*/
			int indexPlaatje = random.nextInt(AANTAL_PLAATJES);
			
			aantal++;
//			
//			switch(indexPlaatje)
//			{
//			case 1 -> plaatje1 = true;
//			case 2 -> plaatje2 = true;
//			case 3 -> plaatje3 = true;
//			case 4 -> plaatje4 = true;
//			case 5 -> plaatje5 = true;
//			case 6 -> plaatje6 = true;
//			}
			
			plaatjes[indexPlaatje] = true;
			
		}while (!compleet());
		return aantal;
	}
	
	public boolean compleet()
	{
		// array doorlopen :
		// 						enchanced for
		// 	type	 var(kueze) overwat
		
		for (boolean plaatje : plaatjes)
		{
			if (!plaatje) return false;
		}
		return true;		
	}
}
