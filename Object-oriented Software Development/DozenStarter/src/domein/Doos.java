package domein;

public class Doos
{
	private static final String DEFAULT_KLEUR = "rood";
	private static final double DEFAULT_RIBBE = 1.0;
	
	private static int aantalDozenGemaakt = 0;
	
	private double lengte = 0;
	private double breedte = 0;
	private double hoogte = 0;
	private String kleur = "";
	private String code = "";
	
	public Doos(double lengte, double breedte, double hoogte, String kleur)
	{
		super();
		setLengte(lengte);
		setBreedte(breedte);
		setHoogte(hoogte);
		setKleur(kleur);
		aantalDozenGemaakt++;
		stelCodeIn();
	}
	
	public Doos(String kleur) {
		this(DEFAULT_RIBBE, DEFAULT_RIBBE, DEFAULT_RIBBE, kleur);
	}
	
	public Doos(double lengte, double breedte, double hoogte) {
		this(lengte, breedte, hoogte, DEFAULT_KLEUR);
	}
	
	public Doos() {
		this(DEFAULT_RIBBE, DEFAULT_RIBBE, DEFAULT_RIBBE, DEFAULT_KLEUR);
	}
	
	private void stelCodeIn() {
		this.code = String.format("D%015d", aantalDozenGemaakt);
	}
	
	private void controleerAfmeting(String afmeting, double minWaarde, double waarde) {
		if (waarde <= minWaarde) throw new IllegalArgumentException(
				String.format("De %s moet groter dan %.1f zijn.", afmeting, minWaarde)
				);
		
	}
	
	
	
	private void setLengte(double lengte)
	{
		controleerAfmeting("lengte", 0, lengte);
		this.lengte = lengte;
	}
	private void setBreedte(double breedte)
	{
		controleerAfmeting("breedte", 0, breedte);
		this.breedte = breedte;
	}
	private void setHoogte(double hoogte)
	{
		controleerAfmeting("hoogte", 0, hoogte);
		this.hoogte = hoogte;
	}
	
	
	private void setKleur(String kleur)
	{
		if (kleur == null || kleur.isBlank()) throw new IllegalArgumentException(
				String.format("Kleur moet een waarde hebben")
				);
		this.kleur = kleur;
	}
	public static int getAantalDozenGemaakt()
	{
		return aantalDozenGemaakt;
	}
	
	private void setCode(String code)
	{
		this.code = code;
	}
	
	public static String getDefaultKleur()
	{
		return DEFAULT_KLEUR;
	}
	public static double getDefaultRibbe()
	{
		return DEFAULT_RIBBE;
	}
	
	public double getLengte()
	{
		return lengte;
	}
	public double getBreedte()
	{
		return breedte;
	}
	public double getHoogte()
	{
		return hoogte;
	}
	public String getKleur()
	{
		return kleur;
	}
	public String getCode()
	{
		return code;
	}
	
	

}
