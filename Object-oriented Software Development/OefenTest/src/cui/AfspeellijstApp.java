package cui;

import domein.Lied;
import java.util.Scanner;

public class AfspeellijstApp {

    public static void main(String[] args) {
        new AfspeellijstApp().start();
    }

    private Scanner sc = new Scanner(System.in);

    private void start() {
        int aantalLijsten = aantalAfspeellijsten();
        int totSec = 0;
        boolean dansbaar = false; 

        for(int aantal = 1; aantal <= aantalLijsten; aantal++) {
            
            System.out.printf("%nGeef de details van de liedjes voor afspeellijst %d", aantal);
            for (int i = 1; i <= 3; i++) {
                System.out.printf("%nLied %d - duur (min): ", i);
                double duur = sc.nextDouble();

                System.out.printf("Lied %d - beats (min): ", i);
                int beats = sc.nextInt();

                Lied lied = new Lied(duur, beats);

                dansbaar = (lied.getBeatsPerMinute() > 90)?true:false;
                totSec += lied.geefDuurInSeconden();
                System.out.printf("-> je koos voor een %s nummer van %d bpm%n", lied.geefTempo(), lied.getBeatsPerMinute());
            }

            System.out.printf("%nAfspeellijst %d is %s!%n", aantal, dansbaar?"dansbaar":"niet dansbaar");
            
        }

        System.out.printf("%nDe%sduur van de afspeellijst%s is %d seconden.",
                            aantalLijsten==1?" ":" gemiddelde ", 
                            aantalLijsten==1?"":"en",
                            (int)(totSec/aantalLijsten));

    }

    private int aantalAfspeellijsten() {
        int aantal;
        boolean geldig;

        do {
            System.out.print("Hoeveel afspeellijsten wil je maken? ");
            aantal = sc.nextInt();
            geldig = aantal >= 1 && aantal <= 5;
        } while (!geldig);
        
        return aantal;
    }
}
