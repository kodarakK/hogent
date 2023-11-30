package cui;
import java.util.Scanner;

public class H1_oefening11
{
  public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  
	  int getal, dt, ht, tt, eh;
	  
	  System.out.print("Geef een getal (> 999 en <=9999) in: ");
    getal = sc.nextInt();
    dt = getal / 1000;
    ht = (getal-dt*1000) / 100;
    tt = (getal-dt*1000-ht*100) / 10;
    eh = (getal-dt*1000-ht*100-tt*10);
    System.out.printf("%d duizendtallen%n%d hondertallen%n%d tientallen%n%d eenheden", dt, ht, tt, eh);
  }
}
