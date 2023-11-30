package cui;

import utils.Kleur;
import static utils.Kleur.*;

public class EnumDemo02 {

	public static void main(String[] args) {
		new EnumDemo02().voorbeeld();
	}

	private void voorbeeld() {
		toonAlleKleuren();
		toonRgbCode(BLAUW);
	}

	private void toonAlleKleuren() {
		System.out.printf("%nAlle kleuren:%n");
		for (Kleur k : Kleur.values()) {
			System.out.printf("%s%n", k); //k.toString()
		}
	}

	private void toonRgbCode(Kleur kleur) {
		System.out.printf("%n%s - %s ", kleur.name(), kleur.getRgbCode()); 
	}
}
