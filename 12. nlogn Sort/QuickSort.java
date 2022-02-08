import java.util.*;

public class QuickSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// taking array input
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		// System.out.println(partition(arr, 0, arr.length - 1));
		// printArray(arr);

		quickSort(arr, 0, arr.length - 1);
		printArray(arr);

	}

	public static void quickSort(int[] arr, int start, int end) {
		if (start >= end) {
			// can either be a single element(start == end) or no element left in segment(start > end)
			return;
		}

		int pivotPosition = partition(arr, start, end);
		quickSort(arr, start, pivotPosition - 1);
		quickSort(arr, pivotPosition + 1, end);
	}

	// if need to do partition across a random element just change pivot to that element
	// and remove the last swap statement
	// and add end in the for loop
	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int pIndex = start;

		for (int i = start; i < end; i++) {
			if (arr[i] <= pivot) {
				swapArrayElements(arr, i, pIndex);
				pIndex++;
			}
		}

		swapArrayElements(arr, pIndex, end);

		return pIndex;
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