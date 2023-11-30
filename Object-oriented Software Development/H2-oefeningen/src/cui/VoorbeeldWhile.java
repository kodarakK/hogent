package cui;

import java.util.Scanner;

public class VoorbeeldWhile
{

	public static void main(String[] args)
	{
		new VoorbeeldWhile().voorbeeld();
	}

	private void voorbeeld()
	{
		int getal, som = 0;
		
		getal = geefGetal();
		
		while (getal != 0) {
			som += getal;
			getal = geefGetal();
		}
		
		
	}
	
	private int geefGetal() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Geef een getal (stoppen=0): ");
		return sc.nextInt();
	}
	
	

}
