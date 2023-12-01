package domein;

import java.security.SecureRandom;

public class DomeinController {

	private DierenWinkel winkel;
	private SecureRandom random;
	
	public DomeinController() 
	{
		winkel = new DierenWinkel();
		random = new SecureRandom();
	}
	
	public void initialiseerDierenWinkel() {
		winkel.voegHuisdierToe(new Duif("Blauwe geschelpte", 20180000001L));
		winkel.voegHuisdierToe(new Kat("Minoe"));
		winkel.voegHuisdierToe(new Hond("Rex"));
		winkel.voegHuisdierToe(new Hond("Lassie"));
		winkel.voegHuisdierToe(new Duif("Witoog", 20199876543L));
		winkel.voegHuisdierToe(new Kat("Garfield"));
	}

	public String[] stelDierenVoor()
	{
		return winkel.stelDierenVoor();
	}

	public String geefSpuitjes() 
	{
		String uitvoer = "";
		for (int i=0; i<3; i++)
		{
			int aantalDieren = winkel.geefAantalDieren();
			int randomIndex = random.nextInt(aantalDieren);
			Huisdier patient = winkel.geefDierOpIndex(randomIndex);
			uitvoer += String.format("%s%n", winkel.geefSpuitje(patient));
		}
		return uitvoer;
	}
}
