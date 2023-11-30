package cui;

import java.util.Scanner;

public class Oefening4 {

	public static void main(String[] args) {
		new Oefening4().start();
	}

	private Scanner sc = new Scanner(System.in);

	private void start() {
		int[] getallen = new int[10];
		for(int index = 0; index < getallen.length; index++) {
			getallen[index] = geefGetal(String.format("Geef getal %d op: ", index+1));
		}

		int ondergrens = geefGetal("Geef de ondergrens: ");

		String result = String.format("%nElementen van de array die strikt groter dan %d zijn: %n", ondergrens);

		result += String.format("%10s%10s%n", "Index", "Waarde");

		for (int index = 0; index < getallen.length; index++) {
			if (getallen[index] > ondergrens) {
				result += String.format("%10d%10d%n", index, getallen[index]);
			}
		}

		System.out.println(result);
	}

	private int geefGetal(String vraag) {
		System.out.print(vraag);
		return sc.nextInt();
	}
}