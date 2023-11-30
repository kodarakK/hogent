package cui;

public class Voorbeeld
{

	public static void main(String[] args)
	{
		Voorbeeld app = new Voorbeeld();
		app.werkMetFor();
	}

	private void werkMetFor()
	{
		int teller;
		for (teller = 1; teller <= 10; teller++) {
			System.out.println("hellorld" + teller);
		}
		System.out.println(teller);
		
	}

}
