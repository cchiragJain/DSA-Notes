import java.util.*;

public class TargetSumSubsets {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();

		printTargetSumSubsets(arr, target, 0, "", 0);

	}

	public static void printTargetSumSubsets(int[] arr, int target, int idx, String answer, int sum) {
		if (sum > target) {
			return;
		} else if (idx == arr.length) {
			if (sum == target)
				System.out.println(answer);
			return;
		}

		int element = arr[idx];
		printTargetSumSubsets(arr, target, idx + 1, answer + element + " ", sum + element);
		printTargetSumSubsets(arr, target, idx + 1, answer, sum);

	}
}