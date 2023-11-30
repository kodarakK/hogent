package cui;
import java.util.Scanner;


public class H1_oefening10
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int omtrek, opp, lengte, breedte;
		
		System.out.print("Geef de lengte van de rechthoek in: ");
		lengte = sc.nextInt();
		System.out.print("Geef de breedte van de rechthoek in: ");
		breedte = sc.nextInt();
		
		omtrek = lengte*2+breedte*2;
		opp = lengte*breedte;
		System.out.printf("De omtrek = %d%nDe oppervlakte = %d", omtrek, opp);
		
	}

}
