package cui;

import java.util.Iterator;
import java.util.Scanner;

import domein.DomeinController;
import domein.Kapitaal;
import dto.KapitaalDTO;

public class KapitaalApplicatie {

	private DomeinController dc;
	private Scanner invoer = new Scanner(System.in);

	public KapitaalApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		dc.maakKapitaal(1000, 10);
		toonKapitaalsopbouw();
		int keuze = maakKeuze();
		while (keuze != 4) {
			switch (keuze) {
			case 1 -> wijzigStartkapitaal();
			case 2 -> wijzigIntrest();
			case 3 -> toonKapitaalsopbouw();
			}
			keuze = maakKeuze();
		}
		System.out.println("Tot een volgende keer!");
	}

	private int maakKeuze() {
		int keuze;
		do {
			System.out.printf("%n%n== MENU ==%n");
			System.out.println("1. Startkapitaal wijzigen");
			System.out.println("2. Intrest wijzigen");
			System.out.println("3. Overzicht kapitaalsopbouw tonen");
			System.out.println("4. Stoppen");
			System.out.print("Geef je keuze (1-4): ");
			keuze = invoer.nextInt();
		} while (keuze < 1 || keuze > 4);
		return keuze;
	}

	private void wijzigStartkapitaal() {
		System.out.printf("%nGeef het start kapitaal: ");
		double startkapitaal = invoer.nextDouble();
		dc.wijzigStartkapitaal(startkapitaal);
	}

	private void wijzigIntrest() {
		System.out.printf("%nGeef de intrestvoet [%.0f-%.0f]: ", Kapitaal.MIN_INTREST, Kapitaal.MAX_INTREST);
		double intrest = invoer.nextDouble();
		dc.wijzigIntrest(intrest);
	}

	private void toonKapitaalsopbouw() {
		//TODO
		KapitaalDTO kap = dc.geefKapitaal();
		System.out.printf("%nKapitaal %.2f Euro - Intrest %.2f%% %n%n", kap.bedrag(), kap.intrest());
		
		for (int i = 1; i <= 10; i++) {
			System.out.printf("Opgebouwd kapitaal na %d jaar: %.2f Euro%n", i, dc.geefOpgebouwdKapitaal(i));
		}
	}
}
