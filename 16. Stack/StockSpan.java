import java.util.*;

public class StockSpan {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    /* Array Input */
    int n = sc.nextInt();
    int[] arr = new int[n];

    for(int i = 0;i < arr.length;i++){
      arr[i] = sc.nextInt();
    }

    printSpanNaive(arr);
    System.out.println();
    printSpanEfficient(arr);
  }

  // could also use a span array of same length
  public static void printSpanEfficient(int[] arr){
    Stack<Integer> st = new Stack<>();

    // first element index 
    st.push(0);

    System.out.print(1 + " ");

    for(int i = 1; i < arr.length;i++){
      while(st.isEmpty() == false && arr[st.peek()] <= arr[i]){
        st.pop();
      }

      int span = st.isEmpty() ? i + 1 : i - st.peek();

      System.out.print(span + " ");
      st.push(i);
    }

    System.out.println("Stack -> " + st);
  }

  public static void printSpanNaive(int[] arr){
    for(int i = 0;i < arr.length;i++){
      int span = 1;
      for(int j = i - 1;j >=0 ;j--){
        if(arr[j] <= arr[i]){
          span++;
        } else{
          break;
        }
      }
      System.out.print(span + " ");
    }

  }
}