package cui;

import java.util.Scanner;

public class DoWhileControle2
{
	public static void main(String[] args)
	{
		new DoWhileControle2().controleerInvoer();
	}
	
	private void controleerInvoer()
	{
		Scanner input = new Scanner(System.in);
		int getal;

		do // INVOERCONTROLE
		{ 
			System.out.print("Geef een strikt positief en even geheel getal in: ");
			getal = input.nextInt();
		} while (getal <= 0 || getal % 2 != 0); // einde do/while structuur <1>

		System.out.printf("Het ingevoerde getal = %d", getal);
	}
}
