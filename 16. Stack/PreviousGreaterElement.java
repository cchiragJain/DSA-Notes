import java.util.*;

public class PreviousGreaterElement {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0;i < arr.length;i++){
      arr[i] = sc.nextInt();
    }

    printPreviousGreaterNaive(arr);
    System.out.println();
    printPreviousGreaterEfficient(arr);
  }

  public static void printPreviousGreaterEfficient(int[] arr){
    // should probably use indexes only
    Stack<Integer> st = new Stack<>();

    // first is always going to be -1
    st.push(arr[0]);
    System.out.print(-1 + " ");

    for(int i = 1;i < arr.length;i++){
      while(st.isEmpty() == false && st.peek() <= arr[i]){
        st.pop();
      }

      int previousGreater = st.isEmpty() ? -1 : st.peek();

      System.out.print(previousGreater + " ");
      st.push(arr[i]);
    }
  }

  public static void printPreviousGreaterNaive(int[] arr){
    for(int i = 0;i < arr.length;i++){
      int j;
      for(j = i - 1 ;j >= 0;j--){
        // check if previous element is greater
        if(arr[j] > arr[i]){
          System.out.print(arr[j] + " ");
          break;
        }
      }
      if(j == -1){
        // if no greater is found till the 0th index then j would become -1
        System.out.print(-1 + " ");
      }
    }
  }
}

