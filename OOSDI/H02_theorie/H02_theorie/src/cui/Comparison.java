package cui;

import java.util.Scanner;

public class Comparison
{
    // main method start de uitvoering van Java applicatie

    public static void main(String[] args)
    {
    	new Comparison().compare2Numbers();
    }
    		
    private void compare2Numbers()
	{
		// creëer een object van Scanner; voor invoer vanaf het toetsenbord
        Scanner input = new Scanner(System.in);

        int number1;          // eerste getal om te vergelijken
        int number2;          // tweede getal om te vergelijken

        System.out.print("Enter first integer: "); // prompt
        number1 = input.nextInt(); // leest eerste getal van de gebruiker

        System.out.print("Enter second integer: "); // prompt 
        number2 = input.nextInt(); // leest tweede getal van de gebruiker

        if (number1 == number2) // <1>
        {
            System.out.printf("%d == %d%n", number1, number2); // <2>
        }

        if (number1 != number2)
        {
            System.out.printf("%d != %d%n", number1, number2);
        }

        if (number1 < number2)
        {
            System.out.printf("%d < %d%n", number1, number2);
        }

        if (number1 > number2)
        {
            System.out.printf("%d > %d%n", number1, number2);
        }

        if (number1 <= number2)
        {
            System.out.printf("%d <= %d%n", number1, number2);
        }

        if (number1 >= number2)
        {
            System.out.printf("%d >= %d%n", number1, number2);
        }
    } // methode main
}
