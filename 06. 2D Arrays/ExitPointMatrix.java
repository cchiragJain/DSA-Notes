import java.util.*;

public class ExitPointMatrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// taking input
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[m][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int dir = 0;
		int i = 0;
		int j = 0;

		while (true) {

			dir = (dir + arr[i][j]) % 4;

			/*
			ONLY FOR GFG QUESTION
			if (arr[i][j] == 1)
				arr[i][j] = 0;
			*/

			// go east
			if (dir == 0) {
				j++;
			}

			// go south
			else if (dir == 1) {
				i++;
			}

			// go west
			else if (dir == 2) {
				j--;
			}

			// go north
			else if (dir == 3) {
				i--;
			}

			// checking if already exited or not
			// can also make this the while condition but we would have to write the
			// below code then as well.

			// also while exiting we will be incrementing/decrementing i & j so
			// considering those cases as well.
			if (i < 0) {
				i++;
				break;
			} else if (j < 0) {
				j++;
				break;
			} else if (i == arr.length) {
				i--;
				break;
			} else if (j == arr[0].length) {
				j--;
				break;
			}


		}

		System.out.println(i + " " + j);
	}
}