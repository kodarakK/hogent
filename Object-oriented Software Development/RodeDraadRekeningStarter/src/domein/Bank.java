package domein;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	
	private List<Rekening> rekeningen = new ArrayList<>();

	public void voegRekeningToe(Rekening rekening) {
		//TODO 
		if (rekening != null)
			rekeningen.add(rekening);
	}
	
	public List<Rekening> getRekeningen() {
		return rekeningen;
	}

	public Rekening geefRekening(int indexVanRekening) {
		//TODO
		if (indexVanRekening < 0 || indexVanRekening >= rekeningen.size())    // < 0 >= size()
			return null;
		return  rekeningen.get(indexVanRekening);  //get 
	}

}
