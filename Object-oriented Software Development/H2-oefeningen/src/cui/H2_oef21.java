package cui;

import java.util.Scanner;

public class H2_oef21
{

	public static void main(String[] args)
	{
		new H2_oef21().subOef1();

	}
	
	private Scanner sc = new Scanner(System.in);
	
	private void subOef1()
	{
		int getal = geefGetal();
		int teller = getal / 2;
		
		System.out.print("De delers zijn: 1");
		
		for (int i = 2; i < getal/2; i++) {
			if (getal%i == 0) System.out.printf("%3d", i);
		}
		
		if (getal != 1) System.out.printf(" en %d", getal);
		
	}

	

	private int geefGetal()
	{
		int getal;
		do
		{
			System.out.println("Geef een strikt positief geheel getal in: ");
			getal = sc.nextInt();
		} while (getal < 0); // getal < 0
		return getal;
	}
	
	

	

}
