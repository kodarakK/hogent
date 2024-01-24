package cui;

import static utils.Gang.WARM_VOORGERECHT;

import java.util.Scanner;

import domein.Bestelling;
import domein.DomeinController;
import dto.BestellingDTO;
import utils.*;
public class BestellingApplicatie
{
	private final DomeinController dc;
	private final Scanner s = new Scanner(System.in);
	
	public BestellingApplicatie(DomeinController dc)
	{
		this.dc = dc;
	}

	public void organiseerBestellingen()
	{
		String[] hoofdmenu = {"Voer bestelling in", "Toon bestellingen tot en met letter", "Toon overzicht te bereiden gerechten", "Stop"};
		int keuze = kies(hoofdmenu);
		while (keuze != hoofdmenu.length)
		{
			switch (keuze)
			{
				case 1 -> voerBestellingIn();
				case 2 -> toonBestellingenTotEnMetLetter();
				default -> toonOverzicht();
			}
			keuze = kies(hoofdmenu);
		}
	}
	
	private int kies(String[] mogelijkheden)
	{
		int keuze;
		for (int i=1; i<=mogelijkheden.length; i++)
			System.out.printf("%d. %s%n", i, mogelijkheden[i-1]);
		do
		{
			System.out.printf("Geef je keuze [%d, %d]: ", 1, mogelijkheden.length);
			keuze = s.nextInt();
		}
		while (keuze < 1 || keuze > mogelijkheden.length);
		return keuze;
	}
	
	private String geefNaam()
	{
		System.out.print("Op welke (familie)naam bestel je? ");
		return s.nextLine();
	}
	
	private int geefAantalPersonen()
	{
		System.out.print("Voor hoeveel personen bestel je? ");
		return s.nextInt();
	}

	private int geefAantalGangen() 
	{
		int keuze;
		do {
			System.out.print("Uit hoeveel gangen bestaat je menu? ");
			keuze = s.nextInt();
		} while(keuze != 3 || keuze != 4);

		return keuze;
	}
	
	private void voerBestellingIn()
	{
		int aantalGangen = geefAantalGangen();
		String[] keuzes = new String[aantalGangen];

		int index = 0;
		if (aantalGangen == 4)
		{
			for (Gang g : Gang.values()) {
				System.out.printf("%n%s gerecht: ", g);
				keuzes[index++] = s.next();
			}
		}
		if (aantalGangen == 3)
		{
			for (Gang g : Gang.values()) {
				if (g.equals(WARM_VOORGERECHT))
					continue;
				System.out.println("gerecht: ");
				keuzes[index++] = s.next();
			}
		}
		Bestelling b = new Bestelling(geefNaam(), geefAantalPersonen(), keuzes);
		dc.voegBestellingToe(geefNaam(), geefAantalPersonen(), keuzes);
		toonBestelling(new BestellingDTO(b.getNaam(), b.getAantalPersonen(), b.getKeuzes()));
	}



	private void toonBestelling(BestellingDTO dto) 
	{
		System.out.printf("Bestelling op naam van %s: %n%d personen%n", dto.naam(), dto.aantalPersonen());

		for (String s : dto.keuzes()) {
			System.out.println(s);
		}

	}

	private void toonBestellingenTotEnMetLetter()
	{
		char letter = geefLetter();
		for (BestellingDTO dto : dc.geefBestellingenMetNaamTotEnMetLetter(letter)) {
			toonBestelling(dto);
		}
	}

	private char geefLetter() 
	{
		char letter;
		do {
		System.out.print("geef een (hoofd) letter");
		letter = s.next().charAt(0);
		}while (letter < 64 || letter > 64+26);

		return letter;
	}

	private void toonOverzicht()
	{

	}
}