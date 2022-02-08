import java.util.*;

public class ShellRotate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Taking input
		int m = sc.nextInt();
		int n = sc.nextInt();

		int[][] arr = new int[m][n];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int s = sc.nextInt();
		int r = sc.nextInt();

		rotateShell(arr, s, r);

		display(arr);
	}

	public static void rotateShell(int[][] arr, int s, int r) {
		int[] shellArray = fillOneDArrayFromShell(arr, s);
		rotateOneDArray(shellArray, r);
		fillShellFromOneDArray(shellArray, arr, s);
	}

	public static int[] fillOneDArrayFromShell(int[][] arr, int s) {
		int minc = s - 1;
		int minr = s - 1;
		int maxc = arr[0].length - s;
		int maxr = arr.length - s;

		int shellSize = 2 * ((maxr - minr) + (maxc - minc));

		int[] shellArray = new int[shellSize];
		int idx = 0;

		// USING SAME LOGIC AS SPIRAL TRAVERSAL OF LEFT,BOTTOM,RIGHT,TOP WALL
		for (int i = minr, j = minc; i <= maxr; i++) {
			shellArray[idx] = arr[i][j];
			idx++;
		}
		// rather than changing values we can run loop only
		minc++;

		for (int i = maxr, j = minc; j <= maxc; j++) {
			shellArray[idx] = arr[i][j];
			idx++;
		}
		maxr--;

		for (int i = maxr, j = maxc; i >= minr; i--) {
			shellArray[idx] = arr[i][j];
			idx++;
		}
		maxc--;

		for (int i = minr, j = maxc; j >= minc; j--) {
			shellArray[idx] = arr[i][j];
			idx++;
		}

		return shellArray;
	}

	public static void fillShellFromOneDArray(int[] shellArray, int[][] arr, int s) {
		int minc = s - 1;
		int minr = s - 1;
		int maxc = arr[0].length - s;
		int maxr = arr.length - s;

		int idx = 0;

		// USING SAME LOGIC AS SPIRAL TRAVERSAL OF LEFT,BOTTOM,RIGHT,TOP WALL
		for (int i = minr, j = minc; i <= maxr; i++) {
			arr[i][j] = shellArray[idx];
			idx++;
		}
		minc++;

		for (int i = maxr, j = minc; j <= maxc; j++) {
			arr[i][j] = shellArray[idx];
			idx++;
		}
		maxr--;

		for (int i = maxr, j = maxc; i >= minr; i--) {
			arr[i][j] = shellArray[idx];
			idx++;
		}
		maxc--;

		for (int i = minr, j = maxc; j >= minc; j--) {
			arr[i][j] = shellArray[idx];
			idx++;
		}
	}

	public static void rotateOneDArray(int[] arr, int r) {
		int n = arr.length;
		r = r % n;
		if (r < 0)
			r = r + n;

		reverseArray(arr, 0, n - r - 1);
		reverseArray(arr, n - r, n - 1);
		reverseArray(arr, 0, n - 1);
	}

	public static void reverseArray(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;

			start++;
			end--;
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