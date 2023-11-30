package cui;

public class Voorbeeld_Recursie {

	public static void main(String[] args) {
		new Voorbeeld_Recursie().voorbeeld();
	}
	
	private void voorbeeld() {
		for (int i=0; i < 5; i++)
		{
			System.out.printf("faculteit van %d is %d%n", i, faculteit(i));	
		}
		
		try
		{
			long resultaat = faculteit(-1);
			System.out.printf("resultaat zullen we niet zien: %d%n", resultaat);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		for (int i=0; i < 5; i++)
		{
			System.out.printf("fibonacci van %d is %d%n", i, fibonacci(i));
		}
		
	}

	public long faculteit(int getal) { 
		if (getal < 0) // anders stackoverflow error ==> foute recursie
			throw new IllegalArgumentException("Geen natuurlijk getal");
		if (getal == 0) 
			return 1; 
		return getal * faculteit(getal - 1); 
	}

	public long fibonacci(int getal) {
		if (getal < 0)
			throw new IllegalArgumentException("Geen natuurlijk getal");
		if ((getal == 0) || (getal == 1)) 
			return getal; 
		return fibonacci(getal - 1) + fibonacci(getal - 2); 
	}
}
