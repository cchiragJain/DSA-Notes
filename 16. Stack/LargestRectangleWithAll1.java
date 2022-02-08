import java.util.*;

public class LargestRectangleWithAll1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();

    int[][] mat = new int[m][n];

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        mat[i][j] = sc.nextInt();
      }
    }

    System.out.println(largestArea(mat));
  }

  /*
   * for largestAreaHistogram definition refer
   * largestRectangularAreaHistogram.java
   */

  /*
   * T.C -> O(R*C)
   * S.C -> O(C)
   */
  public static int largestArea(int[][] mat) {
    // get the first row and initialise its area as the max area
    // S.C -> O(C)
    int[] currentRow = mat[0];
    int maxArea = largestAreaHistogram(currentRow);

    // start from the second row and for each element add it to the column of
    // currentRow if 1 and if 0 make it 0
    for (int i = 1; i < mat.length; i++) {
      // T.C -> O(R) for outer loop
      for (int j = 0; j < mat[0].length; j++) {
        // T.C -> O(C) for this inner loop
        if (mat[i][j] == 1) {
          currentRow[j] += 1;
        } else {
          currentRow[j] = 0;
        }
      }

      // T.C -> O(C) & S.C -> O(C)
      int currentArea = largestAreaHistogram(currentRow);
      maxArea = Math.max(currentArea, maxArea);
    }

    return maxArea;
  }
}