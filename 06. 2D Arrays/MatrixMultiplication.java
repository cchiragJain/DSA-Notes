import java.util.*;

public class MatrixMultiplication {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Taking input
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr1 = new int[m][n];
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				arr1[i][j] = sc.nextInt();
			}
		}

		int p = sc.nextInt();
		int q = sc.nextInt();
		int[][] arr2 = new int[p][q];
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				arr2[i][j] = sc.nextInt();
			}
		}

		int[][] result = multiply(arr1, arr2);

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static int[][] multiply(int[][] arr1, int[][] arr2) {
		int[][] result = new int[arr1.length][arr2[0].length];

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length ; j++) {
				for (int k = 0; k < arr1[0].length ; k++) {
					result[i][j] += (arr1[i][k] * arr2[k][j]);
				}
			}
		}

		return result;
	}
}