import java.util.*;

public class PrintMazePath {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();

		printMP(1, 1, m, n, "");
	}

	public static void printMP(int srcRow, int srcCol, int desRow, int desCol, String path) {
		if (srcRow == desRow && srcCol == desCol) {
			System.out.println(path);
			return;
		} else if (srcRow > desRow || srcCol > desCol) {
			return;
		}

		printMP(srcRow, srcCol + 1, desRow, desCol, path + "h");
		printMP(srcRow + 1, srcCol, desRow, desCol, path + "v");
	}
}