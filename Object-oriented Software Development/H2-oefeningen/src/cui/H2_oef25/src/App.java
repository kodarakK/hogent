import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        new App().subOef1();
    }

    private Scanner sc = new Scanner(System.in);

    private void subOef1() {
        int deler = geefGetal("deler");
        int noemer = teller();
        
        int rest = deler%noemer;

        System.out.printf("%d/%d = %d\n", deler, noemer, (int)(deler/noemer));
        System.out.printf("rest = %d\n", rest);
        
        if (rest == 0) System.out.printf("Vereenvoudigde breuk = %d/1", (int)(deler/noemer));

    }

    private int geefGetal(String breukdeel) {
        int noemer;
        do {
            System.out.printf("Geef de %s in van de breuk: ", breukdeel);
            noemer = sc.nextInt();
        } while (noemer == 0);
        
        return noemer;
    }

    private int teller() {
        System.out.printf("Geef de teller in van de breuk: ");
        return sc.nextInt();
    }
}
