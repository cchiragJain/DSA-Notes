import java.util.*;

public class AllIndicesInArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int x = sc.nextInt();

		int[] result = allIndices(arr, x, 0, 0);
		for (int val : result)
			System.out.print(val + " ");

	}

	public static int[] allIndices(int[] arr, int x, int idx, int foundSoFar) {
		// if we only needed to print all indices then can do it when building the stack
		// to check for all indexes and keep printing

		// base case
		// only creating a new array in this case
		// the same array is getting returned
		if (arr.length == idx) {
			return new int[foundSoFar]; // 1
		}

		int[] result;

		if (arr[idx] == x) { // 2
			result = allIndices(arr, x, idx + 1, foundSoFar + 1); // 2.1
			result[foundSoFar] = idx; // 2.2
		} else { // 3
			result = allIndices(arr, x, idx + 1, foundSoFar); // 3.1
		}

		return result;
	}
}