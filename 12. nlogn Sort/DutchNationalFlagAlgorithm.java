import java.util.*;

public class DutchNationalFlagAlgorithm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		sort012Array(arr);

		printArray(arr);

	}

	public static void sort012Array(int[] arr) {
		int i = 0;
		int j = 0;
		int k = arr.length - 1;

		while (i <= k) {
			if (arr[i] == 0) {
				swapArrayElements(arr, i, j);
				i++;
				j++;
			} else if (arr[i] == 1) {
				i++;
			} else if (arr[i] == 2) {
				swapArrayElements(arr, i, k);
				k--;
			}
		}
	}

	public static void sort01Array(int[] arr) {
		int i = 0;
		int j = 0;

		while (i < arr.length) {
			if (arr[i] == 0) {
				swapArrayElements(arr, i, j);
				i++;
				j++;
			} else {
				i++;
			}
		}
	}

	public static void sort01ArrayUsingCount(int[] arr) {
		// can do the same for 012 array but will need to create another variable to store countOf2
		int countZero = 0;
		int countOne = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				countZero++;
			else
				countOne++;
		}

		int i = 0;
		while (countZero != 0) {
			arr[i] = 0;
			i++;
			countZero--;
		}
		while (countOne != 0) {
			arr[i] = 1;
			i++;
			countOne--;
		}
	}

	public static void swapArrayElements(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void printArray(int[] arr) {
		for (int val : arr)
			System.out.print(val + " ");
		System.out.println();
	}
}

