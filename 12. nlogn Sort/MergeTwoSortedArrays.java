import java.util.*;

public class MergeTwoSortedArrays {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int[] arr1 = takeArrayInput();
		int[] arr2 = takeArrayInput();

		int[] result = mergeTwoSortedArrays(arr1, arr2);
		printArray(result);
	}

	public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length + arr2.length];

		int i = 0;
		int j = 0;
		int k = 0;

		// add elements that are smaller from both arrays first
		// if one of the pointers reaches the end the loop stops
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

		// add the remaining elements to the result array
		// could be i or j pointer whichever one could not reach the end
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

	public static int[] takeArrayInput() {
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		return arr;
	}

	public static void printArray(int[] arr) {
		for (int val : arr)
			System.out.print(val + " ");
		System.out.println();
	}

}