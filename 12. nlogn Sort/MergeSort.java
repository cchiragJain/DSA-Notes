import java.util.*;

public class MergeSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int[] result = mergeSort(arr);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	public static int[] mergeSort(int[] arr) {
		// always better to call recursive functions in such a way
		// improves code quality
		// can't expect user to call the functions recursively
		return mergeSort(arr, 0, arr.length - 1);
	}

	public static int[] mergeSort(int[] arr, int low, int high) {
		if (low == high) {
			int[] baseArray = new int[1];
			baseArray[0] = arr[low];
			return baseArray;
		}

		int mid = (low + high) / 2;
		int[] firstHalf = mergeSort(arr, low, mid);
		int[] secondHalf = mergeSort(arr, mid + 1, high);

		int[] result = mergeTwoSortedArrays(firstHalf, secondHalf);

		return result;
	}

	public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length + arr2.length];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				result[k] = arr1[i];
				i++;
			} else {
				result[k] = arr2[j];
				j++;
			}
			k++;
		}

		while (i < arr1.length) {
			result[k] = arr1[i];
			k++;
			i++;
		}

		while (j < arr2.length) {
			result[k] = arr2[j];
			k++;
			j++;
		}

		return result;
	}
}