import java.util.*;

public class PrintStairPath {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printSP(n, "");
	}

	public static void printSP(int n, String path) {
		if (n == 0) {
			System.out.println(path);
			return;
		} else if (n < 0) {
			return;
		}

		printSP(n - 1, path + "1");
		printSP(n - 2, path + "2");
		printSP(n - 3, path + "3");
	}
}
