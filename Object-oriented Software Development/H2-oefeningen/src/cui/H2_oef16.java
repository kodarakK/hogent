package cui;

import java.util.Scanner;

public class H2_oef16
{

	public static void main(String[] args)
	{
		new H2_oef16().subOef1();
	}

	private void subOef1()
	{
		int getal1 = geefGetal("eerste");

		int getal2 = geefGetal("tweede");

		int getal3 = geefGetal("derde");
		
		int som = getal1 + getal2 + getal3;

		int max = getal1;
		
		System.out.printf("Van de ingevoerde getallen %d, %d en %d%n", getal1, getal2, getal3);
		System.out.println("is de som " + som);
		System.out.println("het gemiddelde " + (som/3));
		System.out.println("de rest " + (som%3));
		
		if (getal2 > max) max = getal2;
		if (getal3 > max) max = getal3;
		
		System.out.println("en het grootste getal " + max);
	}

	private int geefGetal(String aantal)
	{
		Scanner sc  = new Scanner(System.in);
		System.out.printf("Geef %s getal ", aantal);
		int getal = sc.nextInt();
		return getal;
	}

}
