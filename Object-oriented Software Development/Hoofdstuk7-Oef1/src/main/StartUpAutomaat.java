package main;

import domein.Grijpkraan;
import domein.KauwgomAutomaat;

public class StartUpAutomaat 
{
	//KauwgomAutomaat en Grijpkraan uittesten
	public static void main(String[] args)
	{
		new StartUpAutomaat().start();		
	}
	
	public void start()
	{
		String resultaat;
		boolean gelukt;
		int aantalKeer = 10;
		
		KauwgomAutomaat k1 = new KauwgomAutomaat(200);	
		
		// 10 keer KauwgomAutomaat
		System.out.printf("%d keer aan de hendel draaien van een %s met %d ballen%n", 
				aantalKeer, k1.getClass().getSimpleName().toLowerCase(), k1.getAantalItems());
		draaiNKeer(k1, aantalKeer, true);

		// 10 keer Grijpkraan
		Grijpkraan g1 = new Grijpkraan(20);
		System.out.printf("%d keer aan de hendel draaien van een %s met %d ballen%n", aantalKeer, g1.getClass().getSimpleName().toLowerCase(), g1.getAantalItems());
		draaiNKeer(g1, aantalKeer);
		
		// zonder betalen
		gelukt = k1.draaiHendel();
		resultaat = gelukt ? "ge" : "mis";
		System.out.printf("Zonder te betalen... %slukt%n%n", resultaat);
		
		// munt teruggenomen
		k1.betaal();
		k1.neemMuntTerug();
		gelukt = k1.draaiHendel();
		resultaat = gelukt ? "ge" : "mis";
		System.out.printf("Munt teruggenomen... %slukt%n%n", resultaat);	
		
		// 2 keer zonder kauwgom er uit te nemen na eerste keer
		aantalKeer = 2;
		System.out.printf("%d pogingen, maar vergeten item er uit te nemen na de eerste...%n", aantalKeer);
		draaiNKeer(k1, aantalKeer, false);
		
		// 2 keer terwijl er maar 1 kauwgom meer in zit
		System.out.println("En als alle items op zijn...");
		KauwgomAutomaat k2 = new KauwgomAutomaat(1);
		draaiNKeer(k2, 2, true);
	}
	
	private void draaiNKeer(KauwgomAutomaat k, int n, boolean neem)
	{
		boolean gelukt;
		
		for (int i=1; i<=n; i++)
		{
			k.betaal();
			gelukt = k.draaiHendel();
			System.out.printf("Poging %d: ", i);
			if (gelukt)
				System.out.printf("%s kauwgombal%n", k.bepaalKleur().name().toLowerCase());
			else  // mislukt
				if (k.isItemInBak()) // er zit nog een kauwgom in
					System.out.println("Kauwgombal zit er nog in!");
				else // er is geen kauwgom meer voorradig
					System.out.println("geen kauwgom meer!");
			if (neem) // ik neem de bal er uit als neem = true
				k.neemItem();
		}
		
		System.out.println();
	}

	private void draaiNKeer(Grijpkraan g, int n)
	{
		boolean gelukt;
		String resultaat; 
		
		for (int i=1; i<=n; i++)
		{
			g.betaal();
			gelukt = g.draaiHendel();
			resultaat = gelukt ? "" : "geen ";
			System.out.printf("Poging %d: %sprijs gewonnen%n", i, resultaat);
			if (gelukt) // we moeten er alleen iets uitnemen als er iets uit gekomen is!
				g.neemItem();
		}
		
		System.out.println();
	}
}	