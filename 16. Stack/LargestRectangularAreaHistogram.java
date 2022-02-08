import java.util.*;

public class LargestRectangularAreaHistogram {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println(getMaxAreaNaive(arr));
    System.out.println(getMaxAreaBetter(arr));
  }

  public static int getMaxAreaBetter(int[] arr) {
    int n = arr.length;

    int[] ps = getPreviousSmaller(arr);
    int[] ns = getNextSmaller(arr);

    int maxArea = 0;

    for (int i = 0; i < n; i++) {
      int currentArea = arr[i];
      // get area from left bars
      currentArea += (i - ps[i] - 1) * arr[i];
      // get area from right bars
      currentArea += (ns[i] - i - 1) * arr[i];

      // this is equivalent to int currentArea = (ns[i] - ps[i] - 1)*arr[i]

      maxArea = Math.max(maxArea, currentArea);
    }

    return maxArea;
  }

  private static int[] getPreviousSmaller(int[] arr) {
    Stack<Integer> st = new Stack<>();
    int[] ps = new int[arr.length];

    st.push(0);

    for (int i = 0; i < arr.length; i++) {
      while (st.isEmpty() == false && arr[st.peek()] >= arr[i]) {
        st.pop();
      }

      ps[i] = st.isEmpty() ? -1 : st.peek();

      st.push(i);
    }

    return ps;
  }

  private static int[] getNextSmaller(int[] arr) {
    Stack<Integer> st = new Stack<>();
    int[] ns = new int[arr.length];

    st.push(arr.length - 1);

    for (int i = arr.length - 1; i >= 0; i--) {
      while (st.isEmpty() == false && arr[st.peek()] >= arr[i]) {
        st.pop();
      }

      ns[i] = st.isEmpty() ? arr.length : st.peek();

      st.push(i);
    }

    return ns;
  }

  public static int getMaxAreaNaive(int[] arr) {
    int n = arr.length;

    int res = 0;

    for (int i = 0; i < n; i++) {
      // since width is 1 only
      int currentBarArea = arr[i];

      // check bars on the left side
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] >= arr[i]) {
          // adding arr[i] since bars height should be same to make a rectangle
          currentBarArea += arr[i];
        } else {
          break;
        }
      }

      // check on the right side
      for (int j = i + 1; j < n; j++) {
        if (arr[j] >= arr[i]) {
          // adding arr[i] since bars height should be same to make a rectangle
          currentBarArea += arr[i];
        } else {
          break;
        }
      }

      // calculate maximum area
      res = Math.max(currentBarArea, res);
    }

    return res;
  }
}