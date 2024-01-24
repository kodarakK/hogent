package domein;

import static utils.Gang.DESSERT;
import static utils.Gang.HOOFDGERECHT;
import static utils.Gang.KOUD_VOORGERECHT;
import static utils.Gang.WARM_VOORGERECHT;

import java.util.ArrayList;
import java.util.List;

import dto.BestellingDTO;

public class DomeinController
{
	Bestelling huidigeBestelling;
	BestellingRepository br;
	List<BestellingDTO> bestellingDTOs;
	List<String> namenGerechten;
	int[] aantallen;
	
	public DomeinController()
	{
		br = new BestellingRepository();
	}
	
	public void voegBestellingToe(String naam, int aantalPersonen, String[] keuzes)
	{
		huidigeBestelling = new Bestelling(naam, aantalPersonen, keuzes);
	}
	
	public BestellingDTO geefInfoHuidigeBestelling()
	{
		return new BestellingDTO(huidigeBestelling.getNaam(), huidigeBestelling.getAantalPersonen(), huidigeBestelling.getKeuzes());
	}
	
	public List<BestellingDTO> geefBestellingenMetNaamTotEnMetLetter(char letter)
	{
		bestellingDTOs = new ArrayList<>();
		for (Bestelling b : br.geefBestellingenMetNaamTotEnMetLetter(letter)) {
			bestellingDTOs.add(new BestellingDTO(b.getNaam(), b.getAantalPersonen(), b.getKeuzes()));
		}

		return bestellingDTOs;
	}
	
	public List<String> geefAlleGerechtnamen()
	{
		namenGerechten = new ArrayList<>();
		for (String s : KOUD_VOORGERECHT.getGerechtnamen()) {
			namenGerechten.add(s);
		}

		for (String s : WARM_VOORGERECHT.getGerechtnamen()) {
			namenGerechten.add(s);
		}

		for (String s : HOOFDGERECHT.getGerechtnamen()) {
			namenGerechten.add(s);
		}

		for (String s : DESSERT.getGerechtnamen()) {
			namenGerechten.add(s);
		}

		return namenGerechten;
	}
	
	public int[] geefOverzichtAantallenGerechten()
	{
		aantallen = new int[geefAlleGerechtnamen().size()];

		int index = 0;
		for (String s : geefAlleGerechtnamen()) {
			
			aantallen[index++] = br.geefAantalBestellingenVanGerecht(s);	
				
		}

		return aantallen;
	}
}
