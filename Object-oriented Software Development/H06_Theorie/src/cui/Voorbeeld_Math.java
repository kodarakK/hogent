package cui;

//import java.lang.Math

public class Voorbeeld_Math {

	public static void main(String[] args) {
		new Voorbeeld_Math().voorbeeld();
	}

	//https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Math.html
	
	private void voorbeeld() {
//		attr: public static final
		System.out.printf("%.10f%n", Math.PI);
		
//		static methodenn een static methode sturen we naar de klasse
		
		//absolute waarde
		System.out.printf("%.1f%n", Math.abs(-5.3));
				
		//vierkantwortel
		System.out.printf("%.1f%n", Math.sqrt(49));
		
		//machtsverheffen
		System.out.printf("%.0f%n", Math.pow(2, 3));
		
		//naar boven afronden
		System.out.printf("%.1f%n", Math.ceil(4.5));
		
		//naar beneden afronden
		System.out.printf("%.1f%n", Math.floor(4.5));
		
	}

}
