package domein;

import java.util.ArrayList;
import java.util.List;

public class DierenWinkel {
	//Klasse DierenWinkel weet NIET welke soorten huisdieren
		//er bestaan. Als we later een nieuw huisdier toevoegen,
		//of schrappen, moeten we geen letter code wijzigen in 
		//deze klasse => ideaal naar onderhoud toe
	
	private List<Huisdier> lijstHuisdieren;
	
	public DierenWinkel()
	{
		lijstHuisdieren = new ArrayList<>();
	}
	
	public void voegHuisdierToe (Huisdier dier)
	{
		if (dier != null)
			lijstHuisdieren.add(dier);
	}
	
	public String geefSpuitje(Huisdier dier)
	{
		return String.format("Awwwwww... dat doet pijn! %s", dier.maakGeluid());
	}
	
	public int geefAantalDieren() 
	{
		return lijstHuisdieren.size();
	}
	
	public Huisdier geefDierOpIndex(int index) 
	{
		if (index < 0 || index >= geefAantalDieren() )
			throw new IllegalArgumentException("geen dier gevonden op de gevraagde index");
		return lijstHuisdieren.get(index);
	}
	
	public String[] stelDierenVoor()
	{
		String[] voorstelling = new String[geefAantalDieren()];
		int index = 0;
		for (Huisdier dier : lijstHuisdieren)
		{
			voorstelling[index++] = 
					String.format("%s zegt %s", dier, dier.maakGeluid());
		}
		return voorstelling;
	}
}
