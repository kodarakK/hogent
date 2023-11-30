package domein;

public class Rechthoek
{
	private double lengte;
	private double breedte;
	
	private static final double DEFAULT_LENGTE = 10.0;
	private static final double DEFAULT_BREEDTE = 7.0;
	private static final double DEFAULT = 1.0;
	
	
	
	public Rechthoek(double lengte, double breedte)
	{
		setLengte(lengte);
		setBreedte(breedte);
	}
	
	public Rechthoek()
	{
		this(DEFAULT_LENGTE, DEFAULT_BREEDTE);
	}
	
	private void setLengte(double lengte)
	{
		this.lengte = (lengte<=0)?DEFAULT:lengte;
	}

	private void setBreedte(double breedte)
	{
		this.breedte = (breedte<=0)?DEFAULT:breedte;
	}

	public double getLengte()
	{
		return lengte;
	}
	public double getBreedte()
	{
		return breedte;
	}
	
	public double berekenOmtrek() {
		return (this.breedte+this.lengte)*2;
	}
	
	public double berekenOppervlakte() {
		return this.breedte*this.lengte;
	}
	
	
}
