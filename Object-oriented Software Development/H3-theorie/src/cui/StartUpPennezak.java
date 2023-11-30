package cui;

import domein.Pennezak;

public class StartUpPennezak
{

	public static void main(String[] args)
	{
		new StartUpPennezak().voorbeeld();

	}

	private void voorbeeld()
	{
		/* 
		 * object creëeren van klasse Pennezak
		 */
								// default constructor
		Pennezak pennezakAnn = new Pennezak();
		
		/* 
		 * werkt niet: data is verborgen
		 * pennezakAnn.lengte = -10;
		 */
		
		pennezakAnn.setLengte(15);
		pennezakAnn.maakOpen();
		System.out.printf("Ann kleur %s%n", pennezakAnn.getKleur());
		System.out.printf("lengte %d%n", pennezakAnn.getLengte());
		System.out.printf("is open %s%n", pennezakAnn.isOpen());

		Pennezak pennezakJan = new Pennezak("Geel", 12);
		System.out.printf("Jan kleur %s%n", pennezakJan.getKleur());
		System.out.printf("lengte %d%n", pennezakJan.getLengte());
		System.out.printf("is open %s%n", pennezakJan.isOpen());

		Pennezak pennezakWim = new Pennezak(14);
		System.out.printf("Wim kleur %s%n", pennezakWim.getKleur());
		System.out.printf("lengte %d%n", pennezakWim.getLengte());
		System.out.printf("is open %s%n", pennezakWim.isOpen());

	}

}
