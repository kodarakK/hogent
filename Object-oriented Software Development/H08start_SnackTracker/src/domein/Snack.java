package domein;

public class Snack {
	private Categorie categorie;
	private String naam;

	public Snack(String naam, Categorie categorie) {
		setNaam(naam);
		setCategorie(categorie);
	}

	public boolean isGezond() {
		return categorie == Categorie.FRUIT || categorie == Categorie.GROENTE;
	}

	private void setNaam(String naam) {
		if (naam == null || naam.isBlank())
			throw new IllegalArgumentException("Snack moet een naam krijgen");
		this.naam = naam;
	}

	private void setCategorie(Categorie categorie) {
		if (categorie == null)
			throw new IllegalArgumentException("Snack moet een categorie krijgen");
		this.categorie = categorie;
	}

	public String getNaam() {
		return naam;
	}

	public Categorie getCategorie() {
		return categorie;
	}

}
