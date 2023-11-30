package domein;

public class Lied {
	private double duurInMinuten;
	private int beatsPerMinute;
	private static final int DEFAULT_BEATS_PER_MINUTE = 100;
	private static final double DEFAULT_DUUR_IN_MINUTEN = 4;
	private static final double MIN_DUUR_IN_MINUTEN = 0.5;
	private static final double MAX_DUUR_IN_MINUTEN = 10;
	private static final double MIN_BEATS_PER_MINUTE = 10;
	private static final double MAX_BEATS_PER_MINUTE = 200;

	public Lied(double duurInMinuten, int beatsPerMinute) {
		setBeatsPerMinute(beatsPerMinute);
		setDuurInMinuten(duurInMinuten);
	}

	public Lied(double duurInMinuten) {
		this(duurInMinuten, DEFAULT_BEATS_PER_MINUTE);
	}

	public void 	(int beatsPerMinute) {
		this.beatsPerMinute = (beatsPerMinute < MIN_BEATS_PER_MINUTE || beatsPerMinute > MAX_BEATS_PER_MINUTE)?
			DEFAULT_BEATS_PER_MINUTE:beatsPerMinute;
	}

	private void setDuurInMinuten(double duurInMinuten) {
		this.duurInMinuten = (duurInMinuten < MIN_DUUR_IN_MINUTEN || duurInMinuten > MAX_DUUR_IN_MINUTEN)?
			DEFAULT_DUUR_IN_MINUTEN:duurInMinuten;
	}

	public double getDuurInMinuten() {
		return duurInMinuten;
	}

	public int getBeatsPerMinute() {
		return beatsPerMinute;
	}

	public int geefDuurInSeconden() {
		return (int) (this.duurInMinuten * 60);
	}

	public String geefTempo() {
		String result = "";
		if (this.beatsPerMinute <= 70)
			result = "traag";
		else if (this.beatsPerMinute >= 71 && this.beatsPerMinute <= 90)
			result = "relax";
		else if (this.beatsPerMinute >= 91 && this.beatsPerMinute <= 120)
			result = "fris";
		else if (this.beatsPerMinute >= 121 && this.beatsPerMinute <= 180)
			result = "levendig";
		else if (this.beatsPerMinute >= 180)
			result = "snel";
		return result;
	}

}
