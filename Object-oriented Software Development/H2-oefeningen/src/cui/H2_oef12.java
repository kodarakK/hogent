package cui;

public class H2_oef12
{

	public static void main(String[] args)
	{
		new H2_oef12().voorbeeld();
	}

	private void voorbeeld()
	{
		int leeuwen = 50, teller = 0;
		do {
			leeuwen += leeuwen*15 / 100;
			teller++;
//			System.out.println(leeuwen);
		} while (leeuwen <= 1000);
		System.out.printf("aantal leeuwen: %d, achter %d jaren.%n", leeuwen, teller);
	}

}
