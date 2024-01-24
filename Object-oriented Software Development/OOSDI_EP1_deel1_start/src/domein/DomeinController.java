package domein;

import java.util.List;

import dto.PlantDTO;

public class DomeinController 
{
	private Tuincentrum tuincentrum;

	public DomeinController() {
		tuincentrum = new Tuincentrum();
	}

	public void voegPlantToe(String naam, char soortCode, int hoogteInCm, double prijsInEuro, int aantalInVoorraad) {
		tuincentrum.voegPlantToe(new Plant(naam, soortCode, hoogteInCm, prijsInEuro, aantalInVoorraad));
	}

	public PlantDTO[] geefAllePlanten(boolean inVoorraad) {
		List<Plant> planten = tuincentrum.geefPlanten(inVoorraad);
		PlantDTO[] plantDTO = new PlantDTO[planten.size()];

		int itt = 0;

		for (Plant plant : planten) {
			plantDTO[itt++] = new PlantDTO(plant.getNaam(), plant.getSoortCode(), plant.getHoogteInCm(), plant.getPrijsInEuro(), plant.getAantalInVoorraad());
		}

		return plantDTO;
	}

	
	public double bepaalWaardeVerkoop()
	{
		return tuincentrum.bepaalWaardeVerkoop();
	}

	public int[] maakOverzichtPlantenPerHoogte() 
	{
		return tuincentrum.maakOverzichtPlantenPerHoogte();
	}
}
//package domein;
//
//import domein.Tuincentrum;
//import domein.Plant;
//import dto.PlantDTO;
//
//
//public class DomeinController 
//{
//	private Tuincentrum tuincentrum;
//	private PlantDTO[] plantenDTOs;
//
//	public DomeinController() {
//        tuincentrum = new Tuincentrum();
//	}
//
//	public void voegPlantToe(String naam, char soortCode, int hoogteInCm, double prijsInEuro, int aantalInVoorraad) {
//        tuincentrum.voegPlantToe(new Plant(naam, soortCode, hoogteInCm, prijsInEuro, aantalInVoorraad));
//		
//	}
//
//	public PlantDTO[] geefAllePlanten(boolean inVoorraad) {
//		plantenDTOs = new PlantDTO[tuincentrum.geefPlanten(inVoorraad).size()];
//		int index = 0;
//		for (Plant p : tuincentrum.geefPlanten(inVoorraad))
//		{	
//			plantenDTOs[index++] = new PlantDTO(p.getNaam(), p.getSoortCode(), p.getHoogteInCm(),
//					p.getPrijsInEuro(), p.getAantalInVoorraad());
//			
//		}
//		return plantenDTOs;
//	}
//
//	
//	public double bepaalWaardeVerkoop()
//	{
//		double totaal = 0;
//		for (PlantDTO plantDTO : geefAllePlanten(true))
//		{
//			totaal += plantDTO.prijsInEuro();
//		}
//		return totaal;
//	}
//
//	public int[] maakOverzichtPlantenPerHoogte() 
//	{
//		return tuincentrum.maakOverzichtPlanten();
//	}
//
//}
