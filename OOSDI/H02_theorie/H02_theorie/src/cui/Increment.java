package cui;

public class Increment
{
	public static void main(String[] args)
	{
		new Increment().usePreAndPostIncrement();
	}
		
	private void usePreAndPostIncrement()
	{
		// tag::voorbeeld2[]
		int c;

		c = 5;
		System.out.printf("%d%n", c); // print 5
		System.out.printf("%d%n", c++); // vermeerder c met 1, maar print de vorige waarde (5) <1>
		System.out.printf("%d%n%n", c); // print 6

		c = 5;
		System.out.printf("%d%n", c); // print 5
		System.out.printf("%d%n", ++c); // vermeerder c met 1 en print de nieuwe waarde (6) <2>
		System.out.printf("%d%n", c); // print 6
		// end::voorbeeld2[]
	}
}
