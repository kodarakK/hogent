package cui;

import java.util.Scanner;

public class Oef11_GemGetallenMatrixApp {

		public static void main(String arg[]) {
			new Oef11_GemGetallenMatrixApp().start();
		}

		private Scanner invoer = new Scanner(System.in);
		
		private void start() {
			double getallenMatrix[][] = new double[3][2]; // 3 rijen, 2 kolommen

			// TODO 1 - Maak gebruik van de onderstaande methode geefElement
			// om een waarde op te vragen en toe te kennen aan elk element van
			// getallenMatrix.
			
			for (int rij = 0; rij < getallenMatrix.length; rij++) {
				for (int kolom = 0; kolom < getallenMatrix[rij].length; kolom++) {
					getallenMatrix[rij][kolom] = geefElement(getallenMatrix.length, getallenMatrix[rij].length);
				}
			}
			


			// TODO 2 - Maak gebruik van een enhanced for lus om alle elementen van
			// getallenMatrix te overlopen. Maak de som van alle getallen en
			// tel hoeveel getallen er in getallenMatrix zitten zodat je het
			// gemiddelde kan berekenen en uitvoeren naar de console.
			double som = 0.0;
			int aantal  = 0;
			
			for (double[] rij : getallenMatrix) {
				for (double getal : rij)
				{
					som += getal;
				}
				aantal += rij.length;
			}

		}

		private double geefElement(int rij, int kolom) {
			System.out.printf("Geef getal op rij %d en kolom %d: ", rij, kolom);
			return invoer.nextDouble();
		}
}