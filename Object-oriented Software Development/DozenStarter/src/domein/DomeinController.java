package domein;

import java.util.ArrayList;
import java.util.List;

import dto.DoosDTO;

public class DomeinController
{
	List<Doos> dozen;
	
	public DomeinController() {
		dozen = new ArrayList<>();
	}
	
	public void maakDoos() {
		dozen.add(new Doos());
	}
	
	public void maakDoos(String kleur) {
		dozen.add(new Doos(kleur));
	}
	
	public void maakDoos(double lengte, double breedte, double hoogte) {
		dozen.add(new Doos(lengte, breedte, hoogte));
	}
	
	public void maakDoos(double lengte, double breedte, double hoogte, String kleur) {
		dozen.add(new Doos(lengte, breedte, hoogte, kleur));
	}
	
	public DoosDTO[] geefAlleDozen() {
		DoosDTO[] resultaat = new DoosDTO[dozen.size()];
		
		int index = 0;
		for (Doos doos : dozen)
		{
			resultaat[index++] = new DoosDTO(doos.getLengte(), doos.getBreedte(), doos.getHoogte(), doos.getKleur(), doos.getCode());
		}
		
		return resultaat;
	}
	
	public int geefAantalDozen() {
		return Doos.getAantalDozenGemaakt();
	}
	
	
	
	
}
