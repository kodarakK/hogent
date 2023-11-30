package cui;

import java.security.SecureRandom;
import java.util.Iterator;

public class MatrixApp {

	public static void main(String[] args) {
		new MatrixApp().maakEnTransponeerMatrix();
	}

	private void maakEnTransponeerMatrix() {
		// Maak matrix
		SecureRandom sr = new SecureRandom();
		int[][] matrix = new int[sr.nextInt(1, 5)][sr.nextInt(1, 5)];
		for (int rij = 0; rij < matrix.length; rij++) {
			for (int kolom = 0; kolom < matrix[rij].length; kolom++) {
				matrix[rij][kolom] = sr.nextInt(101);
			}
		}

		// Toon matrix
		System.out.println("Matrix:");
		toonMatrix(matrix);

		// TODO - Hier aanvullen!
		int[][] getransponeerdeMatrix = transponeerMatrix(matrix);

		// Toon getransponeerdeMatrix
		System.out.printf("%nGetransponeerde matrix:%n");
		toonMatrix(getransponeerdeMatrix);
	}

	private int[][] transponeerMatrix(int[][] matrix)
	{
		int[][] transMatrix = new int[matrix[0].length][matrix.length];
		for (int rij = 0; rij < matrix.length; rij++) {
			 for (int kolom = 0; kolom < matrix[rij].length; kolom++)
			{
				transMatrix[kolom][rij] = matrix[rij][kolom];
			}
		}
		return transMatrix;
	}

	private void toonMatrix(int[][] matrix) {
		for (int[] rij : matrix) {
			for (int getal : rij) {
				System.out.printf("%5d", getal);
			}
			System.out.println();
		}
	}

}
