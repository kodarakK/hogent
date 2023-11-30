package domein;

public class Automaat
{
//	superklasse
	private int aantalItems;
	private int aantalMunten;
	private boolean muntInGleuf;
	private boolean itemInBak;
	
	
	/*
	 * constructors
	 */
	public Automaat(int aantalItems) {
		setAantalItems(aantalItems);
	}
	
	
	
	/*
	 * getters and setters 
	 */
	public int getAantalItems()
	
	{
		return aantalItems;
	}
	
//	public setter => final
	public final void setAantalItems(int aantalItems)
	{
		this.aantalItems = aantalItems;
	}
	
	public int getAantalMunten()
	{
		return aantalMunten;
	}
	
	public final void setAantalMunten(int aantalMunten)
	{
		this.aantalMunten = aantalMunten;
	}
	
	public boolean isMuntInGleuf()
	{
		return muntInGleuf;
	}
	
	public final void setMuntInGleuf(boolean muntInGleuf)
	{
		this.muntInGleuf = muntInGleuf;
	}
	
	public boolean isItemInBak()
	{
		return itemInBak;
	}
	
	public final void setItemInBak(boolean itemInBak)
	{
		this.itemInBak = itemInBak;
	}
	
/*
 * gedrag
 */
	public void betaal() {
		setMuntInGleuf(true);
	}
	
	public boolean draaiHendel() {
		if (muntInGleuf && !itemInBak && aantalItems > 0) {
			setAantalItems(aantalItems - 1);
			setAantalMunten(aantalMunten + 1);
			setMuntInGleuf(false);
			setItemInBak(true);
			return true;
		}
		setMuntInGleuf(false);
		return false;
	}
	
	
	
	
}
