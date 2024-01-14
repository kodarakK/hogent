package domein;

public class Waterfles {
	
	public static final int MIN_CAPACITEIT = 100;
	public static final int MAX_CAPACITEIT = 2000;

	private final int capaciteit;
	private int inhoud;

	public Waterfles(int capaciteit) {
		controleerCapaciteit(capaciteit);
		this.capaciteit = capaciteit;
	}

	public void vulBij(int hoeveelheidWater) {
		if (hoeveelheidWater <= 0)
			throw new IllegalArgumentException("Je kan een waterfles niet bijvullen met een negatieve hoeveelheid");
		setInhoud(Math.min(capaciteit, this.inhoud + hoeveelheidWater));
	}

	private void controleerCapaciteit(int capaciteit) {
		if (capaciteit < MIN_CAPACITEIT || capaciteit > MAX_CAPACITEIT)
			throw new IllegalArgumentException(String.format(
					"De capaciteit van de waterfles moet tussen %d en %d liggen", MIN_CAPACITEIT, MAX_CAPACITEIT));
	}

	private void setInhoud(int inhoud) {
		if (inhoud < 0 || inhoud > MAX_CAPACITEIT)
			throw new IllegalArgumentException(
					String.format("Er kan niet meer dan %d water in de fles", MAX_CAPACITEIT));
		this.inhoud = inhoud;

	}

	public int getCapaciteit() {
		return capaciteit;
	}

	public int getInhoud() {
		return inhoud;
	}
}