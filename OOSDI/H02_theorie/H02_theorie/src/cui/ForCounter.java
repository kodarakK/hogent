package cui;

public class ForCounter
{
	public static void main(String[] args)
	{
		new ForCounter().use_for();
	}
		
	private void use_for()
	{
		// tag::voorbeeld2[]
		for (int teller = 1; teller <= 5; teller++)
			System.out.printf("%d ", teller);
		// end::voorbeeld2[]
		
		// tag::voorbeeld6[]
		for (int i = 1; i <= 100; i+=2 ) {}
		// end::voorbeeld6[]
		
		// tag::voorbeeld7[]
		for (int i = 100; i >= 1; i-- ) {}
		// end::voorbeeld7[]
		
		// tag::voorbeeld8[]
		for (int i = 7; i <= 77; i += 7 ) {}
		// end::voorbeeld8[]
	}
}
