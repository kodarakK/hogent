package main;

import domein.DomeinController;

public class StartUpPolymorfismeDierenWinkel {

	public static void main(String[] args) 
	{
		new StartUpPolymorfismeDierenWinkel().start();
	}

	private void start() {
		DomeinController dc = new DomeinController();
		
		dc.initialiseerDierenWinkel();
		
		String[] overzicht = dc.stelDierenVoor();
		for (String eenDier : overzicht)
			System.out.println(eenDier);
		System.out.println();
		
		System.out.println(dc.geefSpuitjes());
		
	}
}
