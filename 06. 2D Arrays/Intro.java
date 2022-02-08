import java.util.*;

public class Intro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // taking dimensions input
        int n = sc.nextInt();
        int m = sc.nextInt();

        // declaring array
        int[][] arr = new int[n][m];

        // taking input from user
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // output array in matrix form
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}