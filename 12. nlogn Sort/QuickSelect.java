import java.util.*;

public class QuickSelect {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int k = sc.nextInt();

		int result = findKthSmallest(arr, k);
		System.out.println(result);
	}

	// for kth largest either calculate for k = length - k
	// or invert the conditions

	public static int findKthSmallest(int[] arr, int k) {
		k = k - 1;
		int low = 0;
		int high = arr.length - 1;
		int result;

		while (true) {
			int pivotIndex = partition(arr, low, high);
			if (pivotIndex == k) {
				result = arr[pivotIndex];
				break;
			} else if (pivotIndex < k) {
				low = pivotIndex + 1;
			} else if (pivotIndex > k) {
				high = pivotIndex - 1;
			}
		}

		return result;
	}

	public static int findKthSmallest(int[] arr, int k, int start, int end) {
		int pivotIndex = partition(arr, start, end);

		if (pivotIndex == k - 1) {
			return arr[pivotIndex];
		} else if (pivotIndex < k - 1) {
			return findKthSmallest(arr, k, pivotIndex + 1, end);
		} else {
			return findKthSmallest(arr, k, start, pivotIndex - 1);
		}
	}

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
}