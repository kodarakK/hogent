package cui;
import java.util.Scanner;

public class H2_oef9
{

	public static void main(String[] args)
	{
		H2_oef9 app = new H2_oef9();
//		app.input1();
		app.input2();
//		app.input3();
	}

	private void input3()
	{
		System.out.println("N\t10*N\t100*N\t1000*N");
		for (int i = 1; i < 6; i++) {
			System.out.println(i+"\t"+i*10+"\t"+i*100+"\t"+i*1000);
		}
		
	}

	private void input2()
	{
		Scanner sc = new Scanner(System.in);
		int evenGet = 0, deelbaar3Get = 0;
		for (int i = 0; i < 5; i++) {
			System.out.println("Geef getal "+i+": ");
			int j = sc.nextInt();
			if ((j%2) == 0) {
				evenGet++;
			}
			if ((j%3) == 0) {
				deelbaar3Get++;
			}
		}
		System.out.printf("Je gaf %d even getallen en %d getallen deelbaar door 3", evenGet, deelbaar3Get);
		System.out.printf("je gaf %d enven %s in en %d %s deelbaar door 3,",
				evenGet,
				evenGet == 1 ? "getal" : "getallen",
				deelbaar3Get,
				deelbaar3Get == 1 ? "getal" : "getallen");
		
	}

	private void input1()
	{
		Scanner sc = new Scanner(System.in);
		int som = 0;
		for (int i = 0; i < 5; i++) {
			System.out.println("Geef getal "+i+": ");
			som += sc.nextInt();
		}
		System.out.println("De som van de getallen = "+som);
		
	}

}
