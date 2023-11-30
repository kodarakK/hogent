package domein;

import java.util.*;

public class SpelerRepository {

	private List<Speler> spelers;
	

	public List<Speler> getSpelers()
	{
		return spelers;
	}

	public SpelerRepository() {
		spelers = new ArrayList<>();
	}

	public void voegSpelerToe(Speler speler) {
		if (geefSpeler(speler.getEmail()) == null)
			spelers.add(speler);
	}

	public Speler geefSpeler(String email) {
		for(Speler speler : spelers)
			if (speler.getEmail().equalsIgnoreCase(email))
				return speler;
		return null;
	}
	
}