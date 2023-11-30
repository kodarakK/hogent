package cui;

import java.util.Scanner;

public class Voorbeeld_switch_statement
{
	public static void main(String[] args)
	{
		new Voorbeeld_switch_statement().gebruik_switch();
	}
	
	private void gebruik_switch()
	{
		Scanner input = new Scanner(System.in);
		
		// tag::voorbeeld1_switch[]
		System.out.print("Geef uw keuze in: ");
		int keuze = input.nextInt();
		switch (keuze)
		{
			case 1 -> System.out.println("Keuze 1! Je hebt gekozen om op te tellen.");
			case 2 -> System.out.println("Keuze 2! Je hebt gekozen om te delen.");
			case 3 -> System.out.println("Keuze 3! Je hebt gekozen om af te trekken.");
			default -> System.out.println("Foutieve keuze!");
		}
		// end::voorbeeld1_switch[]
		
		// tag::voorbeeld1_if_else[]
		if (keuze == 1)
			System.out.println("Keuze 1! Je hebt gekozen om op te tellen.");
			else 
				if (keuze == 2)
					System.out.println("Keuze 2! Je hebt gekozen om te delen.");
				else 
					if (keuze == 3)
						System.out.println("Keuze 3! Je hebt gekozen om af te trekken.");
					else
						System.out.println("Foutieve keuze!");

		// end::voorbeeld1_if_else[]
		
		// tag::voorbeeld2[]
		String stad = "Gent";
		switch (stad.charAt(0)) // eerste karakter van de String stad
		{
			case 'A' -> System.out.println("Antwerpen");
			case 'G' -> System.out.println("Gent");
			case 'B' -> System.out.println("Brugge");
		}
		// end::voorbeeld2[]
		
		// tag::voorbeeld1_switch_expressie[]
		System.out.print("Geef uw keuze in: ");
		int bewerking = input.nextInt();
		System.out.println(
			switch (bewerking)
			{
				case 1 -> "Keuze 1! Je hebt gekozen om op te tellen.";
				case 2 -> "Keuze 2! Je hebt gekozen om te delen.";
				case 3 -> "Keuze 3! Je hebt gekozen om af te trekken.";
				default -> "Foutieve keuze!";
			}
		);
		// end::voorbeeld1_switch_expressie[]
	}
}
