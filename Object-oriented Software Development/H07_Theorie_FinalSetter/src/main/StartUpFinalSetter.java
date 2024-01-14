package main;

import domein.Huisdier;
import domein.Kat;

public class StartUpFinalSetter {

	public static void main(String[] args) {
		new StartUpFinalSetter().start();
	}

	private void start() {

		try {
			Huisdier huisdier = new Huisdier(null);
			System.out.println(huisdier);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Huisdier kat = new Kat(null);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		Huisdier kat = new Kat("Garfield");
		System.out.println(kat);
	}

}
