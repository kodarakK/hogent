package cui;

import java.util.Scanner;

import domein.DomeinController;
import domein.Plant;
import dto.PlantDTO;

public class TuincentrumApplicatie 
{
	private final DomeinController dc;
	
	private Scanner input = new Scanner(System.in);

	public TuincentrumApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void start() 
	{
		String[] menuKeuzes = {"Toon overzicht alle planten", "Toon overzicht voorradige planten","Voeg plant toe","Geef overzicht per hoogte",  "Geef verkoopwaarde", "Stoppen"};
		int keuze = maakMenuKeuze(menuKeuzes,"Wat kies je? ");
	
		while (keuze != 6)
		{
			switch(keuze) {
				case 1 -> geefPlantenInVoorraad(false);
				case 2 -> geefPlantenInVoorraad(true);
				case 3 -> voegPlantToe();
				case 4 -> maakOverzichtPlantenPerHoogte();
				case 5 -> System.out.printf("De verkoopwaarde van de stock in EUR: %.2f%n", dc.bepaalWaardeVerkoop());
			}
			keuze = maakMenuKeuze(menuKeuzes,"Wat kies je? ");
		} 
			
	}
	
	private int maakMenuKeuze(String[] keuzes, String hoofding) 
	{
		int keuze;
		boolean geldig = false;
		do 
		{
			System.out.printf("%n%s", hoofding);
			for (int i = 0; i < 6; i++)
				System.out.printf("%n%d. %s", i + 1, keuzes[i]);
			System.out.print("\nJouw keuze: ");
			keuze = input.nextInt();
			if (keuze >= 1 || keuze < 7) 
				geldig = true;
			else
				geldig = false;
		}while (!geldig);
		
		return keuze;
	}
	

	private void voegPlantToe()
	{
		dc.voegPlantToe(geefString("Geef de naam"), (char)geefString("Geef de soortcode (A, B of C)"),
				geefInt("Geef de hoogte in cm"), geefDouble("Geef de prijs in EUR"), geefInt("Hoeveel in voorraad"));
		
	}
	
	Scanner sc = new Scanner(System.in);
	private String geefString(String heading) {
		System.out.printf("%c", 65);
		System.out.printf("%s: ", heading);
		return sc.nextLine();
	}
	
	private int geefInt(String heading) 
	{
		System.out.printf("%s: ", heading);
		return sc.nextInt();
	}
	
	private double geefDouble(String heading) 
	{
		System.out.printf("%s: ", heading);
		return sc.nextDouble();
	}
	
	
	// Bepaal aantal planten tss 0-80cm, 80cm-1m, groter dan 1 m
	private void maakOverzichtPlantenPerHoogte()
	{
		int[] overzicht = dc.maakOverzichtPlantenPerHoogte();
		System.out.printf("%20s%20s%20s\n%20d%20d%20d",
				"kleiner dan 80 cm", "80 - 100 cm", "groter dan 1 m",
				overzicht[0], overzicht[1], overzicht[2]);
	}
	
	private void geefPlantenInVoorraad(boolean inVoorraad)
	{
		for (PlantDTO p : dc.geefAllePlanten(inVoorraad))
		{
			System.out.printf("%S met code %s, %d cm hoog, kost EUR %.2f: %d in voorraad%n",
					p.naam(), p.soortCode(), p.hoogteInCm(), p.prijsInEuro(), p.aantalInVoorraad());
		}
	}
	
	
	
	
}
