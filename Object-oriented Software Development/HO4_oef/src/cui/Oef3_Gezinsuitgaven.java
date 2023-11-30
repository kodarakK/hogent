package cui;

import java.util.Scanner;

public class Oef3_Gezinsuitgaven {

	public static void main(String args[]) {
		new Oef3_Gezinsuitgaven().toonMaandenMetUitgavenBovenGemiddelde();
	}

	private Scanner sc = new Scanner(System.in);


	private void toonMaandenMetUitgavenBovenGemiddelde() {
//		double m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12;

		double[] uitgaven = new double[12];
/*
		System.out.print("Geef de uitgaven in voor maand 1: ");
		m1 = invoer.nextDouble();
		System.out.print("Geef de uitgaven in voor maand 2: ");
		m2 = invoer.nextDouble();
		System.out.print("Geef de uitgaven in voor maand 3: ");
		m3 = invoer.nextDouble();
		System.out.print("Geef de uitgaven in voor maand 4: ");
		m4 = invoer.nextDouble();
		System.out.print("Geef de uitgaven in voor maand 5: ");
		m5 = invoer.nextDouble();
		System.out.print("Geef de uitgaven in voor maand 6: ");
		m6 = invoer.nextDouble();
		System.out.print("Geef de uitgaven in voor maand 7: ");
		m7 = invoer.nextDouble();
		System.out.print("Geef de uitgaven in voor maand 8: ");
		m8 = invoer.nextDouble();
		System.out.print("Geef de uitgaven in voor maand 9: ");
		m9 = invoer.nextDouble();
		System.out.print("Geef de uitgaven in voor maand 10: ");
		m10 = invoer.nextDouble();
		System.out.print("Geef de uitgaven in voor maand 11: ");
		m11 = invoer.nextDouble();
		System.out.print("Geef de uitgaven in voor maand 12: ");
		m12 = invoer.nextDouble();
*/

		for (int index = 0; index < uitgaven.length; index++) {
			uitgaven[index] = geefUitgave(index+1);
		}

		double gem = 0;

		for (double uitgave : uitgaven) {
			gem += uitgave;
		}

		gem /= uitgaven.length;

		String result = "";

		for (int index = 0; index < uitgaven.length; index++) {

			if(uitgaven[index] > gem)
				result += String.format("%d ", index + 1);

		}






/*
		// double gem = (m1 + m2 + m3 + m4 + m5 + m6 + m7 + m8 + m9 + m10 + m11 + m12) / 12;

		// if (m1 > gem) {
		// 	result += "1 ";
		// }
		// if (m2 > gem) {
		// 	result += "2 ";
		// }
		// if (m3 > gem) {
		// 	result += "3 ";
		// }
		// if (m4 > gem) {
		// 	result += "4 ";
		// }
		// if (m5 > gem) {
		// 	result += "5 ";
		// }
		// if (m6 > gem) {
		// 	result += "6 ";
		// }
		// if (m7 > gem) {
		// 	result += "7 ";
		// }
		// if (m8 > gem) {
		// 	result += "8 ";
		// }
		// if (m9 > gem) {
		// 	result += "9 ";
		// }
		// if (m10 > gem) {
		// 	result += "10 ";
		// }
		// if (m11 > gem) {
		// 	result += "11 ";
		// }
		// if (m12 > gem) {
		// 	result += "12 ";
		// }

		if (!result.isEmpty()){
			System.out.printf("In de volgende maanden werd er meer uitgegeven dan het gemiddelde: %s%n", result);
		}
		else{
			System.out.printf("Geen maanden gevonden waarin meer werd uitgegeven dan het gemiddelde!%n");
		}
*/
	}

	private double geefUitgave(int maand) {
		System.out.printf("Geef de uitgaven in voor de maand %d: ", maand);
		return sc.nextDouble();
	}

}
