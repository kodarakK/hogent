package cui;

import domein.DomeinController;
import dto.DoosDTO;

public class DoosApplicatie {

	private final DomeinController dc;
	
	public DoosApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		dc.maakDoos();
		drukOverzichtDozenAf();
		dc.maakDoos("oranje");
		dc.maakDoos(10.5, 20.5, 30.5);
		dc.maakDoos(5.5, 6.5, 7.5, "geel");
		drukOverzichtDozenAf();
		
		try
		{
			dc.maakDoos(10, 0, 20);
		} catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
	}
	

	public void drukOverzichtDozenAf() {
		DoosDTO[] dozenDTO = dc.geefAlleDozen();

		int nummer = 1;
		int aantalDozen = dc.geefAantalDozen();

		System.out.printf("Er werd%s %d %s aangemaakt:%n", aantalDozen==1?"":"en", aantalDozen,
		aantalDozen==1?"doos":"dozen");

		for (DoosDTO doosDTO : dozenDTO)
		{
			System.out.printf("%d. Doos van %.2f x %.2f x %.2f; kleur: %s;unieke code: %s.%n",
					nummer++, doosDTO.lengte(),
							  doosDTO.breedte(),
							  doosDTO.hoogte(),
							  doosDTO.kleur(),
							  doosDTO.code());
		}
	}
}