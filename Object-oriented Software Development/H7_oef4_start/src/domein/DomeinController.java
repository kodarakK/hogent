package domein;

import java.util.ArrayList;
import java.util.List;

import dto.RekeningDTO;

public class DomeinController {

    //TODO attribuut + constructor
	private final RekeningRepository rr;
	
	public DomeinController() {
		rr = new RekeningRepository();
	}
	
	public List<RekeningDTO> geefRekeningDTOs()
	{
		// wijzig de lijst van de Repository en zet het daarna om naar een lijst van DTO's
		//TODO
		
		rr.wijzigRekeningen(); // fictief, enkel voor oef
		
		List<RekeningDTO> rekdto = new ArrayList<RekeningDTO>();
		
		for (Rekening r : rr.getRekening())
		{
			if (r instanceof SpaarRekening)
			{
				rekdto.add(new RekeningDTO(r.getRekeningNr(), r.getSaldo(), r.getHouder(), SpaarRekening.getAangroeiIntrest()));
			}
			
			else if (r instanceof ZichtRekening zr)
			{
				rekdto.add(new RekeningDTO(zr.getRekeningNr(), zr.getSaldo(), zr.getMaxKredietOnderNul(), zr.getHouder()));
				
			}
		}
		
		return rekdto;
		
	}
}
