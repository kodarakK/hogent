package persistentie;

import java.util.ArrayList;
import java.util.List;

import domein.Bestelling;

public class BestellingMapper
{
	public List<Bestelling> geefBestellingen()
	{
		List<Bestelling> lijst = new ArrayList<>();
		
		// Bestelling 1: 4-gangen voor 6 personen;
		String[] gerechten1 = {"rundertartaar met truffel en radijs", "wildkroketjes met veenbessenconfituur", "gelakte zalm met zeewier en peulvruchten", "feestelijke chocoladecake"};
		Bestelling b1 = new Bestelling("De Jans John", 6, gerechten1);
		lijst.add(b1);
		
		// Bestelling 2: 3-gangen voor 3 personen;
		String[] gerechten2 = {"bietencarpaccio met notencrunch", "vergeten-groentenlasagne met geitenkaas", "dessertpannenkoekjes met mango en munt"};
		Bestelling b2 = new Bestelling("De Pauw Hilde", 3, gerechten2);
		lijst.add(b2);	
		
		// Bestelling 3: 3-gangen voor 5 personen;
		String[] gerechten3 = {"garnalentompoes met mango", "wildstoofpot met appeltjes en cranberry's", "dessertpannenkoekjes met mango en munt"};
		Bestelling b3 = new Bestelling("Piens Jeannine", 5, gerechten3);
		lijst.add(b3);
		
		// Bestelling 4: 4-gangen voor 2 personen;
		String[] gerechten4 = {"garnalentompoes met mango", "wildkroketjes met veenbessenconfituur", "wildstoofpot met appeltjes en cranberry's", "feestelijke chocoladecake"};
		Bestelling b4 = new Bestelling("Lammens Jacques", 2, gerechten4);
		lijst.add(b4);
		
		// Bestelling 5: 3-gangen voor 10 personen;
		String[] gerechten5 = {"bietencarpaccio met notencrunch", "gelakte zalm met zeewier en peulvruchten", "feestelijke chocoladecake"};
		Bestelling b5 = new Bestelling("Vermeiren Bart", 10, gerechten5);
		lijst.add(b5);	
		
		// Bestelling 6: 4-gangen voor 4 personen;
		String[] gerechten6 = {"garnalentompoes met mango", "dimsum met kreeft", "wildstoofpot met appeltjes en cranberry's", "dessertpannenkoekjes met mango en munt"};
		Bestelling b6 = new Bestelling("Van Assche Erik", 4, gerechten6);
		lijst.add(b6);
		
		return lijst;
	}
}
