import java.util.*;

public class NextGreaterElement {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0;i < arr.length;i++){
      arr[i] = sc.nextInt();
    }

    printNextGreaterNaive(arr);
    System.out.println();
    printNextGreaterEfficient(arr);
  }

  public static void printNextGreaterEfficient(int[] arr){
    // can be implemented using both indexes and values
    // the only problem is that the output is printed in the reverse order
    // could be solved by jsut using a array and putting values at the same index and printing that

    int n = arr.length;
    Stack<Integer> st = new Stack<>();

    // last element
    st.push(n - 1);
    System.out.print(-1 + " ");

    for(int i = n - 2;i >= 0;i--){
      while(st.isEmpty() == false && arr[st.peek()] <= arr[i]){
        st.pop();
      }

      int nextGreaterElement = st.isEmpty() ? -1 : arr[st.peek()];
      System.out.print(nextGreaterElement + " ");
      st.push(i);
    }
  }

  public static void printNextGreaterNaive(int[] arr){
    int n = arr.length;

    for(int i = 0;i < n;i++){
      int j;
      for(j = i + 1;j < n;j++){
        if(arr[j] >= arr[i]){
          System.out.print(arr[j] + " ");
          break;
        }
      }
      if(j == n){
        System.out.print(-1 + " ");
      }
    }
  }
}