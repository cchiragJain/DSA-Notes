import java.util.*;

public class CountMazePath {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();

		System.out.println(uniquePaths(1, 1, m, n));
	}

	public static int uniquePaths(int srcRow, int srcCol, int desRow, int desCol) {
		if (srcRow == desRow && srcCol == desCol) {
			return 1;
		} else if (srcRow > desRow || srcCol > desCol) {
			return 0;
		}

		int countHorizontal = uniquePaths(srcRow, srcCol + 1, desRow, desCol);
		int countVertical = uniquePaths(srcRow + 1, srcCol, desRow, desCol);

		return countHorizontal + countVertical;
	}
}