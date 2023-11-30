package cui;

public class Oefening5 {
	public static void main(String[] args) {
		new Oefening5().start();
	}

	private void start() {
		int[] omzetWaarden = {360, 2100, 450, 1450, 650, 780, 1200, 321, 560, 1850, 960, 420};

		int indexHoogste = 0;
		int indexLaagste = 0;

		for (int index = 1; index < omzetWaarden.length; index++) {
			if (omzetWaarden[index] > omzetWaarden[indexHoogste]) {
				indexHoogste = index;
			}

			else if (omzetWaarden[index] < omzetWaarden[indexLaagste]) {
				indexLaagste = index;
			}
		}

		System.out.printf("Hoogste omzet van %d Euro werd behaald in de %d%s maand.%n", omzetWaarden[indexHoogste], indexHoogste+1, geefAchterVoegsel(indexHoogste+1));
		System.out.printf("Laagste omzet van %d Euro werd behaald in de %d%s maand.%n", omzetWaarden[indexLaagste], indexLaagste+1, geefAchterVoegsel(indexLaagste+1));
	}

	private String geefAchterVoegsel(int maand) {
		return (maand==1||maand==8)?"ste":"de"; // of return (maand!=8||maand!=1)?"de":"ste";
	}
}