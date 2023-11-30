package cui;

public class PassByValue {

	public static void main(String[] args) {
		new PassByValue().voorbeeld();
	}
			
	private void voorbeeld() {
//		lokale variabelen
		int lengte = 10;
		int breedte = 20;	
		String figuur = "rechthoek";
		
		/* via pass-by-value kan de waarde van een argument 
		 * NIET gewijzigd worden in een een methode.*/
		wijzigParametersDezelfdeNaam(figuur, lengte, breedte);
		System.out.printf("%s Lengte = %d, breedte = %d%n", figuur, lengte, breedte);
    
		//Idem
		wijzigParametersAndereNaam(lengte, breedte);
		System.out.printf("%s Lengte = %d, breedte = %d%n", figuur, lengte, breedte);
	    
	}
	
/*De formele parameter bevat een kopie van de waarde van het 
argument en wijzigingen aan de formele parameter hebben dus 
geen effect op het doorgegeven argument*/
	
	public void wijzigParametersDezelfdeNaam(String figuur, int lengte, int breedte) {
		lengte = 100;
		breedte = 100;
		figuur = "vierkant";
	}
	
	public void wijzigParametersAndereNaam(int parLengte, int parBreedte) {
		//temp is een lokale variabele
		int temp = parLengte; 
		parLengte = parBreedte;
		parBreedte = temp;
	}
	
}
