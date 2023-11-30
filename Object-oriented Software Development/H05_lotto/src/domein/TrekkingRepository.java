package domein;

import java.util.*;

public class TrekkingRepository
{

	private Collection<Trekking> trekkingen;

	public TrekkingRepository()
	{
		
	}

	public void voegTrekkingToe(Trekking trekking) {
		trekkingen.add(trekking);
	}

	public Trekking geefTrekking(String naam) {
		for (Trekking trekking : trekkingen) {
			if (trekking.getNaam().equals(naam)) {
				return trekking;
			}
		}
		return null;
	}
}
