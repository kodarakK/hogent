package cui;

import java.util.Arrays;
import java.util.Scanner;

public class Voorbeeld2DimArray {

	public static void main(String[] args) {
		new Voorbeeld2DimArray().start();
	}

	private Scanner invoer = new Scanner(System.in);
	
	private void start() {
		//declaratie
		int[][]a;
		
		//creatie van 2 dim.array, 3 rijen, 4 kolommen
		a = new int[3][4]; //ieder element wordt geïnitialiseerd op 0
		System.out.println( Arrays.deepToString(a) );
		
		//declaratie en creatie
		double[][] b = new double[2][3];
		
		int c[][] = geefGetallen();
		System.out.println( Arrays.deepToString(c)   );
		
		//initialisatie
		int[][] array = { { 1, 2, 3 }, { 4, 5 } };
		// Er zijn 2 rijen.Eerste rij bevat 3 kolommen, tweede rij bevat 2 kolommen
		// array[0][0] bevat de waarde 1,w
		// array[0][1] bevat de waarde 2,
		// array[0][2] bevat de waarde 3
		// array[1][0] bevat de waarde 4,
		// array[1][1] bevat de waarde 5,
		// array[1][2] bestaat niet
		
		// enhanced for
		String resultaat = "";
		for (int[] elementenVanEenRij : array) {
			for (int element : elementenVanEenRij)
				resultaat += String.format("%d  ", element);
			resultaat += String.format("%n");
		}
		System.out.println(resultaat);
	
	}

	private int[][] geefGetallen() {
		int[][] array = new int[2][3];
		                       //array.length = aantal rijen, hier 2
		for (int rij = 0; rij < array.length; rij++) { 
			         //array[rij].length = aantal kolommen van een rij                    
			for (int kolom = 0; kolom < array[rij].length ; kolom++) {
				System.out.printf("Geef getal van rij %d kolom %d :", rij+1, kolom+1);
				array[rij][kolom] = invoer.nextInt();
			}
		}
		return array;
	}
}
