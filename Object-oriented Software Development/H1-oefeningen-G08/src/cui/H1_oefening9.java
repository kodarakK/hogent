package cui;
import java.util.Scanner;

public class H1_oefening9
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		String maandSalaris, jaarSalaris, vakantieGeld;
//		System.out.print("jkjdf: ");
//		double idk = sc.nextDouble();
		System.out.print("Geef maandsalaris  in euro: ");
		maandSalaris = sc.nextLine();
		double msD = Double.parseDouble(maandSalaris);
		
		double jsD = 12 * msD;
		double vgD = (jsD/ 100) * 8;
		
		System.out.printf("jaarsalaris = %.2f €%n"
				+ "vakantiegeld = %.2f €", jsD, vgD);
	}

}
