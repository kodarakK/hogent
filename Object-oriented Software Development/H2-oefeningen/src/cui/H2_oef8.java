package cui;

public class H2_oef8
{

	public static void main(String[] args)
	{
		H2_oef8 app = new H2_oef8();
		app.somTwaalf();
		
		app.posOnevenGet();
		
		app.alfabet();
	}

	private void alfabet()
	{
		for (char teller = 'a'; teller <= 'z'; teller++) {
			System.out.println(teller);
		}
		
	}

	private void posOnevenGet()
	{
		for (int teller = 51; teller > 0; teller -= 2) {
			System.out.println(teller);
		}
		
	}

	private void somTwaalf()
	{
		int som = 0;
		for (int teller = 12; teller <= 500; teller += 12) {
			som += teller;
		}
		System.out.println("De som is " + som);
		
	}

}
