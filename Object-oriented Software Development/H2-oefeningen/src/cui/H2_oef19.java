package cui;

import java.util.Iterator;
import java.util.Scanner;

public class H2_oef19
{

	public static void main(String[] args)
	{
		new H2_oef19().subOef1(); 

	}
	
	Scanner sc = new Scanner(System.in);
	
	private void subOef1()
	{
		
		int uur;
		int min;
		int afstand = geefAfstand();
		
		for (int i = 40; i < 150; i += 10) {
			uur = afstand / i;
			min = afstand%i * 60/i;
			
			System.out.printf("%d %8d km/u %4d u %d min%n", afstand, i, uur, min);
		}
		
	}

	private int geefAfstand()
	{
		int getal;
		do
		{
			System.out.println("Geef een afstand in kilometer (strikt positief geheel getal): ");
			getal = sc.nextInt();
		} while (getal <= 0); // getal > 0
		return getal;
	}

	

}
