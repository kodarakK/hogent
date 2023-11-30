package cui;

import java.util.Scanner;
import domein.Rekenmachine;

public class RekenmachineApp
{
	private final static int SOM = 1;
	private final static int VERSCHIL = 2;
	private final static int VERMENIGVULDIG = 3;
	private final static int DELING = 4;
	private final static int STOPPEN = 5;
	
	private final static char SOM_CHAR = '+';
	private final static char VERSCHIL_CHAR = '-';
	private final static char VERMENIGVULDIG_CHAR = '*';
	private final static char DEEL_CHAR = '/';
	

	public static void main(String[] args)
	{
		new RekenmachineApp().start();

	}
	
	Scanner sc = new Scanner(System.in);

	private void start()
	{
		Rekenmachine rekenmachine = new Rekenmachine();
		int keuze = maakMenuKeuze();
		while (keuze != STOPPEN) {
			double getal1 = leesGetal("eerste");
			double getal2 = leesGetal("tweede");
			switch(keuze) {
				case SOM 			-> {
					rekenmachine.telOp(getal1, getal2);
					toonResultaat(getal1, getal2, SOM_CHAR, rekenmachine.getResultaat());
				}
				
				case VERSCHIL 		-> {
					rekenmachine.trekAf(getal1, getal2);
					toonResultaat(getal1, getal2, VERSCHIL_CHAR, rekenmachine.getResultaat());
				}
				
				case VERMENIGVULDIG -> {
					rekenmachine.vermenigvuldig(getal1, getal2);
					toonResultaat(getal1, getal2, VERMENIGVULDIG_CHAR, rekenmachine.getResultaat());
				}
				
				case DELING 		-> {
					rekenmachine.deel(getal1, getal2);
					toonResultaat(getal1, getal2, DEEL_CHAR, rekenmachine.getResultaat());
				}
			}
			keuze = maakMenuKeuze();
		}
	}
	
	private double leesGetal(String boodschap) {
		System.out.printf("Geef %s %s getal: ", boodschap=="eerste"?"het":"een", boodschap);		
		return sc.nextDouble();
		
		// error checking 2de semester
	}
	
	private void toonResultaat(double getal1, double getal2, char c, double resultaat) {
		System.out.printf("%.2f %c %.2f = %.2f %n%n", getal1, c, getal2, resultaat);
	}
	
	private int maakMenuKeuze() {
		int keuze;
		do
		{
			System.out.println("Welke actie wil je uitvoeren?");
			System.out.println("1. Som");
			System.out.println("2. Verschil");
			System.out.println("3. Vermenigvuldiging");
			System.out.println("4. Deling");
			System.out.println("5. Stoppen");
			System.out.print("Geef je keuze in: ");
			keuze = sc.nextInt();			
		} while (keuze > 5 || keuze < 1);
		return keuze;
	}

}
