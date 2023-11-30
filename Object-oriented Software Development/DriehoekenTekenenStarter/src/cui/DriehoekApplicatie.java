package cui;

import java.util.Scanner;

import domein.DomeinController;
import domein.Driehoek;
import domein.Orientatie;

public class DriehoekApplicatie {
	
	private static final String[] HOOFDMENU_OPTIES = { "Grootte wijzigen", "Teken wijzigen", "Orientatie wijzigen",
			"Driehoek tekenen", "Stoppen" };
	private static final String[] ORIENTATIE_OPTIES = init_Orientatie_Opties();
	
	private static final Scanner invoer = new Scanner(System.in);
	private DomeinController dc;

	private static final int MAX_GROOTE_VORM = 20;
	private static final int MIN_GROOTE_VORM = 0;

	public DriehoekApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	private static String[] init_Orientatie_Opties() {
		// TODO
		String[] temp = new String[Orientatie.values().length];
		
		int index = 0;
		for (Orientatie or : Orientatie.values()) {
			temp[index] = or.toString();
			index++;
		}
		
		return temp;
	}

	public void start() {
		int keuze = maakMenuKeuze(HOOFDMENU_OPTIES, "MENU");
		while (keuze != 5) {
			switch (keuze) {
			case 1 -> dc.wijzigGrootte(voerGrootteIn());
			case 2 -> dc.wijzigTeken(voerTekenIn());
			case 3 -> dc.wijzigOrientatie(voerOrientatieIn());
			case 4 -> tekenDriehoek();
			}
			keuze = maakMenuKeuze(HOOFDMENU_OPTIES, "MENU");
		}
		System.out.printf("%nTot een volgende keer!");
	}

	private int voerGrootteIn() {
		int getal;
		boolean condition;
		
		do
		{
			System.out.printf("Geef de grootte voor de vorm, zorg dat deze tussen %d en %d ligt: ", MIN_GROOTE_VORM, MAX_GROOTE_VORM);
			getal = invoer.nextInt();
			condition = getal > MAX_GROOTE_VORM || getal < MIN_GROOTE_VORM;
			if (condition) System.out.println("Deze grootte ligt buiten de toegestane grenzen, probeer nogmaals...");
		} while (condition);
		
		return getal;
	}

	private int voerOrientatieIn() {
		//TODO	
		System.out.println("Positie recht hoek");
		
		for (int i = 0; i < ORIENTATIE_OPTIES.length; i++)
		{
			System.out.println(ORIENTATIE_OPTIES[i]);
		}
		
		System.out.print("Jouw keuze: ");
		
		return invoer.nextInt();
	}

	private char voerTekenIn() {
		char teken;
		boolean geldig;
		do {
			System.out.printf("%nDe geldige tekens zijn %s%n", Driehoek.TOEGESTANE_TEKENS);
			System.out.print("Geef het teken voor de vorm: ");
			teken = invoer.next().charAt(0);
			geldig = Driehoek.TOEGESTANE_TEKENS.indexOf(teken) != -1;
			if (!geldig)
				System.out.println("Dit is geen geldig teken, probeer nogmaals...");
		} while (!geldig);
		return teken;
	}

	private void tekenDriehoek() {
		System.out.printf("%n%s", dc.geefVorm());
	}

	private static int maakMenuKeuze(String[] keuzes, String hoofding) {
		int keuze = 0;
		do {
			System.out.printf("%n%s%n", hoofding);
			for (int i = 0; i < keuzes.length; i++) {
				System.out.printf("%d. %s%n", i + 1, keuzes[i]);
			}
			System.out.print("Jouw keuze: ");
			keuze = invoer.nextInt();
		} while (keuze < 1 || keuze > keuzes.length);
		return keuze;
	}
}
