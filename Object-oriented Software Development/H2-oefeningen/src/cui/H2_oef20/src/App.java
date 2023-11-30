import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        new App().subOef1();
    }
    private void subOef1() {
        int getal;
        int opEenNa = Integer.MIN_VALUE;
        int grootste = Integer.MIN_VALUE;

        getal = geefGetal(1);
        for (int i = 2; i < 11; i++) {
            

            if (getal > grootste) {
                grootste = getal;
            }

            if (getal < grootste && getal > opEenNa) {
                opEenNa = getal;
            }
            getal = geefGetal(i);
        }
        if (opEenNa != Integer.MIN_VALUE)
            System.out.printf("Het op één na grootste getal is %d", opEenNa);
    }
    
    Scanner sc = new Scanner(System.in);

    private int geefGetal(int nummer) {
        System.out.printf("Geef getal %d in: ", nummer);
        return sc.nextInt();
    }
}
