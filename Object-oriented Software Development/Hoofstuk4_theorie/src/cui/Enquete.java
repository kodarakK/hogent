package cui;

public class Enquete {

	public static void main(String args[]) 
    {
    	new Enquete().startEnquete();
    }
	
	private void startEnquete()
    {
		int[] scores = { 5, 2, 5, 4, 3, 5, 2, 1, 5, 5, 1, 4, 3, 3, 4, 5, 5, 4, 2 };
		int[] resultaten = new int[5]; 

		for (int score : scores) { 
			resultaten[score - 1]++;
		}

		System.out.printf("%8s%8s%n", "Score", "Aantal");
		for (int resultaat = 0; resultaat < resultaten.length; resultaat++) {
			System.out.printf("%8d%8d%n", resultaat + 1, resultaten[resultaat]); 
		}

		System.out.printf("Totaal aantal antwoorden: %d%n", scores.length);
    } 
}
