import java.util.*;

public class TowerOfHanoi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String t1 = sc.next();
		String t2 = sc.next();
		String t3 = sc.next();
		toh(n, t1, t2, t3);
	}

	public static void toh(int n, String t1, String t2, String t3) {
		if (n == 0)
			return;

		toh(n - 1, t1, t3, t2); // move from t1 to t3 using t2
		System.out.println("Move " + n + " from " + t1 + " to " + t2);
		toh(n - 1, t3, t2, t1); // move disks from t3 to t2 using t1
	}
}