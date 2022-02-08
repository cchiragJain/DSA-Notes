import java.util.*;

public class CountSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int val : arr) {
			min = Math.min(min, val);
			max = Math.max(max, val);
		}

		int[] result = countSort(arr, min, max);

		printArray(result);

	}

	public static int[] countSort(int[] arr, int min, int max) {
		int range = max - min;
		int[] freqArray = new int[range + 1];

		int[] result = new int[arr.length];

		// calculate frequency array
		for (int i = 0; i < arr.length; i++) {
			int position = arr[i] - min;
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
			int position = arr[i] - min;

			int index = freqArray[position] - 1;

			result[index] = arr[i];

			freqArray[position]--;
		}

		return result;
	}

	public static void printArray(int[] arr) {
		for (int val : arr)
			System.out.print(val + " ");
		System.out.println();
	}

}