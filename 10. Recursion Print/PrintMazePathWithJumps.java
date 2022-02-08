import java.util.*;

public class PrintMazePathWithJumps {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();

		printMPWJ(1, 1, m, n, "");
	}

	public static void printMPWJ(int srcRow, int srcCol, int desRow, int desCol, String path) {
		if (srcRow == desRow && srcCol == desCol) {
			System.out.println(path);
			return;
		}

		// horizontal jumps
		for (int moveSize = 1; moveSize <= desCol - srcCol; moveSize++) {
			printMPWJ(srcRow, srcCol + moveSize, desRow, desCol, path + "h" + moveSize);
		}

		// vertical jumps
		for (int moveSize = 1; moveSize <= desRow - srcRow; moveSize++) {
			printMPWJ(srcRow + moveSize, srcCol, desRow, desCol, path + "v" + moveSize);
		}

		// diagonal jumps
		for (int moveSize = 1; moveSize <= desRow - srcRow && moveSize <= desCol - srcCol; moveSize++) {
			printMPWJ(srcRow + moveSize, srcCol + moveSize, desRow, desCol, path + "d" + moveSize);
		}
	}
}