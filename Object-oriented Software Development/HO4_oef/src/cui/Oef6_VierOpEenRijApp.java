package cui;

import java.security.SecureRandom;

public class Oef6_VierOpEenRijApp {

	public static void main(String[] args) {
		new Oef6_VierOpEenRijApp().vulArrayEnControleerOpVierOpEenRij();
	}

	private void vulArrayEnControleerOpVierOpEenRij() {
		// Maken en opvullen van de array karakters
		SecureRandom sr = new SecureRandom();
		char[] karakters = new char[10];
		for (int i = 0; i < karakters.length; i++) {
			karakters[i] = sr.nextBoolean() ? 'X' : 'O';
		}

		// TODO hieronder aanvullen
		// ga na als karakters vier zelfde karakters op rij bevat
		// en verzorg de uitvoer

		int rijLentgte = 0;
		char huidigChar = ' ';

		for (char kar : karakters) {
			if (huidigChar == kar) {
				rijLentgte++;
				if (rijLentgte==4) {
					break;
				}
			} else {
				rijLentgte = 1;
				huidigChar = kar;
			}
		}

		String result = "";

		for (int index = 0; index < karakters.length; index++) {
			result += String.format("%s ", karakters[index]);
		}

		System.out.println(result);
		System.out.printf("Deze rij bevat%svier op een rij...", (rijLentgte==4)?" ":" geen ");

	}

}
