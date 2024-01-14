package testen;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Categorie;
import domein.Snack;
import domein.SnackTracker;

import static domein.Categorie.*;

class SnackTrackerTest {

	private static final int MAX_SNACKS = 10;
	private SnackTracker st;
	private Snack gezondeSnack;
	private Snack ongezondeSnack;

	@BeforeEach
	void before() {
		st = new SnackTracker();
		gezondeSnack = new Snack("Appel", FRUIT);
		ongezondeSnack = new Snack("M&M", SNOEP);
	}
	
//een nieuwe snacktracker bevat geen snacks en heeft plaats voor exact 10 snacks
//------------------------------------------------------------------------------	
	//?lengte 10
	//?alle elementen van de array gelijk aan null
	@Test
	void maakSnackTracker_MaaktSnackTrackerZonderSnacks() {
		//TODO
		assertEquals(MAX_SNACKS, st.getSnacks().length);
		
		for (Snack s  : st.getSnacks())
		{
			assertNull(s);
		}
	}
	
//gedrag isGezondGesnackt
//-----------------------
	//er is gezond gesnackt wanneer
			//er geen snacks geregistreerd zijn, of,
			//indien meer dan de helft van de geregistreerde snacks gezonde snacks zijn
			//er is niet gezond gesnackt in alle andere gevallen
	
	//hulpmethode voorzien
	private void registreerSnacks(Snack[] snacks)
	{
		//de snacks via "registreerSnack" toevoegen in je object van SnackTracker
		for (Snack snack : snacks)
		{
			st.registreerSnack(snack);
		}
	}
	
	@Test //geen snacks?
	void isGezondGesnackt_GeenGeregistreerdeSnacks_RetourneertTrue() {
		assertTrue(st.isGezondGesnackt());
	}
	
	@Test //1 gezonde snack?
	void isGezondGesnackt_EenGezondeSnackGeregistreerd_RetourneertTrue() {
		registreerSnacks(new Snack[] {gezondeSnack});
		assertTrue(st.isGezondGesnackt());
	}
	
	@Test //1 ongezonde snack?
	void isGezondGesnackt_EenOngezondeSnackGeregistreerd_RetourneertFalse() {
		registreerSnacks(new Snack[] {ongezondeSnack});
		assertFalse(st.isGezondGesnackt());
	}
	
	@Test //1 ongezonde en 1 gezonde snack
	void isGezondGesnackt_EvenveelGezondeOngezondeSnacksGeregistreerd_RetourneertFalse() {
		registreerSnacks(new Snack[] {ongezondeSnack, ongezondeSnack});
		assertFalse(st.isGezondGesnackt());
	}
	
	@Test //3x ongezond
	void isGezondGesnackt_AllemaalOngezond_RetourneertFalse() {
		registreerSnacks(new Snack[] {ongezondeSnack, ongezondeSnack, ongezondeSnack});
		assertFalse(st.isGezondGesnackt());
	}
	
	@Test //2x ongezond, 1x gezond
	void isGezondGesnackt_AantalGezondeSnacksIsNetNietDeHelftVanDeGeregistreerdeSnacks_RetourneertFalse() {
		registreerSnacks(new Snack[] {ongezondeSnack, ongezondeSnack, gezondeSnack});
		assertFalse(st.isGezondGesnackt());
	}
	
	@Test //3x gezond
	void isGezondGesnackt_AllemaalGezond_RetourneertTrue() {
		registreerSnacks(new Snack[] {gezondeSnack, gezondeSnack, gezondeSnack});
		assertTrue(st.isGezondGesnackt());
	}
	
	@Test //2x gezond, 1x ongezond
	void isGezondGesnackt_NetMeerDanDeHelftVanDeGeregistreerdeSnacksZijnGezond_RetourneertTrue() {
		registreerSnacks(new Snack[] {ongezondeSnack, gezondeSnack, gezondeSnack});
		assertTrue(st.isGezondGesnackt());
	}
	
//gedrag registreerSnack(snack:Snack): void
//----------------------
	//de snack moet ingevuld zijn
    //indien er reeds het toegelaten snacks aanwezig zijn in de snacktracker kan de nieuwe snack 
	//niet worden toegevoegd (Exception)

	//gedrag geefAantalGeregistreerdeSnacks: retourneert het aantal geregistreerde snacks

	@Test
	void registreerSnack_SnackIsNull_WerptException() {
		assertThrows(IllegalArgumentException.class, () -> st.registreerSnack(null));
	}

	@Test
	void geefAantalGeregistreerdeSnacks_LegeSnackTracker_Retourneert0() {
		assertEquals(0, st.geefAantalGeregistreerdeSnacks());
	}

	@Test
	void registreerSnack_MaxAantalSnacksReedsGeregistreerd_WerptException() {
		//startsituatie: 10 snacks registreren
		for(int i = 0; i < 10; i++) {
			st.registreerSnack(gezondeSnack);
		}
		//?nog een snack registreren
		assertThrows(IllegalArgumentException.class, () -> st.registreerSnack(gezondeSnack));
	}
	
	private Snack[] maakVerwachteResultaat(int aantalGezond, int aantalOngezond)
	{
		Snack[] verwachteResultaat = new Snack[MAX_SNACKS];
		for (int i=0; i < aantalGezond; i++)
			verwachteResultaat[i] = gezondeSnack;
		int startIndex = aantalGezond;
		for (int i=startIndex; i < startIndex+aantalOngezond; i++)
			verwachteResultaat[i] = ongezondeSnack;
		return verwachteResultaat;
	}
	/*	
	@Test
	void registreerSnack_NetGeenMaxAantalSnacksGeregistreerd_RegistreertDeSnack() {		
		//startsituatie: 9 snacks registreren
		
		//1 snack registreren 
		
		assertEquals(MAX_SNACKS, st.geefAantalGeregistreerdeSnacks());
		assertArrayEquals(maakVerwachteResultaat(MAX_SNACKS - 1,1), st.getSnacks());
	}

	@Test
	void registreerSnack_GeenMaxAantalSnacksGeregistreerd_RegistreertDeSnack() {
		Snack[] snacks = {gezondeSnack, gezondeSnack, gezondeSnack, ongezondeSnack};
		//registreer deze snacks (= hulpmethode oproepen)
		
		//?4 snacks
		//?arrays gelijk
	}

	@Test
	void geefAantalGeregistreerdeSnacks_NietLegeSnackTracker_RetourneertAantalGeregistreerdeSnacks() {
		Snack[] snacks = {gezondeSnack, ongezondeSnack};
		//registreer deze snacks (= hulpmethode oproepen)
		//?2 snacks
		//?arrays gelijk
	}*/
	
	@Test
	void registreerSnack_NetGeenMaxAantalSnacksGeregistreerd_RegistreertDeSnack() {		
		for (int i = 0; i < MAX_SNACKS - 1; i++) {
			st.registreerSnack(gezondeSnack);
		}
		st.registreerSnack(ongezondeSnack);
		
		assertEquals(MAX_SNACKS, st.geefAantalGeregistreerdeSnacks());
		assertArrayEquals(maakVerwachteResultaat(MAX_SNACKS - 1,1), st.getSnacks());
	}

	@Test
	void registreerSnack_GeenMaxAantalSnacksGeregistreerd_RegistreertDeSnack() {
		Snack[] snacks = {gezondeSnack, gezondeSnack, gezondeSnack, ongezondeSnack};
		registreerSnacks(snacks);
		
		assertEquals(4, st.geefAantalGeregistreerdeSnacks());
		assertArrayEquals(maakVerwachteResultaat(3,1), st.getSnacks());
	}

	@Test
	void geefAantalGeregistreerdeSnacks_NietLegeSnackTracker_RetourneertAantalGeregistreerdeSnacks() {
		Snack[] snacks = {gezondeSnack, ongezondeSnack};
		registreerSnacks(snacks);
		assertEquals(2, st.geefAantalGeregistreerdeSnacks());
		assertArrayEquals(maakVerwachteResultaat(1,1), st.getSnacks());
	}


}
