package cui;

public class Interest
{
	public static void main(String[] args)
	{
		new Interest().calculateAmountOnDeposit();
	}
	
	private void calculateAmountOnDeposit()
	{
		double amount; // saldo op het einde van elk jaar <1>
		double principal = 1000.0; // beginkapitaal
		double rate = 0.05; // rente

		// hoofdingen: veldbreedte 4 en veldbreedte 20
		System.out.printf("%s%20s%n", "Year", "Amount on deposit");

		// bereken het saldo voor elk jaar
		for (int year = 1; year <= 10; year++)
		{
			amount = principal * Math.pow(1.0 + rate, year); // <2>

			// toon het jaar en het saldo terug op veldbreedte 4 en 20
			System.out.printf("%4d%,20.2f%n", year, amount); // <3>
		} // end for

	} // end main
} // end class Interest
