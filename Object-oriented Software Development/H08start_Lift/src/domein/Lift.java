package domein;

public class Lift {
	private final int laagsteVerdieping;
	private final int hoogsteVerdieping;
	private int verdieping;
	
	public Lift(int laagsteVerdieping, int hoogsteVerdieping) {
		controleerLaagsteEnHoogsteVerdieping(laagsteVerdieping, hoogsteVerdieping);
		this.laagsteVerdieping = laagsteVerdieping;
		this.hoogsteVerdieping = hoogsteVerdieping;
	}

	public void gaNaarOmhoog(int aantalVerdiepingen) {
		if (aantalVerdiepingen <= 0)
			throw new IllegalArgumentException("aantal verdiepingen moet strikt groter zijn dan 0");
		setVerdieping(verdieping + aantalVerdiepingen);
	}

	private void controleerLaagsteEnHoogsteVerdieping(int laagsteVerdieping, int hoogsteVerdieping) {
		if (laagsteVerdieping >= 0 || hoogsteVerdieping <= 0)
		{
			throw new IllegalArgumentException("laagste verdieping moet strikt kleiner zijn dan 0 en hoogste verdieping moet strikt groter zijn dan 0");
		}
	}

	private void setVerdieping(int verdieping) {
		if (verdieping < laagsteVerdieping)
			this.verdieping = laagsteVerdieping;
		else if (verdieping > hoogsteVerdieping)
			this.verdieping = hoogsteVerdieping;
		else
			this.verdieping = verdieping;
	}

	public int getVerdieping() {
		return verdieping;
	}

	public int getLaagsteVerdieping() {
		return laagsteVerdieping;
	}

	public int getHoogsteVerdieping() {
		return hoogsteVerdieping;
	}

}