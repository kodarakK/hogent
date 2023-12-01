package main;

// import java.util.ArrayList;
import java.util.List;

import domein.Duif;
import domein.Hond;
import domein.Huisdier;
import domein.Kat;

public class StartUpPolymorfisme1 {

	public static void main(String[] args) 
	{
		new StartUpPolymorfisme1().start();
	}

	//polymorfisme: de term veelvormigheid komt vanuit het feit dat 
	//een object vele vormen kan aannemen. In dit geval kan een 
	//Huisdier een Kat, Hond of Duif zijn. 
	private void start() {
		Huisdier huisdier = new Huisdier("Nijntje");
		Huisdier kat = new Kat("Musti");
		Huisdier hond = new Hond("Rintje");
		Huisdier duif = new Duif("Wittekop", 20201234567L);
		
//		this.getClasst().getSimpleName();
//		JAVA kijkt hoe je de klasse hebt gecreëerd
//		Huisdier kat = new Kat("Musti"); --> dir object behoort tot de Kat-Klasse 
		
		System.out.println("Dit zijn de huisdieren:");
		System.out.println(huisdier); 
		System.out.println(kat); 
		System.out.println(hond);
		System.out.println(duif);
		System.out.println();

		System.out.println("Ze kunnen ook allemaal een soort van geluid maken...");
		System.out.printf("%s maakt geluid %s%n", huisdier.getNaam(), huisdier.maakGeluid());
		
//dynamic of runtime polymorfisme:
//-------------------------------	
/*Maar de grote kracht van polymorfisme ligt in de dynamische binding. 
 Bij het runnen van de code wordt namelijk gekeken naar het werkelijke object 
 (hier: een Kat) en wordt onderzocht of de methode (hier: maakGeluid) 
 in deze klasse zelf voorkomt. Indien dit (zoals hier) het geval is, 
 dan wordt deze code uitgevoerd. 
 Indien niet (bv. getNaam()), dan gaan we in de hiërarchie omhoog via de 
 directe superklasse en eventuele indirecte superklasses 
 tot we ergens de methode tegenkomen.*/		
		System.out.printf("%s maakt geluid %s%n", kat.getNaam(), kat.maakGeluid());
		
		System.out.printf("%s maakt geluid %s%n", hond.getNaam(), hond.maakGeluid());
		System.out.printf("%s maakt geluid %s%n", duif.getNaam(), duif.maakGeluid());
		System.out.println();
		
		
		System.out.println("En de kat en de hond kunnen tenslotte nog iets bijzonders:");
//static of compile-time polymorfisme: 
//-----------------------------------	
//Dankzij static binding gaat 
//de compiler eerst op zoek naar de methode in de klasse van je referentie. 

//Methode spin en kwispel komen NIET voor in klasse Huisdier
//Dat betekent dat we een compilatiefout krijgen bij kat.spin() en hond.kwispel()
				
		// System.out.println(kat.spin());  ==> compileer fout
		// System.out.println(hond.kwispel());        "
//Oplossing 1: 		
		//downcasten naar een Kat:
		// double decGetal = 5.3;
		// int getal = (int)decGetal;
		
//		SLECHTE OPLOSSING
		
		Kat deKat = (Kat)kat;
		
		System.out.println(deKat.spin());

		try {
			Kat deKat2 = (Kat)duif;
			System.out.println(deKat2.spin());
		} catch (ClassCastException e) {
			// TODO: handle exception
			System.out.println("een duif is geen kat");
		}


//Oplossing 2:		
		//Je kan casten van een bepaald supertype naar een subtype.
		//Om te checken of een object wel van een bepaald subtype is,
		//gebruik je instanceof. 
		
		// ook polimorfisme: ArrayList is een implementatie klasse van List
		// List<Huisdier> eigenDieren = new ArrayList<>();
		// eigenDieren.add(new Kat("Musti"));
		// eigenDieren.add(new Hond("Fluffy"));
		List<Huisdier> eigenDieren = List.of(new Kat("Musti"), new Hond("Fluffy"), 
											 new Duif("Wittekop", 20201234567L),
											 new Kat("Poezie"),
											 new Hond("Maika"));

		for (Huisdier huisdier2 : eigenDieren) {
			// behoort het object "huisdier2" tot de klasse Kat?
			// zoja, Kat eenKat = (Kat)huisdier2;
			// ER KOMT ZO'N EXAMEN VRAAG
			if (huisdier2 instanceof Kat eenKat)
				System.out.printf("Het bijzondere wat een %s kan, is %s%n", huisdier2.getClass().getSimpleName(), eenKat.spin());
			if (huisdier2 instanceof Hond eenHond)
				System.out.printf("Het bijzondere wat een %s kan, is %s%n", eenHond.getClass().getSimpleName(), eenHond.kwispel());		
		}
		
		//System.out.printf("Het bijzondere wat een %s kan, is %s%n", kat.getClass().getSimpleName(), kat.spin());
		//System.out.printf("Het bijzondere wat een %s kan, is %s%n", hond.getClass().getSimpleName(), hond.kwispel());		
	}
}
