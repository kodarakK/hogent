package cui;

import java.util.Scanner;

import domein.Tankstation;

public class TankstationApp {

	public static void main(String[] args) {
		new TankstationApp().startTanken();
	}
	
	private Scanner sc = new Scanner(System.in);
	private static final int MAX_AANTAL_POMPEN = 5;
	private static final int MIN_AANTAL_POMPEN = 0;
	private static final int MAX_AANTAL_LITER = 80;
	private static final int MIN_AANTAL_LITER = 5;
	private static final int STOP = 0;
	private Tankstation ts = new Tankstation();

	private void startTanken() {
		int aantalTankBeurten = 0, totaalAantalLiter = 0;
		int pompNummer = geefPompNummer();
		
		while (pompNummer != 0) {
			int aantalLiter = geefAantalLiter();
			if (ts.tank(pompNummer-1, aantalLiter)) {
				System.out.printf("Je hebt %d liter getankt aan pomp %d.%n%n", aantalLiter, pompNummer);
				aantalTankBeurten++;
				totaalAantalLiter += aantalLiter;
			} else {
				System.out.printf("Sorry, er is onvoldoende brandstof aan pomp %d%n%n", pompNummer);
			}
			
			System.out.println("\nOverzicht pompen:\n");
			System.out.println(ts.toString());

			pompNummer = geefPompNummer();
		}

		switch (aantalTankBeurten) {
			case 0 -> {
				System.out.printf("Er waren geen tankbeurten:%n");
				System.out.println(ts.toString());
			}
			default -> System.out.printf("Er werd in totaal %d liter getankt in %d tankbeurt%s.%n", totaalAantalLiter, aantalTankBeurten, (aantalTankBeurten>1)?"en":"");
		}
	}

	private int geefAantalLiter() {
		int aantalLiter = 0;
		boolean niet_geldig;
		
		do
		{
			System.out.printf("Hoeveel liter wens je te tanken(%d-%d)? ", MIN_AANTAL_LITER, MAX_AANTAL_LITER);
			aantalLiter = sc.nextInt();
			
			niet_geldig = aantalLiter > MAX_AANTAL_LITER|| aantalLiter < MIN_AANTAL_LITER;
			
			if (niet_geldig) {
				System.out.printf("Je moet minstens %d en kan maximaal %d liter tanken...%n", MIN_AANTAL_LITER, MAX_AANTAL_LITER);
			}
		} while (niet_geldig);
		return aantalLiter;
	}

	private int geefPompNummer() {
		int nummer;
		boolean niet_geldig;
		do {
			System.out.printf("Aan welke pomp wil je tanken (%d-%d), druk %d om te stoppen? ", MIN_AANTAL_POMPEN+1, MAX_AANTAL_POMPEN, STOP);
			nummer = sc.nextInt();
			
			niet_geldig = nummer > MAX_AANTAL_POMPEN || nummer < MIN_AANTAL_POMPEN;
			
			if (niet_geldig) {
				System.out.printf("We hebben geen pomp met nummer %d! Probeer opnieuw...%n", nummer);
			}
		} while(niet_geldig);
		
		return nummer;
	}
}
