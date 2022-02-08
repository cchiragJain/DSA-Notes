import java.util.*;

public class NQueens {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] chessBoard = new int[n][n];

		printNQueens(chessBoard, "", 0);
	}

	public static void printNQueens(int[][] chessBoard, String queenPositions, int row) {
		// row -> level
		// col -> options

		if (row == chessBoard.length) {
			System.out.println(queenPositions);
			return;
		}

		// could also use a boolean chessBoard
		for (int col = 0; col < chessBoard[0].length; col++) {
			if (isItSafeToPutQueen(chessBoard, row, col)) {

				// put queen at that place
				chessBoard[row][col] = 1;
				// go to next level
				printNQueens(chessBoard, queenPositions + row + "-" + col + " ", row + 1);

				// remove queen from the place for other options to work
				chessBoard[row][col] = 0;
			}
		}
	}

	public static boolean isItSafeToPutQueen(int[][] chessBoard, int row, int col) {
		// check if any queen is there in up direction
		for (int i = row - 1, j = col; i >= 0; i--) {
			if (chessBoard[i][j] == 1)
				return false;
		}

		// check left diagonal if any queen is alredy present
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (chessBoard[i][j] == 1)
				return false;
		}

		// check right diagonal if any queen is alredy present
		for (int i = row - 1, j = col + 1; i >= 0 && j < chessBoard[0].length; i--, j++) {
			if (chessBoard[i][j] == 1)
				return false;
		}

		return true;

	}
}