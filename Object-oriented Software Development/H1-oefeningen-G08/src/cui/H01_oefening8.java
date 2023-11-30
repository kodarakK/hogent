package cui;

import java.util.Scanner;

public class H01_oefening8
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int number1, number2, number3, verm;
		
		System.out.print("Geef eerste getal: ");
		number1 = sc.nextInt();
		
		System.out.print("Geef tweede getal: ");
		number2 = sc.nextInt();
		
		System.out.print("Geef derde getal: ");
		number3 = sc.nextInt();
		
		
		verm = number1 * number2 * number3;
		
		System.out.printf("De vermenigvuldiging van %d, %d en %d is %d", number1, number2, number3, verm);
	}

}
