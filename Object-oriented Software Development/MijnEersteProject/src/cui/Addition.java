package cui;
import java.util.Scanner;

public class Addition
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int number1, number2, sum;
		
		System.out.print("Geef eerste getal: ");
		number1 = sc.nextInt();
		
		System.out.print("Geef tweede getal: ");
		number2 = sc.nextInt();
		
		sum = number1 + number2;
		
		System.out.println("som is " + sum);
	}

}
