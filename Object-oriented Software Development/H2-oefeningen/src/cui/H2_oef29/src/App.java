import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        new App().subOef1();
    }

    Scanner sc = new Scanner(System.in);

    private void subOef1() {
        int getal = geefGetal();
        int klGet = getal;
        int itter = 0;
        
        while (getal != -2000) {
            if (getal < klGet) itter++;
            klGet = getal;
            getal = geefGetal();
        }

        System.out.printf("Het aantal getallen dat direct gevolgd wordt door een kleiner getal is %d", itter);
    }

    private int geefGetal() {
        System.out.print("Geef een geheel getal (-2000 ): ");
        return sc.nextInt();
    }
}
