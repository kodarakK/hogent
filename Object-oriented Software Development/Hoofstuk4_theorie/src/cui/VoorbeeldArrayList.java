package cui;

import java.util.ArrayList;
import java.util.List;

public class VoorbeeldArrayList {

	public static void main(String[] args) {
		new VoorbeeldArrayList().start();
	}

	private void start() {
		List<String> colorList = new ArrayList<>(); 
		
		if (colorList.isEmpty())
			System.out.println("De lijst is leeg");

//ADD, REMOVE, SET, GET
//---------------------		
        colorList.add("red"); //achteraan toevoegen
        colorList.add("yellow");   //achteraan toevoegen
        colorList.add(1, "green"); //"green" toevoegen op index 1

        toonLijst("red, yellow en 'green op index 1' toegevoegd: ", colorList);
        
        if (!colorList.isEmpty())
			System.out.println("De lijst is niet leeg");
        
        
        String oudeKleur = colorList.set(1, "black"); //wijzig de kleur op index 1 naar black 
        System.out.printf("Het oorspronkelijke kleur was %s.%n", oudeKleur); 

        String kleur = colorList.get(2); //geef de kleur op index 2 terug
        System.out.printf("Kleur op index 2 is %s.%n%n", kleur); 
       
        colorList.add("black"); 
        
        toonLijst("gewijzigd op index 1: zwart en zwart achteraan toegevoegd: ", colorList);
        
        
        
        
        boolean verwijderd = colorList.remove("black"); //verwijder kleur black
        

        if (verwijderd)
        	toonLijst("remove(\"black\") uitgevoerd: ", colorList);
        
        
        
        
        kleur = colorList.remove(1);  //kleur op index 1 verwijderen
        System.out.printf("De kleur die verwijderd werd op index 1 was %s.%n", kleur);
        
        toonLijst("remove(1) uitgevoerd: ", colorList);
        
        
//CONTAINS, SIZE EN INDEXOF
//-------------------------       
        
        if (colorList.contains("black")) 
        {
            System.out.println("Kleur black komt voor");
        }
        
        System.out.printf("aantal getallen in de lijst: %d%n", colorList.size()); 

        int index = colorList.indexOf("black"); 
        if (index != -1) //geeft -1 terug indien het element niet voorkomt in de lijst
        {
            System.out.printf("kleur black komt voor op index %d%n", index);
        }
	    	
	}

	private void toonLijst(String titel, List<String> lijst) {
		//We gebruiken NOOIT een klassieke for-lus bij een dynamische lijst!
		//Om elementen van de lijst in een lus op te vullen of te wijzigen 
		//zal je leren in OOSDII.z
        System.out.println(titel);
		for (String element : lijst) 
			System.out.printf("%s ", element);
		System.out.println("\n");
	}

}
