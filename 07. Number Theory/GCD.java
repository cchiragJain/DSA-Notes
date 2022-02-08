import java.util.*;

public class GCD {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		System.out.println(naiveGCD(a, b));
		System.out.println(euclidGCD(a, b));
	}

	public static int euclidGCD(int a, int b) {
		if (b == 0)
			return a;

		return euclidGCD(b, a % b);
	}

	public static int lcm(int a, int b) {
		// lcm * gcd = a * b
		return (a * b) / euclidGCD(a, b);
	}

	public static int naiveGCD(int a, int b) {
		// O(min(a,b))
		int min = Math.min(a, b);

		for (int i = min; i >= 1; i--) {
			if (a % i == 0 && b % i == 0) {
				return i;
			}
		}

		return 1;
	}
}