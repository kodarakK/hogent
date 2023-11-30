package cui;


import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Oef20_puntenverwerking {
    public static void main(String[] args) {
        new Oef20_puntenverwerking().start();
    }
    private Scanner sc = new Scanner(System.in);

    private static final int MIN_SCORE = 0;
    private static final int MAX_SCORE = 0;

    private void start() {
        String[] namen = {"Imani", "Tanaka", "Ayana", "Yaro", "Diara", "Lente", "Jin", "Sem", "Zaur", "Nyasha"};
        // List<String> studenten = new ArrayList<>(Array.asList(namen));
        List<String> studenten = Arrays.asList(namen);
        List<String> geslaagden = new ArrayList<>();
        List<String> nietGeslaagden = new ArrayList<>();

        int resultaat = 0;
        for (String naam : studenten) {
            resultaat = geefResult(naam);

            if (resultaat >= 10) {
                geslaagden.add(naam);
            } else {
                nietGeslaagden.add(naam);
            }
        }
        boolean allen_geslaagd = geslaagden.isEmpty();
        if (allen_geslaagd) {
            toonStudenten(geslaagden, "geslaagd");
        }

        toonStudenten(nietGeslaagden, "niet geslaagd");
    }

    private void toonStudenten(List<String> namen, String keuze) {
            System.out.printf("volgende studenten zijn %s.", keuze);
            for (String string : namen) {
                System.out.println(string);
            }

    }

    private int geefResult(String naam) {
        int result;
        boolean geldig;
        
        do {
            System.out.print("Geef resultaat van %s (0-20) > ");
            result = sc.nextInt();
            geldig = result > MIN_SCORE && result < MAX_SCORE; 
            if (!geldig) 
                System.out.printf("Een geldig resultaat ligt tussen %d en %d!", MIN_SCORE, MAX_SCORE);
        } while (!geldig);
    
        return result;
    }
}
