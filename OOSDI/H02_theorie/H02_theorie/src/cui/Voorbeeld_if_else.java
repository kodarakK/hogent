package cui;

public class Voorbeeld_if_else
{
	public static void main(String[] args)
	{
		new Voorbeeld_if_else().gebruik_if_en_if_else();
	}
	
	private void gebruik_if_en_if_else()
	{
		int punten = 30, aantalGeslaagden = 0, aantalNietGeslaagden = 0;
		
		// tag::voorbeeld1_if[]
		if (punten >= 60) System.out.println("Geslaagd");

		// OF het statement op de volgende lijn
		if (punten >= 60)
			System.out.println("Geslaagd");

		// OF met accolades (niet verplicht als er maar 1 statement is)
		if (punten >= 60) { System.out.println("Geslaagd");	}

		// OF met accolades over verschillende regels gespreid
		if (punten >= 60)
		{
			System.out.println("Geslaagd");
		}
		// end::voorbeeld1_if[]
		
		// tag::voorbeeld2_if[]
		if (punten == 20)
		{
			System.out.println("Je behaalt een credit!");
			aantalGeslaagden = aantalGeslaagden + 1;
		}
		// end::voorbeeld2_if[]
		
		// tag::voorbeeld1_if_else[]
		if (punten >= 60)
			System.out.println("Geslaagd");
		else
			System.out.println("Niet geslaagd");

		// OF met accolades (niet verplicht als er maar 1 statement is)
		if (punten >= 60)
		{
			System.out.println("Geslaagd");
		}
		else
		{
			System.out.println("Niet geslaagd");
		}	
		// end::voorbeeld1_if_else[]
		
		// tag::voorbeeld2_if_else[]
		if (punten == 20)
		{
			System.out.println("Je behaalt een credit!");
			aantalGeslaagden = aantalGeslaagden + 1;
		} 
		else
		{
			System.out.println("Je behaalt geen credit!");
			aantalNietGeslaagden = aantalNietGeslaagden + 1;
		}
		// end::voorbeeld2_if_else[]
		
		int code = 0;
		// tag::voorbeeld2_geneste_if[]
		if (code == 1)
			System.out.println("Je kiest om op te tellen!");
			else // code <> 1
				if (code == 2)
					System.out.println("Je kiest om af te trekken!");
				else // code <> 1 en code <> 2
					if (code == 3)
						System.out.println("Je kiest om te delen!");
					else // code <> 1 en code <> 2 en code <> 3
						System.out.println("Je kiest om te vermenigvuldigen!");
		// end::voorbeeld2_geneste_if[]
		
		int grade = 70;
		// tag::voorbeeld3_geneste_if[]
		if (grade >= 60)
			System.out.println("Passed");
		else
		{
			System.out.println("Failed");
			System.out.println("You must take the course again.");
		}
		// end::voorbeeld3_geneste_if[]
		
		int getal1 = 5, getal2 = 5;
		// tag::voorbeeld4_geneste_if[]
		if (getal1 > 10)
			if (getal2 > 20)
				System.out.println("getal1 > 10 en getal2 > 20");
			else
				System.out.println(" ??? ");
		// end::voorbeeld4_geneste_if[]
		
		// tag::voorbeeld5_geneste_if[]
		if (getal1 > 10)
		{
			if (getal2 > 20)
				System.out.println("getal1 > 10 en getal2 > 20");
		} else
			System.out.println(" ??? ");
		// end::voorbeeld5_geneste_if[]
		
		
	}

}
