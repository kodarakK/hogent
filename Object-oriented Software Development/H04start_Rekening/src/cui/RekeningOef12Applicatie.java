package cui;

import java.util.Scanner;

import domein.Rekening;

public class RekeningOef12Applicatie
{

	public static void main(String[] args)
	{
		new RekeningOef12Applicatie().start();

	}

	private Scanner sc = new Scanner(System.in);

	private void start()
	{
		// decl + creatie
		Rekening[][] rekeningen = new Rekening[3][];

		for (int rij = 0; rij < rekeningen.length; rij++)
		{
			// rekeningen[rij] = new Rekening[aantalKolomen(rij+ 1)];

			int aantalKolommen = aantalKolomen(rij + 1);
			rekeningen[rij] = new Rekening[aantalKolommen];

			for (int kolom = 0; kolom < rekeningen[rij].length; kolom++)
			{
				rekeningen[rij][kolom] = new Rekening();
				rekeningen[rij][kolom].stort(10 * (rij + 1) + kolom + 1);
			}
		}
		
		for (Rekening[] rij : rekeningen)
		{
			for (Rekening rek : rij)
			{
				System.out.printf("%-8.0f", rek.getSaldo());
			}
			System.out.println();
		}

	}

	private int aantalKolomen(int index)
	{
		int getal;
		boolean niet_geldig;
		do
		{

			System.out.printf("Geef aantal kolommen voor rij %d", index);
			getal = sc.nextInt();

			niet_geldig = getal <= 0;
			
			if(niet_geldig) System.out.println("");
		} while (niet_geldig);
		return getal;
	}

}
