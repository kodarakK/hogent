package domein;

public class Bestelling {
/*
	private int aantal;
	
	public Bestelling(int aantal) {
		throw new UnsupportedOperationException();
	}

	public int getAantal() {
		return aantal;
	}

	public boolean geeftRechtOpKorting()
	{
		throw new UnsupportedOperationException();
	}*/

	
	private int aantal;
	private static final int MIN_AANTAL = 1;
	private static final int MAX_AANTAL = 10;
	private static final int MIN_KORTING = 5;
	
	public Bestelling(int aantal) {
		setAantal(aantal);
	}

	private void setAantal(int aantal) {
		if (aantal < MIN_AANTAL || aantal > MAX_AANTAL)
			throw new IllegalArgumentException(
					String.format("aantal moet liggen tussen %d en %d, grenzen inbegrepen", 
							MIN_AANTAL, MAX_AANTAL));
		this.aantal = aantal;
	}
	
	
	public int getAantal() {
		return aantal;
	}

	public boolean geeftRechtOpKorting()
	{
		return (aantal >= MIN_KORTING);
	}
}
