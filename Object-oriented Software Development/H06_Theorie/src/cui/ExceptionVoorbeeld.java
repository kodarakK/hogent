package cui;

import domein.Rechthoek;

public class ExceptionVoorbeeld {

	public static void main(String[] args) {
		new ExceptionVoorbeeld().start();
	}

	private void start() {
		
		try
		{
			Rechthoek rechthoek = new Rechthoek();
			
			rechthoek.setLengte(-1);
			
			System.out.println("in de try na -1");
		} catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("methode na -1");
		
		
	}

}
