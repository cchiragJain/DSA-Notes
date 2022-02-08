import java.util.*;

public class FirstAndLastOccurenceArrayRecursion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int x = sc.nextInt();

		System.out.println("firstOccurence : " + firstOccurence(arr, 0, x));

		System.out.println();

		System.out.println("lastOccurence : " + lastOccurence(arr, 0, x));
	}

	public static int firstOccurence(int[] arr, int idx, int x) {
		if (idx == arr.length) {
			return -1;
		}

		if (arr[idx] == x) {
			return idx;
		}

		return firstOccurence(arr, idx + 1, x);
	}

	public static int lastOccurence(int[] arr, int idx, int x) {
		if (idx == arr.length)
			return -1;


		int lastOccurenceFromIdx = lastOccurence(arr, idx + 1, x);

		if (lastOccurenceFromIdx == -1) {
			// if not found at last check if current idx == x
			// if not then not in this array
			if (arr[idx] == x){
				return idx;
			}
			else{
				return -1;
			}
		} else {
			// if found then return that index
			return lastOccurenceFromIdx;
		}
	}
}