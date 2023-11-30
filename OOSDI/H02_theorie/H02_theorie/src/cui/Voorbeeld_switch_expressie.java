package cui;

public class Voorbeeld_switch_expressie
{
	public static void main(String[] args)
	{	
		new Voorbeeld_switch_expressie().gebruik_switch();
	}
	
	private void gebruik_switch()
	{
		int x = 5;
		int k = switch (x)
				{
					case 1, 2 -> 7;
					case 3, 5, 7 -> 9;
					default -> 0;
				};	
		System.out.println("k = " + k);
	}
}