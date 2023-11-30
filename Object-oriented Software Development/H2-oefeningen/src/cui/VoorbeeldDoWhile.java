package cui;
import java.util.Scanner;

public class VoorbeeldDoWhile
{

	public static void main(String[] args)
	{
		new VoorbeeldDoWhile().voorbeeld();
	}

	// geef een strikt positief getal (getal > 0)
	private void voorbeeld()
	{
		Scanner sc = new Scanner(System.in);
		int getal;
		do {
			System.out.print("Geef een strikt positief getal: ");
			getal = sc.nextInt();
			
		} while (getal <= 0); // getal moet > 0
		
		System.out.printf("Ingegeven getal is %d", getal);
		
	}

}
