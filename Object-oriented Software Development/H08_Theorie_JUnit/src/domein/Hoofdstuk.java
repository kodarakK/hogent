package domein;

public class Hoofdstuk
{
	private String titel;
	
	public void setTitel(String titel) {
		if (titel == null || titel.isBlank())
			throw new IllegalArgumentException("titel moet qingevuld zijn");
		
		if (titel.length() < 2) 
			throw new IllegalArgumentException("titel is te klein");
		
		this.titel = titel;
	}
}
