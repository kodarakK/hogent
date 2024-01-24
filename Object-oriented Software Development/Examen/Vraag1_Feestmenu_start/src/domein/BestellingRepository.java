package domein;

import java.util.ArrayList;
import java.util.List;

import persistentie.BestellingMapper;

public class BestellingRepository
{
	private final BestellingMapper bm;
	private final List<Bestelling> bestellingen;
	
	public BestellingRepository()
	{
		bm = new BestellingMapper();
		bestellingen = bm.geefBestellingen();
	}
	
	public void voegBestellingToe(Bestelling b)
	{
		bestellingen.add(b);
	}
	
	public List<Bestelling> geefBestellingenMetNaamTotEnMetLetter(char letter)
	{
		List<Bestelling> bestMetNaam = new ArrayList<>();
		for (Bestelling b : bestellingen) {
			if (b.getNaam().toUpperCase().charAt(0) >= 64 && b.getNaam().toUpperCase().charAt(0) <= letter)
				bestMetNaam.add(b);
		}

		return bestMetNaam;
	}
	
	public int geefAantalBestellingenVanGerecht(String gerechtnaam)
	{
		int aantal = 0;
		for (Bestelling b : bestellingen) {
			if (b.geefGerechtnamen().contains(gerechtnaam)) {
				aantal++;
			}
		}

		return aantal;
	}
}