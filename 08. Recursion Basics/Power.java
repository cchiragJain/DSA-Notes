import java.util.*;

public class Power {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();

		int res = powerLinear(x, n);
		System.out.println(res);

		res = powerLogarithmic(x, n);
		System.out.println(res);
	}

	public static int powerLinear(int x, int n) {
		// x^n = x * x^(n - 1)

		// base case
		if (n == 0)
			return 1;

		int xn1 = powerLinear(x, n - 1);
		int xn = x * xn1;
		return xn;
	}

	public static int powerLogarithmic(int x, int n) {
		if (n == 0)
			return 1;

		int xn2 = powerLogarithmic(x, n / 2);
		int xn = xn2 * xn2;

		if (n % 2 != 0)
			xn = xn * x;

		return xn;
	}
}