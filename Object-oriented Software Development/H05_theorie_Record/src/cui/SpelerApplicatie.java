package cui;

import domein.DomeinController;
import dto.SpelerDTO;

public class SpelerApplicatie {

	private DomeinController dc;

	public SpelerApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		dc.registreer("Waerlop", "Tania", "tania@gmail.com");
		dc.registreer("Vanoverbeke", "Jan", "jan@gmail.com");
		
		dc.meldAan("tania@gmail.COM");
		SpelerDTO spelerInfo = dc.geefSpeler();
		uitvoer(spelerInfo);
		
		dc.meldAan("jan@Gmail.com");
		spelerInfo = dc.geefSpeler();
		uitvoer(spelerInfo);
		
		dc.meldAan("bestaatNiet@com");
		spelerInfo = dc.geefSpeler();
		// NOOIT: if (spelerInfo != null)
		uitvoer(spelerInfo);
	}

	private void uitvoer(SpelerDTO spelerInfo) {
		
		System.out.printf("Naam: %s%nVoornaam: %s%nKrediet: %.2f%nAdmin: %s%n%n",
		spelerInfo.naam(), spelerInfo.voornaam(),
		spelerInfo.krediet(), spelerInfo.adminRechten()?"JA":"NEE");
		
	}
	
	
}
