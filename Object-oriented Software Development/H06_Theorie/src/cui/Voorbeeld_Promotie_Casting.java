package cui;

public class Voorbeeld_Promotie_Casting {

	public static void main(String[] args) {
		new Voorbeeld_Promotie_Casting().voorbeeld();
	}

	private void voorbeeld() {
		double decGetal;
		int getal = 5;
		
		//Java gaat automatisch een conversie uitvoeren, 
		//we noemen deze conversie promotie
		//Er is bij promotie geen verlies aan informatie. 
		decGetal = getal; // 5.0
		
		getal = 'a'; 
		System.out.println(getal); //ASCII tabel
		//https://computersciencewiki.org/index.php/ASCII
		
//		getal = decGetal;
		/*Dergelijke conversies gaat Java niet automatisch doen. 
		  Het is wel mogelijk dergelijke conversie te forceren door gebruik te maken 
		  van een cast operator. Je gebruikt dergelijke operator dus op je eigen risico, 
		  je weet dat de gevraagde conversie kan leiden tot verlies aan informatie.*/
		decGetal = 4.8;
		getal = (int)decGetal;
		System.out.println(getal);
		
		int resultaat = (int)Math.pow(decGetal, 3);
		
	}

}
