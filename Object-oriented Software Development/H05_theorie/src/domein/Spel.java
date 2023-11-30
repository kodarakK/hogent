package domein;

import java.util.*;

public class Spel
{

	private List<Dobbelsteen> dobbelstenen;
	private int score;
	private int eersteWorp;
	private static final int AANTAL_DOBBELSTENEN = 2;
	public Spel()
	{
		dobbelstenen = new ArrayList<>();

		for (int i = 0; i < AANTAL_DOBBELSTENEN; i++){
			dobbelstenen.add(new Dobbelsteen());
		}

		score = -1;
	}

	public int getScore()
	{
		return this.score;
	}


	public void rolDobbelstenen()
	{
		for (Dobbelsteen dobbelsteen : dobbelstenen) {
			dobbelsteen.rol();
		}
		int somAantalOgen = geefAantalOgen();
		bepaalScore(somAantalOgen);
		bepaalEersteWorp(somAantalOgen);
	}
	
	private void bepaalEersteWorp(int somAantalOgen)
	{
		if (isEersteWorp()) eersteWorp = somAantalOgen;		
	}

	private boolean isEersteWorp() {
		return eersteWorp == 0;
	}

	private void bepaalScore(int somAantalOgen)
	{
		if (isEersteWorp() && (somAantalOgen == 7 || somAantalOgen == 11)) score = 2;
		else if (somAantalOgen == 7 || somAantalOgen == 11) score = 0;
		else if (eersteWorp == somAantalOgen) score = 1;
		
	}

	public int geefAantalOgen()
	{
		int som  = 0;
		for (Dobbelsteen dobbelsteen : dobbelstenen)
		{
			som += dobbelsteen.getAantalOgen();
		}
		
		return som;
	}

	public boolean isEindeSpel()
	{
		return score != -1;
	}
}
