package cui;

import java.util.Scanner;

public class H2_oef10
{

	public static void main(String[] args)
	{
		new H2_oef10().subOef1();
		new H2_oef10().subOef2();

	}

	private void subOef2()
	{
		greeting("subOef2");
		int getal, grootsteGetal, kleinsteGetal;
		
		getal = geefGetal();
		
		grootsteGetal = getal;
		kleinsteGetal = getal;
		
		while (getal != 0) {
			if (getal > grootsteGetal) {
				grootsteGetal = getal;
			}
			else if (getal < kleinsteGetal) {
				kleinsteGetal = getal;
			}
			getal = geefGetal();
			
		}
		
		System.out.printf("Het grootste van alle ingevoerde getallen is %d%n", grootsteGetal);
		System.out.printf("Het kleinste is %d", kleinsteGetal);
	}

	private void subOef1()
	{
		greeting("subOef1");
		int getal, teller = 0;
		double gem = 0;
		
		getal = geefGetal();
		
		
		while (getal != 0) {
			if (getal < 0) {
				gem += getal;
				teller++;
			}
			
			getal = geefGetal();
		} 
		
		if (teller != 0)
		{
			gem = gem/teller;
			System.out.printf("Het gemiddelde van alle negatieve getallen is %.1f%n", gem);
		}
		else
			System.out.println("Er werden geen negative getallen ingevoerd!");
	}
	
	private int geefGetal() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Geef een getal (stoppen=0): ");
		return sc.nextInt();
	}

	private void greeting(String oef) {
		System.out.println("\n" + oef);
	}
}
