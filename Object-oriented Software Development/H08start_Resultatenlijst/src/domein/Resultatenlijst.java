package domein;

import java.util.ArrayList;
import java.util.List;

public class Resultatenlijst {
	public static final int MIN_RESULTAAT = 0;
	public static final int MAX_RESULTAAT = 20;
	public static final int MAX_AANTAL_RESULTATEN = 5;

	private List<Integer> resultaten;

	public Resultatenlijst() {
		this.resultaten = new ArrayList<>();
	}

	public void voegResultaatToe(int resultaat) {
		if (resultaat < MIN_RESULTAAT || resultaat > MAX_RESULTAAT)
			throw new IllegalArgumentException(
					String.format("Resultaat moet in interval[%d, %d] liggen", MIN_RESULTAAT, MAX_RESULTAAT));
		if (resultaten.size() == MAX_AANTAL_RESULTATEN)
			throw new IllegalArgumentException(String.format(
					"Er kunnen niet meer dan %d resultaten in de lijst opgenomen worden", MAX_AANTAL_RESULTATEN));
		resultaten.add(resultaat);
	}

	public List<Integer> getResultaten() {
		return resultaten;
	}

	public double geefGemiddelde() {
		if (resultaten.isEmpty())
			throw new IllegalArgumentException("Kan geen gemiddelde berekenen van een lege lijst");
		double som = 0;
		for (int resultaat : resultaten) {
			som += resultaat;
		}
		return som / resultaten.size();
	}
}
