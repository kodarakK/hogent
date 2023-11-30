package cui;

import java.util.Scanner;

/**
 * Dit is een voorbeeld van een herhaling met teller uitgewerkt met een for!
 * 
 */
public class KlasgemiddeldeTellerFOR
{
    public static void main(String args[])
    {    	
    	new KlasgemiddeldeTellerFOR().berekenKlasgemiddelde();
	}
			
	private void berekenKlasgemiddelde()
	{
        //declaratie lokale variabelen
    	int totaal, punt, klasGemiddelde;
        Scanner input = new Scanner(System.in);
        
        //initialisatie variabelen
        totaal = 0;
        
        //blijf herhalen tot...
        for (int puntenTeller = 1; puntenTeller <= 10; puntenTeller++)
        {
            System.out.print("Geef score " + puntenTeller + " (/20):");
            punt = input.nextInt();
            totaal += punt;   
        }
        
        klasGemiddelde = totaal / 10;
        
        // uitvoer
        System.out.printf("Het totaal is %d%n", totaal);
        System.out.printf("Het klasgemiddelde is %d%n", klasGemiddelde);
    }
}
