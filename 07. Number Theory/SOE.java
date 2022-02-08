import java.util.*;

public class SOE {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(checkPrime(n) ? "Prime" : "Not Prime");

		// printPrimesTillN(1000);

		sieve(1000);
	}

	public static void sieve(int n) {
		// O(nloglogn) complexity

		// true -> prime
		// false -> not prime
		boolean[] primes = new boolean[n + 1];

		// default value of boolean array is false
		Arrays.fill(primes, true);

		primes[0] = primes[1] = false;

		for (int table = 2; table * table <= n; table++) {

			if (primes[table] == false) {
				// if already marked as false that means it factor before it has
				// marked its multiple as well
				// no need to go further
				continue;
			}

			for (int mult = 2; table * mult <= n; mult++) {
				primes[table * mult] = false;
			}
		}

		for (int i = 0; i < primes.length; i++) {
			if (primes[i])
				System.out.println(i);
		}

	}

	public static void printPrimesTillN(int n) {
		// O(n sqrt(n))
		for (int i = 2; i <= n; i++) {
			if (checkPrime(i))
				System.out.println(i);
		}
	}

	public static boolean checkPrime(int n) {
		// O(sqrt(n))
		if (n <= 1)
			return false;
		if (n == 2 || n == 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i <= Math.sqrt(n); i = i + 6) {
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		}
		return true;
	}

}