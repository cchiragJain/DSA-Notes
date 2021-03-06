import java.util.*;

public class RecursionBasics {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// printDecreasing(n);

		// printIncreasing(n);

		printDecreasingIncreasing(n);
	}

	public static void printDecreasing(int n) {
		if (n == 0)
			return;

		System.out.println(n);
		printDecreasing(n - 1);
	}

	public static void printIncreasing(int n) {
		if (n == 0)
			return;

		printIncreasing(n - 1);
		System.out.println(n);
	}

	public static void printDecreasingIncreasing(int n) {
		if (n == 0)
			return;

		System.out.println(n);
		printDecreasingIncreasing(n - 1);
		System.out.println(n);
	}
}