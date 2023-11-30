package cui;

import java.util.Scanner;

public class H2_oef18
{

	public static void main(String[] args)
	{
		new H2_oef18().subOef1();

	}

	private Scanner sc = new Scanner(System.in);
	
	private void subOef1()
	
	{
		
		int postcode = geefGetal();
		
		String stad = switch (postcode) {
		case 9300 -> "Aalst";
		case 2000 -> "Antwerpen";
		case 1000 -> "Brussel";
		case 9200 -> "Dendermonde";
		case 9000 -> "Gent";
		case 8500 -> "Kortrijk";
		case 9700 -> "Oudenaarde";
		case 2300 -> "Turnhout";
		default -> "";
		};
		
		if (!stad.isEmpty()) System.out.printf("Postnummer %d komt overeen met de stad %s", postcode, stad);
		else System.out.printf("Postnummer %d bestaat niet of komt overeen met een stad die niet in de tabel is opgenomen.", postcode);
		
	}

	private int geefGetal()
	{
		int getal;
		do
		{
			System.out.print("Geef een postcode (4 cijfers): ");
			getal = sc.nextInt();
		} while (getal < 1000 || getal > 10000);
		
		return getal;
	}

}
