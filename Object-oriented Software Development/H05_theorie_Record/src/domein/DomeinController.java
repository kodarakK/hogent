package domein;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import dto.SpelerDTO;

public class DomeinController {

	private SpelerRepository spelerRepository;
	private Speler speler;

	public DomeinController()
	{
		spelerRepository = new SpelerRepository();
	}
	
	public void registreer(String naam, String voornaam, String email) {
		Speler speler = new Speler(naam, voornaam, email);
		spelerRepository.voegSpelerToe(speler);
	}

	public void meldAan(String email) {
		speler = spelerRepository.geefSpeler(email);
	}

	public SpelerDTO geefSpeler() {
		if (speler == null)
			return new SpelerDTO("onbekend", "onbekend", BigDecimal.ZERO, false);
		
		return new SpelerDTO(speler.getNaam(), speler.getVoornaam(), speler.getKrediet(), speler.isAdminRechten());
	}
	
	// !Dit is een examen vraag!
	
	public List<SpelerDTO> geefSpelers() {
		List<Speler> spelers = spelerRepository.getSpelers();
		List<SpelerDTO> dto = new ArrayList<>();
		for (Speler speler : spelers)
		{
			SpelerDTO spelerDTO = new SpelerDTO(speler.getNaam(), speler.getVoornaam(), speler.getKrediet(), speler.isAdminRechten());
			dto.add(spelerDTO);
			/*
			 * OF
			 * 
			 * dto.add(new SpelerDTO(speler.getNaam(), speler.getVoornaam(), speler.getKrediet(), speler.isAdminRechten()));
			 * */
		}
		return dto;
	}
}
