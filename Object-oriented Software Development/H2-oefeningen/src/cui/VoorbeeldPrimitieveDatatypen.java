package cui;

public class VoorbeeldPrimitieveDatatypen
{

	public static void main(String[] args)
	{
		new VoorbeeldPrimitieveDatatypen().voorbeeld();
	}

	private void voorbeeld()
	{
		/*
		 * boolean
		 * int 
		 * double
		 * long (groot geheel getal)
		 * char		
		 */
		
		char kar = 'a';
		
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		System.out.println(max);
		
		max++;
		
		System.out.println(max);
		
		
		
		long maxlong = Long.MAX_VALUE;
		long minlong = Long.MIN_VALUE;
		
		System.out.println(maxlong);
		
		maxlong++;
		
		System.out.println(maxlong);
		
		
	}

}
