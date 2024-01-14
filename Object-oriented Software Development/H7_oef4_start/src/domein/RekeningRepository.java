package domein;

import java.util.List;

import persistentie.RekeningMapper;

public class RekeningRepository
{
	//TODO attributen + constructor  DONE
	private final RekeningMapper rm;
	final List<Rekening> rekeningen;
	
	public RekeningRepository()
	{
		rm = new RekeningMapper();
		rekeningen = rm.geefRekeningen();
	}



	//TODO getRekeningen DONE
	public List<Rekening> getRekening() {
		return rekeningen;
	}
	
	public void wijzigRekeningen()
	{
		//TODO
		for (Rekening rekening : rekeningen)
		{
			if (rekening instanceof SpaarRekening) 
				rekening.stortOp(rekening.getSaldo() * SpaarRekening.getAangroeiIntrest() / 100);
			
			
			if (rekening instanceof ZichtRekening eenZichtRekening)  
				eenZichtRekening.setMaxKredietOnderNul(eenZichtRekening.getMaxKredietOnderNul() - 10);
				
		}
		
	}
}

