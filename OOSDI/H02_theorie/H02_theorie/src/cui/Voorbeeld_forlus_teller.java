package cui;

public class Voorbeeld_forlus_teller
{

	public static void main(String[] args)
	{
		new Voorbeeld_forlus_teller().gebruik_for();
	}
	
	private void gebruik_for()
	{	
		// tag::voorbeeld1[]
		for (int product = 3; product <= 100; product *= 3)
			;
		// end::voorbeeld1[]
	}
}
