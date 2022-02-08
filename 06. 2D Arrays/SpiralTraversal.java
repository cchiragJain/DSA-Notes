import java.util.*;

public class SpiralTraversal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// taking input
		int m = sc.nextInt();
		int n = sc.nextInt();

		int[][] arr = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int minr = 0;
		int minc = 0;
		int maxr = arr.length - 1;
		int maxc = arr[0].length - 1;

		int totalElements = m * n;
		int count = 0;

		while (count < totalElements) {
			// left wall
			// 		row -> minrow to maxrow
			// 		col -> mincol
			for (int i = minr, j = minc; i <= maxr && count < totalElements; i++) {
				System.out.println(arr[i][j]);
				count++;
			}

			minc++;

			// bottom wall
			//		row -> maxrow
			//		col -> mincol to maxcol
			for (int i = maxr, j = minc; j <= maxc && count < totalElements; j++) {
				System.out.println(arr[i][j]);
				count++;
			}

			maxr--;

			// right wall
			//		row -> maxrow to minrow
			//		col -> maxcol
			for (int i = maxr, j = maxc; i >= minr && count < totalElements; i--) {
				System.out.println(arr[i][j]);
				count++;
			}

			maxc--;

			// top wall
			//		row -> minrow
			//		col -> maxcol to mincol
			for (int i = minr, j = maxc; j >= minc && count < totalElements; j--) {
				System.out.println(arr[i][j]);
				count++;
			}

			minr++;

		}

	}
}