import java.util.*;

public class SaddlePoint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[m][n];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for ( int i = 0; i < arr.length; i++) {
			int minimum = Integer.MAX_VALUE;

			int minIdx = -1;

			// calculate row minimum and store its col index
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] < minimum) {
					minimum = arr[i][j];
					minIdx = j;
				}
			}

			int maximum = Integer.MIN_VALUE;

			// calculate maximum of that column
			for (int j = 0; j < arr.length; j++) {
				if (arr[j][minIdx] > maximum)
					maximum = arr[j][minIdx];
			}

			if (maximum == minimum) {
				System.out.println(maximum);
				break;
			}

		}

	}
}