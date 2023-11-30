package cui;

public class IncrementDecrement
{
	public static void main(String[] args)
	{
		new IncrementDecrement().usePreAndPostIncrement();
	}
	
	private void usePreAndPostIncrement()
	{
		// tag::voorbeeld1[]
		int teller1, result1, teller2, result2;
		teller1 = 0;
		teller2 = 0;
		result1 = teller1++; // <1>
		result2 = ++teller2; // <2>
		System.out.printf("%s : %d%n", "teller1", teller1);
		System.out.printf("%s : %d%n", "result1", result1);
		System.out.printf("%s : %d%n", "teller2", teller2);
		System.out.printf("%s : %d%n", "result2", result2);
		// end::voorbeeld1[]
	}
}
