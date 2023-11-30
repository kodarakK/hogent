package cui;

public class VoorbeeldMain_args {

	/* Array van args opvullen: 
	 In de Eclipse IDE kies je hiervoor in het <Run> menu voor <Run configurations>. 
	 Op het tabblad arguments kan je een lijst van waarden ingeven gescheiden door een spatie. 
	 Deze waarden worden als Strings in een array verzameld en doorgegeven aan args bij de start van je programma…​
	 */
	
//	static? als we het programma opstarten hebben nog niks, nog geen objecten
//	Methode main MOET static meth zijn = op klasse niveau
//	public? java moet de methode kiunnne oproepen
//	void? main omet zijn werk doen, eetste methode moet geen waarde kunnen teruggeven
//	anders zouden we een fictieve waarde moeten teruggeven wat raar is
	
//	String[] args
	public static void main(String[] args) {
		String antwoord = switch (args.length)
		{
			case 0 -> "Geen parameters";
			case 1 -> String.format("1 parameter = %s%n", args[0]);
			default -> String.format("parameters %s en %s%n", args[0], args[1]);
		};
		System.out.println(antwoord);
	}
	
}