package cui;

import java.util.Scanner;

import domein.Product;

public class ProductApplicatie
{
	public static void main(String[] args)
	{
		new ProductApplicatie().start();

	}
	
	Scanner sc = new Scanner(System.in);

	private void start()
	{
		// init
		double totaal = 0;
		int aantalPannenkoek = 0;
		int aantalPannenkoekMetSuiker = 0;
		int aantalPannenkoekMetChoco = 0;
		
		Product pannenkoek = new Product("pannenkoek", 0.125, 21, 5);
		Product pannenkoekMetSuiker = new Product("pannenkoek met suiker", 2.00, 6, 10);
		Product pannenkoekMetChoco = new Product("pannenkoek met choco", 2.20, 6, 15); 
		
		// invoer
		aantalPannenkoek = geefStuks(pannenkoek.getNaam());
		aantalPannenkoekMetSuiker = geefStuks(pannenkoekMetSuiker.getNaam());
		aantalPannenkoekMetChoco = geefStuks(pannenkoekMetChoco.getNaam());
		
		totaal = pannenkoek.berekenPrijs(aantalPannenkoek) + 
				 pannenkoekMetSuiker.berekenPrijs(aantalPannenkoekMetSuiker) + 
				 pannenkoekMetChoco.berekenPrijs(aantalPannenkoekMetChoco);
		
		System.out.printf("Aan de kassa zal u %.2f EURO moeten betalen.", totaal);
		
	}

	private int geefStuks(String string)
	{
		int getal;
		do
		{
			System.out.printf("Hoeveel stuks wilt u van \'%s\' ? ", string);
			getal = sc.nextInt();
		} while (getal < 0);
		return getal;
	}
}
