package cui;
import java.util.Scanner;

import domein.Driehoek;
import domein.Rechthoek;

/*
 * while lus nodig en switch case i guess
 * 
 */

public class VormApplicatie
{
	private static final int RECHTHOEK = 1;
	private static final int DRIEHOEK = 2;
	
	public static void main(String[] args)
	{
		new VormApplicatie().start();
	}
	
	private Scanner sc = new Scanner(System.in);

	private void start()
	{
		// init
		int aantalVormen = 0;
		int aantalRechthoekenOpp = 0;
		int aantalRechthoekigeDriehoeken = 0;
		
		// invoer
		int keuze = geefKeuze();
		
		while(keuze != 0) {
			// verwerking
			switch(keuze) {
				case RECHTHOEK -> {
					
					double lengte =  geefRechHoek("lengte");
					double breedte = geefRechHoek("breedte");
					Rechthoek rechthoek = new Rechthoek(lengte, breedte);
					
					if (rechthoek.berekenOppervlakte() > 50) aantalRechthoekenOpp++;
				}
				case DRIEHOEK -> {
					int zijdeA = geefZijde('A');
					int zijdeB = geefZijde('B');
					int zijdeC = geefZijde('C');
					
					Driehoek driehoek = new Driehoek(zijdeA, zijdeB, zijdeC);
					if (driehoek.isRechthoekig()) aantalRechthoekigeDriehoeken++;
				}
			}
			aantalVormen++;
			
			
					
			// invoer
			keuze = geefKeuze();
		}
		// uitvoer
		System.out.printf("Totaal aantal vormen : %d%n", aantalVormen);
		System.out.printf("Aantal rechthoeken met opp > 50 : %d%n", aantalRechthoekenOpp);
		System.out.printf("Aantal rechthoekige driehoeken : %d%n", aantalRechthoekigeDriehoeken);
	}

	private int geefZijde(char c)
	{
		System.out.printf("Geef de lengte van de zijde %c : ", c);
		return sc.nextInt();
	}

	private double geefRechHoek(String string)
	{
		System.out.printf("Geef de %s van de rechthoek : ", string);
		return sc.nextDouble();
	}

	private int geefKeuze() 
	{
		int getal;
		
		do
		{
			System.err.print("Wil je nog graag een vorm ingeven (1=rechthoek, 2=driehoek, 0=stop): ");
			getal = sc.nextInt();
		} while (getal > 2 || getal < 0);
		
		return getal;
	}
}
