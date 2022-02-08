import java.util.*;

public class RadixSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		radixSort(arr);

		printArray(arr);

	}

	public static void radixSort(int[] arr) {
		// to get the no of times the loop should run
		int max = getMax(arr);

		int exp = 1;

		while (exp <= max) {
			// exp represents the place which is getting sorted
			countSort(arr, exp);
			exp = exp * 10;
		}
	}

	public static void countSort(int[] arr, int exp) {
		// digits ke basis pe sort kar rahe hain toh range 0 - 9 ki hogi
		int[] freqArray = new int[10];

		int[] result = new int[arr.length];

		// calculate frequency array
		for (int i = 0; i < arr.length; i++) {
			int position = (arr[i] / exp % 10);
			freqArray[position]++;
		}

		// calculate prefix sum array of frequency array
		for (int i = 1; i < freqArray.length; i++) {
			freqArray[i] = freqArray[i] + freqArray[i - 1];
		}

		// Run a reverse loop
		// For current element check its last position in frequency array
		// Put element at the last position in the result array
		// And decrement the last position for next time that elements last position is needed
		for (int i = arr.length - 1; i >= 0; i--) {
			int position = (arr[i] / exp % 10);

			int index = freqArray[position] - 1;

			result[index] = arr[i];

			freqArray[position]--;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = result[i];
		}

	}

	public static int getMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int val : arr) {
			max = Math.max(max, val);
		}

		return max;
	}

	public static void printArray(int[] arr) {
		for (int val : arr)
			System.out.print(val + " ");
		System.out.println();
	}
}