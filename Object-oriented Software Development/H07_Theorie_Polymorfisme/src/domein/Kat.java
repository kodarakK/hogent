package domein;

public class Kat extends Huisdier{

	public Kat(String naam) {
		super(naam); 
	}

	@Override
	public String maakGeluid() {
		return String.format("miauw%s", super.maakGeluid());
	}

	public String spin() {
		return String.format("%s spint", getNaam());
	}

	@Override
	public String toString() {
		return String.format("%s, %s", super.toString(), spin());
	}
}