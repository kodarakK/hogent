package cui;

import domein.Verzameling;

public class StartUpVerzameling {

	public static void main(String[] args) {
		new StartUpVerzameling().start();
	}

	private void start() {
		
		int som = 0;
		for (int i=1; i < 100000; i++)
		{
			Verzameling verzameling = new Verzameling();
			som += verzameling.simuleerVerzamelingCompleet();
		}
		int gem = som / 100000;
		System.out.printf("Je dient %d kauwgommen te kopen vooraleer je verzameling compleet is%n", gem);
	}

}
