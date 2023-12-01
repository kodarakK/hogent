package domein;

public class Hond extends Huisdier
{
	public Hond(String naam)
	{
		super(naam);
	}
	
	@Override
	public String maakGeluid() 
	{
		return String.format("waf waf%s", super.maakGeluid());
	}
	
	public String kwispel()
	{
		return "kwispel-kwispel-kwispel";
	}
	
}