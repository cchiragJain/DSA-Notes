import java.util.*;

public class FloodFill {
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

		// boolean array default value is false
		boolean[][] visited = new boolean[m][n];
		floodFill(arr, 0, 0, "", visited);
	}

	public static void floodFill(int[][] maze, int row, int col, String answer, boolean[][] visited) {
		// the condition is written in such a way that any out of bounds index
		// is not checked in the last part of the condition
		// because OR works in such a way that
		// if any of the previous condition are true the last one would not be checked

		if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length || maze[row][col] == 1 || visited[row][col]) {
			return;
		}

		if (row == maze.length - 1 && col == maze[0].length - 1) {
			System.out.println(answer);
			return;
		}

		// when arrive at a entry mark it as visited
		visited[row][col] = true;

		// EXPLORING ALL THE PATHS/OPTIONS
		// top
		floodFill(maze, row - 1, col, answer + "t", visited);
		// left
		floodFill(maze, row, col - 1, answer + "l", visited);
		// down
		floodFill(maze, row + 1, col, answer + "d", visited);
		// right
		floodFill(maze, row, col + 1, answer + "r", visited);

		// after exploring all the options mark the entry as not visited for other paths
		visited[row][col] = false;
	}
}
/*
TEST INPUT
6
7
0 1 0 0 0 0 0
0 1 0 1 1 1 0
0 0 0 0 0 0 0
1 0 1 1 0 1 1
1 0 1 1 0 1 1
1 0 0 0 0 0 0
*/