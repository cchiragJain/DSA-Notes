import java.util.*;

/*
	The matrix is given to be both row wise and column wise sorted.
*/
public class SearchIn2DSorted {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[m][n];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int x = sc.nextInt();

		// can also just print the answer
		ArrayList<Integer> result = new ArrayList<>();
		result = search(arr, x);

		System.out.println(result);
	}

	public static ArrayList<Integer> search(int[][] arr, int x) {
		ArrayList<Integer> result = new ArrayList<>();

		int startRow = 0;
		int startCol = arr[0].length - 1;

		while (startRow < arr.length && startCol >= 0) {
			if (arr[startRow][startCol] == x) {
				result.add(startRow);
				result.add(startCol);
				break;
			} else if (arr[startRow][startCol] > x) {
				startCol--;
			} else if (arr[startRow][startCol] < x) {
				startRow++;
			}
		}

		return result;
	}
}