package domein;

import java.util.ArrayList;
import java.util.List;
import static utils.Gang.*;
import domein.Gerecht;
import utils.Gang;

public class Bestelling
{
	private final String naam;
	private final int aantalPersonen;
	private String[] keuzes;
	private Gerecht[] gerechten;

	public Bestelling(String naam, int aantalPersonen, String[] keuzes) 
	{
		super();
		controleerNaam(naam);
		this.naam = naam;
		controleerAantalPersonen(aantalPersonen);
		this.aantalPersonen = aantalPersonen;
		controleerKeuzeGerechten(keuzes);
		setKeuzes(keuzes);

	}

	public int getAantalPersonen() {
		return aantalPersonen;
	}

	public String getNaam() {
		return naam;
	}

	public String[] getKeuzes() {
		return keuzes;
	}

	private void controleerNaam(String naam)
	{
		if (naam == null || naam.isBlank() || naam.length() < 5)
			throw new IllegalArgumentException(String.format("naam mag niet alleen uit spaties bestaan en moet minstens 5 karaters zijn", null));
	}

	private void controleerAantalPersonen(int aantalPersonen) 
	{
		if (aantalPersonen < 2)
			throw new IllegalArgumentException();
	}

	private void controleerKeuzeGerechten(String[] keuzes) 
	{
		
		if (keuzes.length == 0)
			throw new IllegalArgumentException(String.format("Keuze gerechten moet ingevuld zijn!"));
		
		if (keuzes.length != 3 ||keuzes.length != 4)
			throw new IllegalArgumentException(String.format("Onjuist aantal gangen!"));


		if (keuzes.length == 3){
			for (String k : keuzes) {

				if (!KOUD_VOORGERECHT.bevatGerecht(k))
					throw new IllegalArgumentException(String.format("%s kan niet gekozen worden als koud voorgerecht", k));
				
				if (!WARM_VOORGERECHT.bevatGerecht(k))
					throw new IllegalArgumentException(String.format("%s kan niet gekozen worden als warm voorgerecht", k));

				if (!HOOFDGERECHT.bevatGerecht(k))
					throw new IllegalArgumentException(String.format("%s kan niet gekozen worden als hoofdgerecht", k));
				
				if (!DESSERT.bevatGerecht(k))
					throw new IllegalArgumentException(String.format("%s kan niet gekozen worden als dessert", k));
			}
		}

		if (keuzes.length == 4){
			for (String k : keuzes) {
				if (!WARM_VOORGERECHT.bevatGerecht(k))
					throw new IllegalArgumentException(String.format("%s kan niet gekozen worden als warm voorgerecht", k));
			}
		}
	}

	public void setKeuzes(String[] keuzes) {
		gerechten = new Gerecht[keuzes.length];
		
		int index = 0;
		for (String s : keuzes) {

			for (Gang gang : Gang.values()) {
				if (gang.bevatGerecht(s))
					gerechten[index] = new Gerecht(s, gang);
			}

			// if (KOUD_VOORGERECHT.bevatGerecht(s))
			// 	gerechten[index] = new Gerecht(s, KOUD_VOORGERECHT);

			
			// if (WARM_VOORGERECHT.bevatGerecht(s))
			// 	gerechten[index] = new Gerecht(s, WARM_VOORGERECHT);

				
			// if (HOOFDGERECHT.bevatGerecht(s))
			// gerechten[index] = new Gerecht(s, HOOFDGERECHT);

			
			// if (DESSERT.bevatGerecht(s))
			// 	gerechten[index] = new Gerecht(s, DESSERT);
		}
	}

	public List<String> geefGerechtnamen() 
	{
		List<String> namen = new ArrayList<>();

		for (Gerecht gerecht : gerechten) {
			namen.add(gerecht.getNaam());
		}

		return namen;
	}

	public int geefAantalPersonenVoorGerecht(String gerechtnaam) 
	{
		
		for (String  s : geefGerechtnamen()) {
			if (s.equals(gerechtnaam))
			{
				return aantalPersonen;
			}		
		}
		return 0;
	}
	
	
}