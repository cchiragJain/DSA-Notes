import java.util.*;

public class DiagonalTraversal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int diag = 0; diag < arr.length; diag++) {
			int i = 0;
			int j = diag;

			while (j < arr.length) {
				System.out.println(arr[i][j]);
				i++;
				j++;
			}
		}
	}
}