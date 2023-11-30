package dto;

import java.math.BigDecimal;

public record SpelerDTO(String naam, String voornaam, BigDecimal krediet, boolean adminRechten) {
	// klasse SpelerDTO
	
	// GEEN setters!
	
	// ENKEL LEZEN!
	
	// naam(), komt overeen met getter
	// voornaam()
	/*
	 * krediet()
	 * adminRechten()
	 * */
	
	/*
	 * Contructor:
	 * 
	 * 4 argumenten => SpelerDTO(String naam, String voornaam, BigDecimal krediet, boolean adminRechten
	 * 
	 * 
	 * kunnen meerdere contructors met minder argumenten maken: zie oef Personage
	 * */
}
