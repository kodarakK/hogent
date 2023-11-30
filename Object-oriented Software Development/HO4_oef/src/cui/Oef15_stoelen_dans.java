package cui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Oef15_stoelen_dans
{
    public static void main(String[] args) {
        new Oef15_stoelen_dans().start();
    }

    private Scanner sc = new Scanner(System.in);

    private void start() {
        // List<String> namen = new ArrayList<>();
        /*namen.add("Mo");
        namen.add("To");
        namen.add("Bo");
        namen.add("Jo");
        namen.add("Co");*/

        String[] namen = {"Mo", "To", "Bo", "Jo", "Co"};
        List<String> kinderen = new ArrayList<>(Arrays.asList(namen));
        String afvaller;
        int ronde = 1;

        System.out.printf("We starten de stoelendans met %s%n", kinderen);

        do {
            System.out.printf("Ronde %d %s%n", ronde, kinderen);
            afvaller = geefAfvaller(kinderen);
            boolean verwijderd = kinderen.remove(afvaller);
            if (!verwijderd) 
                System.out.printf("Let op! %s neemt niet deel aan de stoelendans...", afvaller);
            else ronde++;
        } while (kinderen.size() != 1);

        System.out.printf("Proficiat %s! Je hebt de stoelendans gewonnen!", kinderen.get(0));

        

    }

    private String geefAfvaller(List<String> namen) {
        System.out.println("geef de naam van de afvaller op: ");
        return sc.nextLine();
    }
}
