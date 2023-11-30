package cui;
import java.util.Scanner;

public class H1_oefening17
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		double prijs, prijsMetKorting;
		int percent;
		
		System.out.print("Geef een prijs in (=kommagetal): ");
		prijs = sc.nextDouble();
		
		System.out.print("Geef een koringspercentage in (=geheel getal): ");
		percent = sc.nextInt();
		
		prijsMetKorting = prijs - (prijs/100)*percent;
		
		System.out.printf("%f € met %d%% korting is: %f €%n%.2f € met %d%% korting is: %.2f €",prijs, percent, prijsMetKorting, prijs, percent, prijsMetKorting );
		sc.close();
	}

}
