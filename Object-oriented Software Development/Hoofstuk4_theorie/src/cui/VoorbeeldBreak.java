package cui;

public class VoorbeeldBreak {

	public static void main(String[] args)
	{
		new VoorbeeldBreak().voorbeeld();
	}

	private void voorbeeld() {
		int[] getallen = {2, 5, 4, 1, 1, 4};
		
		//Komt 1 voor in de array?
		boolean gevonden = false;
		int teZoekenGetal = 1;
		
		for(int getal : getallen)
		{
			if(getal == teZoekenGetal) {
				gevonden = true;
				break;
			}
		}
		
		gevonden = zoekGetal(getallen, teZoekenGetal);
		
		System.out.printf("Gevonden : %s%n", gevonden?"JA":"NEE");
		
	}

	private boolean zoekGetal(int[] getallen, int teZoekenGetal)
	{
		for(int getal : getallen)
		{
			if(getal == teZoekenGetal) {
				return true;
			}
		}
		return false;
	}

}
