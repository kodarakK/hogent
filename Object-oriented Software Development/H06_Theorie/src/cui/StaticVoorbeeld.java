package cui;

import domein.Rechthoek;

public class StaticVoorbeeld {

	public static void main(String[] args) {
		
		new StaticVoorbeeld().start(); //methode start wordt gestuurd naar het object van StaticVoorbeeld
	}
	
	private void start() {
		//Het oproepen van de static methode getAantalRechthoeken van Rechthoek:
		System.out.println(Rechthoek.getAantalRechthoeken());
		
		Rechthoek rechthoek1 = new Rechthoek();
		
		
		Rechthoek rechthoek2 = new Rechthoek();
		System.out.println(Rechthoek.getAantalRechthoeken());
	}

}
