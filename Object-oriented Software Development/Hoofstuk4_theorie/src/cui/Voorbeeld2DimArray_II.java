package cui;

public class Voorbeeld2DimArray_II {

	public static void main(String[] args) {
		new Voorbeeld2DimArray_II().start();
	}

	private void start() {
		int[][] b;
		b = new int[2][];   // 2 rijen
		b[0] = new int[5];  // rij 0 heeft 5 kolommen
		b[1] = new int[3];  // rij 1 heeft 3 kolommen
		
		String resultaat = "";
		for (int[] elementenVanEenRij : b) {
			for (int element : elementenVanEenRij)
				resultaat += String.format("%d  ", element);
			resultaat += String.format("%n");
		}
		System.out.println(resultaat);
	}

}
