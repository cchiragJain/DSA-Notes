import java.util.*;

public class CountNQueens {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] visited = new int[n][n];

		int result = countQueensPositions(n, visited, 0);
		System.out.println(result);
	}

	public static int countQueensPositions(int n, int[][] visited, int row) {
		if (row == visited.length) {
			return 1;
		}

		int count = 0;
		for (int col = 0; col < visited[0].length; col++) {
			if (isItSafeToPutQueen(visited, row, col)) {
				visited[row][col] = 1;
				count += countQueensPositions(n, visited, row + 1);
				visited[row][col] = 0;
			}
		}

		return count;
	}

	public static boolean isItSafeToPutQueen(int[][] visited, int row, int col) {
		// check if any queen is there in up direction
		for (int i = row - 1, j = col; i >= 0; i--) {
			if (visited[i][j] == 1)
				return false;
		}

		// check left diagonal if any queen is alredy present
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (visited[i][j] == 1)
				return false;
		}

		// check right diagonal if any queen is alredy present
		for (int i = row - 1, j = col + 1; i >= 0 && j < visited[0].length; i--, j++) {
			if (visited[i][j] == 1)
				return false;
		}

		return true;

	}
}