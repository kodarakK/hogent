//package domein;
//
//	public Tuincentrum() 
//	{
//		plantMapper = new PlantMapper();
//		this.planten = plantMapper.geefPlanten();
//	}
//
//	public void voegPlantToe(Plant plant) 
//	{ 
//		boolean contains = false;
//		for (Plant currPlant: planten) {
//			if (!contains&&currPlant.getNaam()==plant.getNaam()) {
//				contains = true;
//				currPlant.setAantalInVoorraad(currPlant.getAantalInVoorraad()+plant.getAantalInVoorraad());
//			}
//		}
//	}
//
//	public List<Plant> getPlanten() {
//		return planten;
//	}
//
//	public int[] maakOverzichtPlantenPerHoogte(){
//		int[] count = new int[3];
//		for(Plant plant : planten){
//			int height = plant.getHoogteInCm();
//			count[height<=80?0:(height>100?2:1)]++;
//		}
//		return count;
//	}
//	
//	
//
//	public double bepaalWaardeVerkoop() {
//		double total = 0;
//		for (Plant plant : planten){
//			total += plant.berekenVerkoopprijs()*plant.getAantalInVoorraad();
//		}
//		return total;
//	}
//
//	//TODO geefPlanten
//	public List<Plant> geefPlanten(boolean inVoorraad){
//		if (!inVoorraad) return planten;
//
//		List<Plant> retList = new ArrayList<>();
//		for (Plant plant : planten) if(plant.getAantalInVoorraad()!=0) retList.add(plant);
//		return retList;
//	}
//	
//	
//	
//
//}


//package domein;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import persistentie.PlantMapper;


//
//public class Tuincentrum 
//{
//	private List<Plant> planten;
//	List<Plant> enkelInVoorraad = new ArrayList<>();
//	private final PlantMapper plantMapper;
//
//	public Tuincentrum() 
//	{
//		plantMapper = new PlantMapper();
//		this.planten = plantMapper.geefPlanten();
//	}
//
////	public void voegPlantToe(Plant plant) 
////	{ 
////		boolean IN = false;
////		int teller = 0;
////		int index = 0;
////		for (Plant p : planten)
////		{
////			System.out.printf("%s ---- %s%n", p.getNaam().toLowerCase(), plant.getNaam().toLowerCase());
////			if (!IN && p.getNaam().toLowerCase().equals(plant.getNaam().toLowerCase()))
////			{
////				System.out.println("truuu");
////				p.setaan
////				IN = true;
////				index = teller;
////			}
////			teller++;
////		}
////		
////		if (!IN) 
////		{
////			planten.get(index).setAantalInVoorraad(
////				planten.get(index).getAantalInVoorraad() + plant.getAantalInVoorraad());
////		}	else 
////		{
////			planten.add(plant);
////		}
//		
//		
//		
//		
////		for (int index = 0; index < planten.size(); index++)
////		{
////			System.out.printf("%s %n", planten.get(index).getNaam());
//////			if (planten.get(index).getNaam() == plant.getNaam())
//////				planten.get(index).setAantalInVoorraad(
//////						planten.get(index).getAantalInVoorraad() + plant.getAantalInVoorraad());
//////			else
//////				planten.add(plant);
////		}
////		System.out.printf("%s%n", plant.getNaam());
		
//	}
	
	public void voegPlantToe(Plant plant) 
	{ 
		boolean contains = false;
		for (Plant currPlant: planten) {
			if (!contains&&currPlant.getNaam()==plant.getNaam()) {
				contains = true;
				currPlant.setAantalInVoorraad(currPlant.getAantalInVoorraad()+plant.getAantalInVoorraad());
			}
		}
	}

	public List<Plant> getPlanten() {
		return planten;
	}

	
	
	
	
	
	
	
	public int[] maakOverzichtPlanten() {
		int[] uitvoerList = new int[3];

		for (Plant p : planten) {
			if (p.getHoogteInCm() < 80) 
				uitvoerList[0] += 1;
			else if (p.getHoogteInCm() > 100)
				uitvoerList[2] += 1;
			else 
				uitvoerList[1] += 1;
		}

		return uitvoerList;

	}
	
	

	public double bepaalWaardeVerkoop() {
        double totaal = 0;

        for (Plant p : planten) 
            totaal += p.getPrijsInEuro();
		
		return totaal;
	}

	
	public List<Plant> geefPlanten(boolean inVoorraad) {
		enkelInVoorraad = new ArrayList<>();
		for (Plant p : planten) {
			if (p.getAantalInVoorraad() == 0)
				continue;
			else 
				enkelInVoorraad.add(p);
		}
		
		return inVoorraad?enkelInVoorraad:planten;
		
////		if (inVoorraad) {
////            for (Plant p : this.planten) {
////                if (p.getAantalInVoorraad() > 0) {
////                	System.out.printf("%d%n", p.getAantalInVoorraad());
////                	enkelInVoorraad.add(p);
////                }
////            }
////            return enkelInVoorraad;
//
//        }
//        else 
//            return getPlanten();
	}
}	
//