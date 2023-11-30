package cui;
import java.util.Scanner;

public class H2_oef11
{

	public static void main(String[] args) {
		new H2_oef11().oef();
	}

	private void oef() {
		Scanner invoer = new Scanner(System.in);
		
		// opdracht1
		/*
		 Oefening1: Er wordt gevraagd om een strikt negatief oneven getal, 
		 in te voeren; de invoer wordt vervolgens gecontroleerd; 
		 indien deze niet voldoet, wordt een nieuwe waarde aan de gebruiker 
		 gevraagd.*/
        int getal;
        do {
        	System.out.print("Geef een strikt neg getal :");
        	getal = invoer.nextInt();
        	
        }while(getal > 0 || (getal%2) == 0); // getal1 < 0 && (getal1%2)!=0
        
		//opdracht2
		/*
		 Oefening2: Er wordt gevraagd om twee getallen in te geven. 
		 Het eerste getal moet verschillend van 1000 en mag niet deelbaar zijn door 12. 
		 Het tweede getal moet groter zijn dan het eerste getal. 
		 Indien de invoer niet voldoet, wordt een nieuwe waarde aan de gebruiker gevraagd.
		 */
		 int getal1, getal2;
		 do {
	        	System.out.print("Geef een getal != 1000 en niet deelbaar door 12 :");
	        	getal1 = invoer.nextInt();
	        	
	     }while(getal1 == 1000 || (getal1%12) == 0); //getal != 1000 && (getal%12)!=0
		 
		 do {
	        	System.out.printf("Geef een getal groter dan %d%n :", getal1);
	        	getal2 = invoer.nextInt();
	        	
	     }while(getal1 >= getal2); // getal2 > getal1
	}

}
