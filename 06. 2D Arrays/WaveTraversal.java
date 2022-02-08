import java.util.*;

public class WaveTraversal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();

		int[][] arr = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < arr[0].length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < arr.length; j++) {
					System.out.println(arr[j][i]);
				}
			} else {
				for (int j = arr.length - 1; j >= 0; j--) {
					System.out.println(arr[j][i] + " ");
				}
			}
		}
	}
}