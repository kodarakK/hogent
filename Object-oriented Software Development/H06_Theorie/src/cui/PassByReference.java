package cui;

import domein.Rechthoek;

public class PassByReference {

	public static void main(String[] args) {
		new PassByReference().voorbeeld();
	}
			
	private void voorbeeld() {
		Rechthoek rechthoek = new Rechthoek(10,20);
		
		wijzigRechthoek(rechthoek);
		System.out.println(rechthoek.toString());
		
		nieuweRechthoek(rechthoek);
		System.out.println(rechthoek);
//		              is hetzelfde als rechthoek.toString()
	}

	/*wanneer als argument een referentie wordt doorgegeven
	  dan zal de formele parameter een kopie van de referentie bevatten; 
	  op dat moment heb je dus twee referenties naar éénzelfde object
	*/ 
	private void wijzigRechthoek(Rechthoek rechthoek) {
		//wijzigingen aan de attributen, aan het object via 
		//de formele parameter referentie, 
		//worden doorgevoerd
		rechthoek.setLengte(100);
		rechthoek.setBreedte(80);	
	}
	
	private void nieuweRechthoek(Rechthoek rechthoek) {
		rechthoek = new Rechthoek(1,2);
		//de kopie wijst naar een ander object, maar de
		//referentie van het oorspronkelijk object WIJZIGT NIET
	}
		
}
