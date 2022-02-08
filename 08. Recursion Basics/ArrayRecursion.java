import java.util.*;

public class ArrayRecursion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		display(arr, 0);
		System.out.println();

		displayReverse(arr, 0);
		System.out.println();
		
		System.out.println("Maximum is = " + maxOfArray(arr, 0));
	}

	public static void display(int[] arr, int idx) {
		if (idx == arr.length)
			return;

		System.out.println(arr[idx]);
		display(arr, idx + 1);
	}

	public static void displayReverse(int[] arr, int idx) {
		if (idx == arr.length)
			return;

		displayReverse(arr, idx + 1);
		System.out.println(arr[idx]);
	}

	public static int maxOfArray(int[] arr, int idx) {
		if (idx == arr.length - 1) {
			return arr[idx];
		}

		int max = Math.max(arr[idx], maxOfArray(arr, idx + 1));

		return max;
	}
}
