package domein;

public class Tankstation {
	private static final int DEFAULT_AANTAL_POMPEN = 5;
	private static final int DEFAULT_AANTAL_LITER = 100;
	private static final int MAX_AANTAL_LITER = 80;
	private static final int MIN_AANTAL_LITER = 5;

	private int[] pompen;
	
	public Tankstation() {
		pompen = new int[DEFAULT_AANTAL_POMPEN];
		
		for (int index = 0; index < pompen.length; index++) {
			pompen[index] = DEFAULT_AANTAL_LITER;
		}
	}

	public boolean tank(int pompNummer, int aantalLiter) {

		if (pompNummer < 1 || pompNummer > 5) return false;
		if (aantalLiter < MIN_AANTAL_LITER || aantalLiter > MAX_AANTAL_LITER || (aantalLiter > pompen[pompNummer - 1])) return false;
		
		pompen[pompNummer - 1] -= aantalLiter;
		return true;
		
	}

	public int geefInhoud(int pompNummer) {
		if (pompNummer < 1 || pompNummer > DEFAULT_AANTAL_POMPEN) return -1;
		
		return pompen[pompNummer - 1];
	}

	public String toString() {
		String resultaat = "";
		for (int i = 0; i < pompen.length; i++) {
			resultaat += String.format("Pomp #%d: %d liter%n", i + 1, pompen[i]);
		}
		return resultaat;
	}

}
