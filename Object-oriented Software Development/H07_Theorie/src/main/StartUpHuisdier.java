package main;

import domein.Duif;
import domein.Hond;
import domein.Huisdier;
import domein.Kat;

public class StartUpHuisdier 
{
	public static void main(String[] args) 
	{
		new StartUpHuisdier().start();
	}
		
	private void start()
	{
//		TIJDELIJK
		Huisdier huisdier = new Huisdier("Nijntje");
		
		
		Kat kat = new Kat("Musti");
		Hond hond = new Hond("Rintje");
		Duif duif = new Duif("Wittekop", 20201234567L);
		
		/*
		 * protected moethode is niet zichtbaar in een andere package
		 * kat.voorbeeldProtected();
		 */
		
		System.out.println("Dit zijn de huisdieren:");
		System.out.println(huisdier);
		System.out.println(kat);
		System.out.println(hond);
		System.out.println(duif);
		System.out.println();
		
		
		System.out.println("Ze kunnen ook allemaal een soort van geluid maken...");
		System.out.printf("%s maakt geluid %s%n", huisdier.getNaam(), huisdier.maakGeluid());
		System.out.printf("%s maakt geluid %s%n", kat.getNaam(), kat.maakGeluid());
		System.out.printf("%s maakt geluid %s%n", hond.getNaam(), hond.maakGeluid());
		System.out.printf("%s maakt geluid %s%n", duif.getNaam(), duif.maakGeluid());
		System.out.println();
		
		
		System.out.println("En de kat en de hond kunnen tenslotte nog iets bijzonders:");
		System.out.printf("Het bijzondere wat een %s kan, is %s%n", kat.getClass().getSimpleName(), kat.spin());
		System.out.printf("Het bijzondere wat een %s kan, is %s%n", hond.getClass().getSimpleName(), hond.kwispel());
	}
}
