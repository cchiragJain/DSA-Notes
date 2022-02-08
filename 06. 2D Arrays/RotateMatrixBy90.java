import java.util.*;

public class RotateMatrixBy90 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] arr = new int[n][n];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		System.out.println("Before transpose");
		display(arr);

		transpose(arr);

		System.out.println("\nAfter transpose");
		display(arr);

		for (int i = 0; i < arr.length; i++) {
			int li = 0;
			int ri = arr[i].length - 1;

			while (li < ri) {
				// swapping elements

				int temp = arr[i][li];
				arr[i][li] = arr[i][ri];
				arr[i][ri] = temp;

				li++;
				ri--;
			}

		}

		System.out.println("\nAfter Reversing");
		display(arr);
	}

	public static void transpose(int[][] arr) {
		// only swapping the upper triangular part
		// will only work if matrix is square else we need extra space
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr[0].length; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}