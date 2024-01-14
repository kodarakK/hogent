package domein;

import domein.Tuincentrum;
import domein.Plant;
import dto.PlantDTO;


public class DomeinController 
{
	private Tuincentrum tuincentrum;
	private PlantDTO[] plantenDTOs;

	public DomeinController() {
        tuincentrum = new Tuincentrum();
	}

	public void voegPlantToe(String naam, char soortCode, int hoogteInCm, double prijsInEuro, int aantalInVoorraad) {
        tuincentrum.voegPlantToe(new Plant(naam, soortCode, hoogteInCm, prijsInEuro, aantalInVoorraad));
		
	}

	public PlantDTO[] geefAllePlanten(boolean inVoorraad) {
		plantenDTOs = new PlantDTO[tuincentrum.geefPlanten(inVoorraad).size()];
		int index = 0;
		for (Plant p : tuincentrum.geefPlanten(inVoorraad))
		{	
			plantenDTOs[index++] = new PlantDTO(p.getNaam(), p.getSoortCode(), p.getHoogteInCm(),
					p.getPrijsInEuro(), p.getAantalInVoorraad());
			
		}
		return plantenDTOs;
	}

	
	public double bepaalWaardeVerkoop()
	{
		double totaal = 0;
		for (PlantDTO plantDTO : geefAllePlanten(true))
		{
			totaal += plantDTO.prijsInEuro();
		}
		return totaal;
	}

	public int[] maakOverzichtPlantenPerHoogte() 
	{
		return tuincentrum.maakOverzichtPlanten();
	}

}
