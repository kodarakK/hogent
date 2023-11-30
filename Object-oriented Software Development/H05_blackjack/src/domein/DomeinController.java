package domein;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import dto.KaartDTO;

public class DomeinController
{
	private Blackjack blackjack;

	public void startBlackjack(BigDecimal inzet)
	{
		blackjack = new Blackjack(inzet);
	}

	public List<KaartDTO> geefSpeelbord()
	{
		List<KaartDTO> kaartenDTO = new ArrayList<>();
		for (Kaart kaart : blackjack.getSpeelbord()) {
			kaartenDTO.add(new KaartDTO(kaart.getWaarde(), kaart.getKleur()));
		}

		return kaartenDTO;
	}

	public int geefPunten()
	{
		return blackjack.geefPunten();
	}

	public void neemKaart()
	{
		blackjack.neemKaart();
	}

	public boolean isEindeBlackjack()
	{
		return blackjack.isEindeBlackjack();
	}
	
	public BigDecimal geefWinst()
	{
		return blackjack.geefWinst();
	}
}
