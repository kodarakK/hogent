package cui;

import domein.DomeinController;
import dto.VoorwerpDTO;

public class VoorwerpApplicatie
{
	
	private DomeinController dc;

	public VoorwerpApplicatie(DomeinController dc)
	{
		this.dc = dc;
	}
	
	public void start() {
		System.out.println("Beginsituatie: \n");
		toonOverZicht();

		dc.voegWapenToe("Long Rifle", 1.250, 4, 99, false);
		dc.voegSleutelToe("Garagedeur", 0.500, 4, 3);

		dc.voegWapenToe("Hagel Geweer", 0.750, 1, 35, true);
		dc.voegSleutelToe("Tuinhuisdeur", 0.500, 10, 4);
		
		System.out.println("Na het toeveogen van enkele wapens en sleutels: \n");
		toonOverZicht();
			
	}
	
	private void toonOverZicht() {
		VoorwerpDTO[] voorwerpdtos = dc.geefVoorwerpDTOs();
		
		for (VoorwerpDTO vw : voorwerpdtos) {
			System.out.printf(
					"%s %s met gewicht %.3f kg uit niveau %d ",
					vw.naamVoorwerp(),
					vw.naam(),
					vw.gewicht(),
					vw.niveau()
					);
			switch (vw.soort()) {
				case 'W' -> {
					System.out.printf(
						"en met kracht %d %s gebruikt.%n",
						vw.kracht(),
						vw.gebruikt()?"al":"nog niet"
						);
				}
				case 'S' -> {
					System.out.printf(
							"past op deur %d.%n",
							vw.deur()
							);
					System.out.printf(
							"Er zijn %d sleutel(s) in omloop.%n",
							vw.aantalInOmloop()
							);
				}
			
			}
		}
	}
}


