package cui;

import java.util.Scanner;

public class KlasgemiddeldeSchildwacht
{
	public static void main(String args[])
	{
		new KlasgemiddeldeSchildwacht().berekenKlasgemiddelde();
	}
			
	private void berekenKlasgemiddelde()
	{
		// declaratie lokale variabelen
		int totaal, puntenTeller, punt;
		double gemiddelde;

		// initialisatie variabelen
		totaal = 0;
		puntenTeller = 0;

		// verwerkingsfase
		punt = geefScore(); // <1>

		while (punt != -1) // <2>
		{
			totaal += punt;
			puntenTeller++;
			punt = geefScore(); // <3>
		}

		if (puntenTeller != 0) // <4>
		{
			gemiddelde = (double) totaal / puntenTeller;  // <5>
			System.out.printf("Het klasgemiddelde is %.2f%n", gemiddelde); // <6>
		} 
		else
			System.out.printf("Er werden geen punten ingegeven.%n");

	}
	
	private int geefScore() // <7>
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Geef score (/20) of -1 om te stoppen: "); 
		return input.nextInt();
	}
}
