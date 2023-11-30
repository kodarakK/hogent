package cui;
// Analyse van resultaten gebruikmakend van geneste controlestructuren.

import java.util.Scanner;

public class Analysis1
{
	public static void main(String[] args)
	{
		new Analysis1().countPassesAndFailures();
	}
	
	private void countPassesAndFailures()
	{
		Scanner input = new Scanner(System.in);

		// initialisatie van variabelen bij declaratie
		int passes = 0;
		int failures = 0;
		int result;

		// verwerk 10 studenten gebruikmakend van een tellergestuurde while-lus
		for (int studentCounter = 1; studentCounter <= 10; studentCounter++)
		{
			System.out.printf("Enter result %d (1 = pass, 2 = fail): ", studentCounter);
			result = input.nextInt();

			// if...else is genest in het while statement
			if (result == 1)
				passes++;
			else
				failures++;
		}

		System.out.printf("Passed: %d%nFailed: %d%n", passes, failures);

		// als er meer dan 8 studenten geslaagd zijn:
		if (passes > 8)
			System.out.println("Bonus to instructor!");
	}
}
