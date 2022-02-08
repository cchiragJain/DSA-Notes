import java.util.*;

public class GetStairPath {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		ArrayList<String> paths = gsp(n);

		System.out.println(paths);
	}

	public static ArrayList<String> gsp(int n) {
		if (n == 0) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}
		// this path is not possible so even if we are returning a empty arraylist
		// nothing will get added to it since
		// "1" + [] = [] BUT
		// "1" + [""] = ["1"]
		else if (n < 0) {
			ArrayList<String> baseResult = new ArrayList<>();
			return baseResult;
		}

		ArrayList<String> pathsFrom1 = gsp(n - 1);
		ArrayList<String> pathsFrom2 = gsp(n - 2);
		ArrayList<String> pathsFrom3 = gsp(n - 3);

		ArrayList<String> paths = new ArrayList<>();

		for (String path : pathsFrom1) {
			paths.add("1" + path);
		}
		for (String path : pathsFrom2) {
			paths.add("2" + path);
		}
		for (String path : pathsFrom3) {
			paths.add("3" + path);
		}

		return paths;
	}
}