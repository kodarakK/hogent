package cui;

import java.util.Scanner;

public class H2_oef13
{

	public static void main(String[] args)
	{
		new H2_oef13().subOef1();
	}
	
	private Scanner sc = new Scanner(System.in);

	private void subOef1()
	{
		int som = 0;
		int teller = 0;
		int getal = geefGetal(teller++);
		
		while (teller < 10 && getal != -1) {
			
			som += getal;
			teller++;
			
			getal = geefGetal(teller);
		}
		
		if (teller == 0) System.out.println("Er werden geen getallen ingegeven!");
		else System.out.printf("Het gemiddelde is %.2f", (double)som / teller);
	}

	private int geefGetal(int nummer)
	{
		System.out.printf("Geef getal %d in (-1 om te stoppen): ", nummer);
		return sc.nextInt();
	}

}
