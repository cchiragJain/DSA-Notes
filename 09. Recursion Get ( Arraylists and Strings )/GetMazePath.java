import java.util.*;

public class GetMazePath {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int rows = sc.nextInt();
		int cols = sc.nextInt();

		ArrayList<String> paths = gmp(1, 1, rows, cols);
		System.out.println(paths);
	}

	public static ArrayList<String> gmp(int srcRow, int srcCol, int desRow, int desCol) {

		if (srcCol == desCol && srcRow == desRow) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}

		if (srcCol > desCol || srcRow > desRow) {
			ArrayList<String> baseResult = new ArrayList<>();
			return baseResult;
		}

		ArrayList<String> horizontalPaths = gmp(srcRow, srcCol + 1, desRow, desCol);
		ArrayList<String> verticalPaths = gmp(srcRow + 1, srcCol, desRow, desCol);


		ArrayList<String> result = new ArrayList<>();

		for (String horizontalPath : horizontalPaths)
			result.add("h" + horizontalPath);

		for (String verticalPath : verticalPaths)
			result.add("v" + verticalPath);

		return result;

	}
}