package cui;

import java.util.Scanner;

public class H2_oef17
{

	public static void main(String[] args)
	{
		new H2_oef17().subOef1();
	}

	private void subOef1()
	{
		int getal = geefGetal();
		
		if (getal == 0) {
			System.out.println("Het ingegeven getal was nul en werd vermeederd met 1.");
		} else if (getal < 0) {
			System.out.println("Het ingegeven getal was negatief en werd vermeerderd met 10.");
			System.out.printf("Het heeft nu de waarde %d%n", (getal + 10));
		} else {
			System.out.println("Het ingegeven getal was strikt positief en werd verminderd met 10.");
			System.out.printf("Het heeft nu de waarde %d%n", (getal - 10));
		}
	}

	private int geefGetal()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Geef een getal in: ");
		return sc.nextInt();
	}

}
