import java.util.*;

public class KnightsTour {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] chessBoard = new int[n][n];
		int row = sc.nextInt();
		int col = sc.nextInt();

		printKnightsTour(chessBoard, row, col, 1);
	}

	public static void printKnightsTour(int[][] chessBoard, int row, int col, int moveNumber) {
		// don't need to keep a visited array here since the matrix is empty and the values
		// in it do the same thing
		if (row >= chessBoard.length || col >= chessBoard[0].length || row < 0 || col < 0 || chessBoard[row][col] > 0) {
			return;
		} else if (moveNumber == (chessBoard.length * chessBoard[0].length)) {
			// when the move number will be same line 31 & 42 will not be called
			// therefore need to assign it here as well
			chessBoard[row][col] = moveNumber;

			displayChessBoard(chessBoard);

			chessBoard[row][col] = 0; // there may be other configurations present as well

			return;
		}

		chessBoard[row][col] = moveNumber;

		printKnightsTour(chessBoard, row - 2, col + 1, moveNumber + 1);
		printKnightsTour(chessBoard, row - 1, col + 2, moveNumber + 1);
		printKnightsTour(chessBoard, row + 1, col + 2, moveNumber + 1);
		printKnightsTour(chessBoard, row + 2, col + 1, moveNumber + 1);
		printKnightsTour(chessBoard, row + 2, col - 1, moveNumber + 1);
		printKnightsTour(chessBoard, row + 1, col - 2, moveNumber + 1);
		printKnightsTour(chessBoard, row - 1, col - 2, moveNumber + 1);
		printKnightsTour(chessBoard, row - 2, col - 1, moveNumber + 1);

		chessBoard[row][col] = 0;
	}

	public static void displayChessBoard(int[][] chessBoard) {
		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard[i].length; j++) {
				System.out.print(chessBoard[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}