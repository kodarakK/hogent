package cui;

import java.util.Scanner;

public class H2_oef23 {

	public static void main(String[] args) {
		new H2_oef23().subOef1();

	}

	private Scanner sc = new Scanner(System.in);

	private void subOef1() {
		int deler = geefGetalDeler();
		int aantalDeelbaar = 0;
		int teller = 1;
		int getal;

		getal = geefGetal(teller++);
		while (getal != -1) {

			if ((getal % deler) == 0)
				aantalDeelbaar++;

			getal = geefGetal(teller++);

		}

		System.out.printf("Er %s %d getal%s deelbaar door %d", 
				aantalDeelbaar==1?"is":"zijn", 
				aantalDeelbaar, 
				aantalDeelbaar==1?"":"len", 
				deler);

	}

	private int geefGetalDeler() {
		int getal;
		do {
			System.out.println("Geef een strikt positieve deler in: ");
			getal = sc.nextInt();
		} while (getal <= 0);
		return getal;
	}

	private int geefGetal(int nummer) {

		int getal;
		do {
			System.out.printf("Geef positief getal %d in (of stop met -1): ", nummer);
			getal = sc.nextInt();
		} while (getal < 0 && getal != -1);
		return getal;
	}

}
