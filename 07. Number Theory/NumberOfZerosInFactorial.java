import java.util.*;

public class NumberOfZerosInFactorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(findZeros(n));
	}

	public static int findZeros(int n) {
		int ans = 0;
		int mult = 5;

		while ((n / mult) > 0) {
			ans += n / mult;
			mult = mult * 5;
		}

		return ans;
	}
}