import java.util.*;

public class NFibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// using long just to check for large numbers
		long nfib = fib(n);

		System.out.println(nfib);
	}

	public static long fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}

		long fibnm1 = fib(n - 1);
		long fibnm2 = fib(n - 2);

		long fibn = fibnm1 + fibnm2;

		return fibn;
		// can just return fib(n - 1) + fib(n - 2) as well
		// no need to do seperately
	}
}