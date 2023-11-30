package cui;

import java.util.Scanner;

public class DoWhileControle1
{
	public static void main(String[] args)
	{
		new DoWhileControle1().controleerInvoer();
	}
	
	private void controleerInvoer()
	{
		Scanner input = new Scanner(System.in);
		int getal;

		do // INVOERCONTROLE <1>
		{ // <2>
			System.out.print("Geef een strikt positief geheel getal in: ");
			getal = input.nextInt();
		} while (getal <= 0); // einde do/while structuur <3>
		
		System.out.printf("Het ingevoerde getal = %d", getal);
	}
}
