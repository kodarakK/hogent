package cui;

import java.util.Scanner;

public class H2_oef30
{

	public static void main(String[] args)
	{
		new H2_oef30().subOef1();
	}
	
	private void subOef1()
	{
		
		
	}

	private Scanner sc = new Scanner(System.in);

	private int geefPositiefGetal() {
		int getal;
		do
		{
			System.out.print("Geef een positief geheel getal (0 om te stoppen): ");
			getal = sc.nextInt();
		} while (getal < 0);
		return getal;
	}
}
