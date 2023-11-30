package cui;

public class VoorbeeldLogischOperatoren
{

	public static void main(String[] args)
	{
		new VoorbeeldLogischOperatoren().voorbeeld();
	}

	private void voorbeeld()
	{
		 // EN
		int getal = 10;
		if (getal > 0 && (getal%2) == 0) {
			System.out.println("Strikt positief en even.");
		}
		
		if (getal < 0 && (getal%2) != 0) {
			System.out.println("Strikt negatief en oneven.");
		}
		
		if (getal != 0 && (15 / getal) > 2) {
			System.out.println("Geen deling door 0.");
		}
		
		// OF
		if (getal < 0 || getal > 100) {
			System.out.println("Getal < 0 OF getal > 100.");
		}
		
		if (getal != 0 && (5/getal > 2 || getal > 100)) {
			System.out.println("Getal != 0 EN volgende samengestelde conditie");
		}
		
		// NIET
		
		if (!(getal <= 0)) {
			System.out.println("Getal is strikt posistief.");
		}
		
		boolean geldig = true;
		
		if (geldig) {
			System.out.println("Geldig is true.");
		}
		
		if (!geldig) {
			System.out.println("Geldig is false.");
		}
		
	}

}
