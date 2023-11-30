package cui;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Oef13_Inkomsten_Uitgaven
{

	public static void main(String[] args)
	{
		new Oef13_Inkomsten_Uitgaven().start();

	}

	private Scanner sc = new Scanner(System.in);

	private void start() {
		List<Double> inkomsten = new ArrayList<>();
		List<Double> uitgaven  = new ArrayList<>();

		double bedrag = geefBedrag();
		double totaalUitgaven = 0, totaalInkomsten = 0;

		while (bedrag != 0) {
			if (bedrag >= 1) {
				inkomsten.add(bedrag);
				totaalInkomsten += bedrag;
			} else if (bedrag <= -1) {
				uitgaven.add(bedrag * -1);
				totaalUitgaven += bedrag * -1;
			}

			bedrag = geefBedrag();
		}

		System.out.printf("%nInkomsten (totaal = %.2f)%n", totaalInkomsten);
		toonBedragen(inkomsten);


		System.out.printf("%nUitgaven (totaal = %.2f)%n", totaalUitgaven);
		toonBedragen(uitgaven);
	}

	private toonBedragen(List<Double> bedragen) {
		for (Double bedrag2Double : bedragen) {
			System.out.printf("%-8.2f", bedrag2Double);
		}
	}

	private double geefBedrag() {
		System.out.print("Geef een bedrag in (0 om te stoppen): ");
		return sc.nextDouble();
	}

}
