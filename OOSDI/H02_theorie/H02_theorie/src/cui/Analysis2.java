package cui;
// Analyse van resultaten gebruikmakend van geneste controlestructuren.

import java.util.Scanner;

public class Analysis2
{
	public static void main(String[] args)
	{
		new Analysis2().countPassesAndFailures();
	}
	
	private void countPassesAndFailures()
	{
		// initialisatie van variabelen bij declaratie
		int passes = 0;
		int failures = 0;
		int studentCounter = 1;// wordt hier gebruikt in de vraagstelling
		int result;

		// verwerk een aantal studenten gebruikmakend van een while-lus met schildwacht
		result = askResult(studentCounter); // <1>
		while (result != 0)
		{
			// if...else is genest in het while statement
			if (result == 1)
				passes++;
			else
				failures++;

			// verhoog studentCounter
			studentCounter++;
			result = askResult(studentCounter); // <1>
		}

		System.out.printf("Passed: %d%nFailed: %d%n", passes, failures);
	}

	private int askResult(int studentCounter) // <2>
	{
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter result %d (0 = stop, 1 = pass, 2 = fail): ", studentCounter);
		return input.nextInt();
	}
}
