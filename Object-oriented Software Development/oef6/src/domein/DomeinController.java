package domein;

import dto.VoorwerpDTO;

public class DomeinController
{
	
	private final VoorwerpRepository vr;

	public DomeinController()
	{
		vr = new VoorwerpRepository();
	}
	
	public VoorwerpDTO[] geefVoorwerpDTOs() {
		VoorwerpDTO[] voorwerpen = new VoorwerpDTO[vr.getVoorwerpen().size()];
		
		
		int index = 0;
		
		for (Voorwerp voorwerp : vr.getVoorwerpen())
		{
			if (voorwerp instanceof Wapen wapen)
			{
				voorwerpen[index++] = new VoorwerpDTO(
						voorwerp.getNaam(), 
						voorwerp.getGewicht(), 
						voorwerp.getNiveau(), 
						wapen.getKracht(), 
						wapen.isGebruikt());
			}
			
			if (voorwerp instanceof Sleutel sleutel)
			{
				voorwerpen[index++] = new VoorwerpDTO(
						voorwerp.getNaam(), 
						voorwerp.getGewicht(), 
						voorwerp.getNiveau(), 
						Sleutel.getAantalInOmloop(), 
						sleutel.getDeur());
			}
		}
		
		return voorwerpen;
	}
	
	public void voegWapenToe(String naam, double gewicht, int niveau, int kracht, boolean gebruikt) {
		vr.voegVoorwerpToe(new Wapen(naam, gewicht, niveau, kracht, gebruikt));
	}
	

	public void voegSleutelToe(String naam, double gewicht, int niveau, int deur) {
		vr.voegVoorwerpToe(new Sleutel(naam, gewicht, niveau, deur));

	}
	
}
