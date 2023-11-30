package cui;

import java.util.Scanner;

public class VoorbeeldForDoWhile
{

	public static void main(String[] args)
	{
		new VoorbeeldForDoWhile().voorbeeld();	}

	private void voorbeeld()
	{
		/*
		 * we vragen 5 getallen tussen 1 en 10, grenzen inbegrepen
		 * som
		 * */
		int som = 0;
		int getal;
		
		for (int i = 1; i <= 5; i++) {
			getal = geefGetal(i);
			som += getal;
		}
		System.out.printf("De som is %d%n", som);
	}

	private int geefGetal(int nummer)
	{
		Scanner sc = new Scanner(System.in);
		int input;														
		
		do
		{
			System.out.printf("Geef getal %d tussen 1 en 10: ", nummer);
			input = sc.nextInt();
		} while (input < 1 || input > 10);
		
		return input;
	}

}
