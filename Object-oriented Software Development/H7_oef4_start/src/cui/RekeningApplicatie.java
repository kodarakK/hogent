package cui;

import java.util.List;
import dto.RekeningDTO;
import domein.DomeinController;

public class RekeningApplicatie {

	private DomeinController dc;
	
	public RekeningApplicatie(DomeinController dc)
	{
		this.dc = dc;
	}

	public void werkenMetRekeningen()
	{
		List<RekeningDTO> lijstDTO = dc.geefRekeningDTOs();

		for (RekeningDTO dto : lijstDTO)
		{
			if (dto.soort() == 'Z')
				System.out.printf("%s %d op naam van %s heeft saldo van %.2f met %s van %.2f%n",
						"ZICHTREKENING",
								dto.rekeningNr(),
								dto.houder(),
								dto.saldo(),
								"maxKrediet",
								dto.maxKredietOnderNul());
				
			else {
				System.out.printf("%s %d op naam van %s heeft saldo van %.2f met %s van %.2f%n",
						"SPAARREKENING",
								dto.rekeningNr(),
								dto.houder(),
								dto.saldo(),
								"aangroeiIntrest",
								dto.aangroeiIntrest());
			}
		}
	}
}
