import java.util.*;

/* This is a stack problem but did not used stack to solve it */

public class CelebrityProblem {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] mat = new int[n][n];

    for(int i = 0;i < mat.length;i++){
      for(int j = 0;j < mat[0].length;j++){
        mat[i][j] = sc.nextInt();
      }
    }

    System.out.println(findCelebrityNaive(mat));
    System.out.println(findCelebrityEfficient(mat));
  }

  public static int findCelebrityEfficient(int[][] arr){
    // T.C -> O(n) & S.C -> O(1)
    int n = arr.length;

    // initially let it be 0th person
    int c = 0;

    for(int i = 1; i < n;i++){
      // check if current celebrity knows someone
      if(arr[c][i] == 1){
        // if current knows someone make them the new celebrity
        c = i;
      }
    }

    // this does not assure that we will get the exact person so check again but for this celebrity only

    for(int i = 0;i < n;i++){
      // should not check for arr[i][i] since that is not valid
      if(i != c && (arr[c][i] == 1 || arr[i][c] == 0)){
        // if the second condition returns true then that is not the celebrity
        return -1;
      }
    }

    return c;
  }

  public static int findCelebrityNaive(int[][] arr){
    // T.C -> O(n^2) & S.C -> O(n)
    int n = arr.length;

    /* 
      * in[i] will store how many people knows i
      * out[i] will store how many people i knows 
    */
    int[] in = new int[n];
    int[] out = new int[n];

    for(int i = 0;i < n;i++){
      for(int j = 0;j < n;j++){
        if(arr[i][j] == 1){
          // this means that i knows j
          // increase for people that know j
          in[j]++;
          // increase for people that i knows
          out[i]++;
        }
      }
    }

    for(int i = 0;i < n;i++){
      if(out[i] == 0 && in[i] == n - 1){
        return i;
      }
    }

    // if no celebrity
    return -1;
  }
}