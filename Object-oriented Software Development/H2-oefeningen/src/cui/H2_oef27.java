package cui;

import java.util.Scanner;

public class H2_oef27
{

	public static void main(String[] args)
	{
		new H2_oef27().subOef1();

	}
	
	Scanner sc =  new Scanner(System.in);

	private void subOef1()
	{
		
		int aantal1 = 0;
		int aantal2 = 0;
		int aantal3 = 0;
		int aantal4 = 0;
		
		
		for (int i = 1; i <= 15; i++) {
			int getal = geefGetal(i);
			
			switch (getal) {
				case 1 -> aantal1++;
				case 2 -> aantal2++;
				case 3 -> aantal3++;
				case 4 -> aantal4++;			
			}
		}
		
		System.out.printf("Aantal 1 = %d%n", aantal1);
		System.out.printf("Aantal 2 = %d%n", aantal2);
		System.out.printf("Aantal 3 = %d%n", aantal3);
		System.out.printf("Aantal 4 = %d%n", aantal4);
		
	}

	private int geefGetal(int nummer)
	{
		int antwoord;
		
		boolean ongeldig;
		
		do
		{
			System.out.printf("Geef antwoord %d in (1, 2, 3 of 4): ", nummer);
			antwoord = sc.nextInt();
			ongeldig = antwoord < 1 || antwoord > 4;
			if (ongeldig) System.out.printf("Foutieve waarde! Probeer opnieuw!%n");
		
		}while(ongeldig);
		return antwoord;
	}

}
