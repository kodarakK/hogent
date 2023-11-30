package domein;

public class Product
{

	private String naam;
	private double prijsExclBtw;
	private int btwPercentage;
	private int kortingStuksPercentage;
	
	private static final int KORTING = 6;
	private static final int MIN_BTW_PERCENTAGE = 6;
	private static final int MAX_BTW_PERCENTAGE = 21;
	private static final int BTW_PERCENTAGE_DEFAULT = 21;
	private static final int PRIJS_EXCL_BTW_DEFAULT = 1;
	private static final int MIN_KORTING_STUKS_PERCENTAGE = 0;
	private static final int MAX_KORTING_STUKS_PERCENTAGE = 50;
	private static final int KORTING_STUKS_PERCENTAGE_DEFAULT = 0;	
	

	public Product(String naam, double prijsExclBtw, int btwPercentage, int kortingStuksPercentage)
	{
		setNaam(naam);
		setPrijsExclBtw(prijsExclBtw);
		setBtwPercentage(btwPercentage);
		setKortingStuksPercentage(kortingStuksPercentage);
	}
	
	
	public double berekenPrijs(int aantal) {
          // if aantal < 0
          //  exception werpen (2de semester)
		double prijs = prijsExclBtw*aantal/100 * btwPercentage;
		double korting = prijs / 100 * kortingStuksPercentage;
		return aantal<KORTING?prijs:prijs-korting;
	}
	
	
	private void setNaam(String naam) {
		if (naam != null && naam.isBlank())  this.naam = naam;
	}

	public double getPrijsExclBtw()
	{
		return prijsExclBtw;
	}

	public final void setPrijsExclBtw(double prijsExclBtw)
	{
		this.prijsExclBtw = (prijsExclBtw<=0)?PRIJS_EXCL_BTW_DEFAULT:prijsExclBtw;
	}

	public int getBtwPercentage()
	{
		return btwPercentage;
	}

	public final void setBtwPercentage(int btwPercentage)
	{
		this.btwPercentage = (btwPercentage>MAX_BTW_PERCENTAGE || btwPercentage<MIN_BTW_PERCENTAGE)?
            BTW_PERCENTAGE_DEFAULT:btwPercentage;
	}

	public int getKortingStuksPercentage()
	{
		return kortingStuksPercentage;
	}

	public final void setKortingStuksPercentage(int kortingStuksPercentage)
	{
		this.kortingStuksPercentage = 
            (kortingStuksPercentage<MIN_KORTING_STUKS_PERCENTAGE|| kortingStuksPercentage>MAX_KORTING_STUKS_PERCENTAGE)?
            KORTING_STUKS_PERCENTAGE_DEFAULT:kortingStuksPercentage;
	}

	public String getNaam()
	{
		return naam;
	}

}
