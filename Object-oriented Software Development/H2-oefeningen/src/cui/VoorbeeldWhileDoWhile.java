package cui;

import java.util.Scanner;

public class VoorbeeldWhileDoWhile
{

	public static void main(String[] args)
	{
		new VoorbeeldWhileDoWhile().voorbeeld();

	}

	private void voorbeeld()
	{
		/*
		 *  getallen: even strikt positive getallen
		 *  stopwaarde is -1000
		 *  verwerking: som
		 *  
		 *  init
		 *  
		 *  invoer
		 *  
		 *  while
		 *  	verwerking
		 *  
		 *  	invoer
		 *  
		 */
		
		int getal, som = 0;
		
		getal = geefGetal();
		
		while (getal != -1000) {
			som += getal;
			getal = geefGetal();
		}
		
		System.out.printf("De som is %d%n", som);
	}

	private int geefGetal()
	{
		/* 
		 * 
		 * getallen: even strikt positive getallen
		 * stopwaarde is -1000
		 *
		 */
		Scanner sc = new Scanner(System.in);
		int getal;
		
		do {
			System.out.print("Geef een even strikt posistief getal (stoppen = -1000): ");
			getal = sc.nextInt();
		} while (getal != -1000 && getal <= 0 && (getal%2) != 0);
		
		/*
		 * goed? getal == -1000 || getal >  0 || (getal%2) == 0
		 * 
		 */
		
		return getal;
	}

}
