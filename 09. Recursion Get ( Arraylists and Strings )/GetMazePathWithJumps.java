import java.util.*;

public class GetMazePathWithJumps {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();

		ArrayList<String> paths = gmpwj(1, 1, rows, cols);
		System.out.println(paths);

		System.out.println(paths.size());

	}

	public static ArrayList<String> gmpwj(int srcRow, int srcCol, int desRow, int desCol) {
		if (srcCol == desCol && srcRow == desRow) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}

		// we don't need the other base case of if source exceeds destination because
		// already checking the condition while calling the function in the for loop

		ArrayList<String> result = new ArrayList<>();

		for (int i = 1; i <= desCol - srcCol; i++) {
			ArrayList<String> horizontalPaths = gmpwj(srcRow, srcCol + i, desRow, desCol);
			for (String horizontalPath : horizontalPaths) {
				result.add("h" + i + horizontalPath);
			}
		}

		for (int i = 1; i <= desRow - srcRow; i++) {
			ArrayList<String> verticalPaths = gmpwj(srcRow + i, srcCol, desRow, desCol);
			for (String verticalPath : verticalPaths) {
				result.add("v" + i + verticalPath);
			}
		}

		// for diagonal jumps we need to check for both row and column boundary
		for (int i = 1; i <= desRow - srcRow && i <= desCol - srcCol; i++) {
			ArrayList<String> diagonalPaths = gmpwj(srcRow + i, srcCol + i, desRow, desCol);
			for (String diagonalPath : diagonalPaths) {
				result.add("d" + i + diagonalPath);
			}
		}
		return result;
	}
}