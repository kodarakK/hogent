package domein;

//import java.security.SecureRandom;

public class Grijpkraan extends Automaat
{
//	private final SecureRandom random;
	public Grijpkraan(int aantalPrijzen) {
		super(aantalPrijzen);
//		random = new SecureRandom();
		
	}

	public boolean draaiHendel() {
		boolean gewonnen = random.nextBoolean();

		if (gewonnen) {
			return super.draaiHendel();
		}
		setAantalMunten(getAantalMunten() + 1);
		setMuntInGleuf(false); 
		return false;
	}
}
