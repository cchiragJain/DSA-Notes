import java.util.*;

public class SortDates {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}

		sortDates(arr);

		printArray(arr);
	}

	public static void sortDates(String[] arr) {
		// sort by date
		countSort(arr, 31, 0, 2);
		// sort by month
		countSort(arr, 12, 2, 4);
		// sort by year
		// can do radix sort for the year part(will do digit by digit sort for the year much
		// better idea will decrease space required but overall the space complexity is constant
		// for this question since creating the same size array for any size input for freqArray
		// (auxilary space)
		countSort(arr, 2500, 4, 8);
	}

	public static void countSort(String[] arr, int range, int subStart, int subEnd) {
		int[] freqArr = new int[range];
		String[] result = new String[arr.length];

		// calculate frequency array
		for (int i = 0; i < arr.length; i++) {
			String str = arr[i].substring(subStart, subEnd);
			int position = Integer.parseInt(str) - 1;
			freqArr[position]++;
		}

		// calculate prefix sum frequency array
		for (int i = 1; i < freqArr.length; i++) {
			freqArr[i] = freqArr[i] + freqArr[i - 1];
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			String str = arr[i].substring(subStart, subEnd);
			int position = Integer.parseInt(str) - 1;

			int index = freqArr[position] - 1;
			result[index] = arr[i];

			freqArr[position]--;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = result[i];
		}

	}

	public static void printArray(String[] arr) {
		for (String str : arr)
			System.out.println(str);
	}

	public static void printArray(int[] arr) {
		for (int val : arr)
			System.out.print(val + " ");
		System.out.println();
	}
}