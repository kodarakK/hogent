

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        new App().subOef1();
    }

    Scanner sc = new Scanner(System.in);

    private void subOef1() throws Exception {
        int getal = geefGetal();
        int teller = 0;

        while (getal != 1) {
            switch (getal%2) {
                case 0  -> getal = getal / 2;
                default -> getal = getal * 3 + 1;
            }
            teller++;
        }

        System.out.printf("Het getal wijzigt %d keer", teller);
    }

    private int geefGetal() {
        int getal; 
        do {
            System.out.println("Geef een strikt positief getal in: ");
            getal = sc.nextInt();
        } while(getal <= 0);
        return getal;
    }
}
