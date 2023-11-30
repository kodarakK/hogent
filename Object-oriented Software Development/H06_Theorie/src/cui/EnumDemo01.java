package cui;

import java.util.EnumSet;
import java.security.SecureRandom;

import utils.Dag;
import static utils.Dag.*;

public class EnumDemo01 {

	public static void main(String[] args) {
		new EnumDemo01().voorbeeld();
	}

	private void voorbeeld() {
		toonAlleDagen();
		
		toonLangWeekend();

		SecureRandom random = new SecureRandom();
		//Dag.values() is een array van Dag
		int ordinaalWaarde = random.nextInt(Dag.values().length);
		Dag dag = Dag.values()[ordinaalWaarde];

		toonDagMetOrdinaalWaarde(ordinaalWaarde); 

		//default is NIET nodig als je alle constanten
		//voorziet in de case's
		String les = switch (dag) {
		case MAANDAG, WOENSDAG -> "andere les";
		case DINSDAG, DONDERDAG, VRIJDAG -> "les OOSDI";
		case ZATERDAG, ZONDAG -> "geen les";
		};
		
		System.out.println(les);
		
		
		
		
		System.out.printf("Van enum naar String: %s%n", dag.name());
		System.out.printf("van enum naar ordinaal waarde: %d%n", dag.ordinal());
		
		//Van String naar enum:
		Dag dag2 = Dag.valueOf("WOENSDAG");
		
		if (dag2 == WOENSDAG)
			System.out.println("waar");
	}

	private void toonAlleDagen() {
		System.out.printf("%nAlle dagen van de week: ");
//		values is een static methode
		for (Dag d : Dag.values()) {
			System.out.printf("%s ", d.name());
		}
	}

	private void toonLangWeekend() {
		System.out.printf("%nLang weekend: ");
		for (Dag d : EnumSet.range(VRIJDAG, ZONDAG)) {
			System.out.print(String.format("%s ", d.name()));
		}
	}

	private void toonDagMetOrdinaalWaarde(int ordinaalWaarde) {
		System.out.printf("%nDag ordinaalWaarde %d is %s%n", ordinaalWaarde, 
				Dag.values()[ordinaalWaarde]);
	}

}
