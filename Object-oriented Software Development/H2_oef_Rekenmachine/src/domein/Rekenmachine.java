package domein;

public class Rekenmachine
{
	private double resultaat;
	
	public void telOp(double getal1, double getal2) {
		resultaat = getal1 + getal2;
		
	}
	
	public void trekAf(double getal1, double getal2) {
		resultaat = getal1 - getal2;
		
	}
	
	public void deel(double getal1, double getal2) {
		if (getal2 != 0) resultaat = getal1 / getal2;
		else resultaat = 0; // normaal exception
		
	}
	
	public void vermenigvuldig(double getal1, double getal2) {
		resultaat = getal1 * getal2;
	}

	public double getResultaat()
	{
		return this.resultaat;
	}
	
	
}
