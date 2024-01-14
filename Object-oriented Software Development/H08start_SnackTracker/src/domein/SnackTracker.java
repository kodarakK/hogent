package domein;

public class SnackTracker {
	public static final int MAX_SNACKS = 10;
	private Snack[] snacks;

	public SnackTracker() {
		snacks = new Snack[MAX_SNACKS];
	}

	public void registreerSnack(Snack snack) {
		if (snack == null)
			throw new IllegalArgumentException("Er moet een snack opgegeven worden");
		int index = geefAantalGeregistreerdeSnacks();
		if (index == MAX_SNACKS)
			throw new IllegalArgumentException("Maximum aantal snacks reeds geregistreerd");
		snacks[index] = snack;
	}

	public boolean isGezondGesnackt() {
		return geefAantalGeregistreerdeSnacks() == 0
				|| geefAantalGezondeSnacks() > geefAantalGeregistreerdeSnacks() / 2;
	}

	public Snack[] getSnacks() {
		return snacks;
	}

	public int geefAantalGeregistreerdeSnacks() {
		int aantal = 0;
		for (Snack snack : snacks) {
			if (snack == null)
				return aantal;
			aantal++;
		}
		return aantal;
	}

	private int geefAantalGezondeSnacks() {
		int aantal = 0;
		for (int i = 0; i < geefAantalGeregistreerdeSnacks(); i++)
			aantal += snacks[i].isGezond() ? 1 : 0;
		return aantal;
	}
}
