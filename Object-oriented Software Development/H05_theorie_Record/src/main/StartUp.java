package main;

import cui.SpelerApplicatie;
import domein.DomeinController;

public class StartUp {

	public static void main(String[] args) {
		DomeinController dc = new DomeinController();
		SpelerApplicatie spelerApplicatie = new SpelerApplicatie(dc);
		spelerApplicatie.start();
	}

}