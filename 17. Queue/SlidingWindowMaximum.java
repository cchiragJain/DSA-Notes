import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0;i < arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        printWindowMaximumNaive(arr,k);
        System.out.println();
        slidingWindowMaximumEfficient(arr,k);
    }
    
    public static void slidingWindowMaximumEfficient(int[] arr,int k){
        // T.C -> O(n) on average S.C -> O(n)
        // can be O(n^2) in the worst case if all are increasing order
        int n = arr.length;

        int[] nge = getNextGreaterElementArray(arr);

        int j = 0;
        // traverse till the start of last window
        for(int i = 0;i <= n - k;i++){
            
            // j can be greater than i since it represents the maximum index of the current window
            // if somehow not updated with current i when in previous itertation i was the max then update it
            if(j < i){
                j = i;
            }

            // nge array stores indexes
            // if next greater of j is inside our current window then keep going to the next greater element
            while(nge[j] < i + k){
                j = nge[j];
            }

            // if j next greater is outside current window then that will be the answer
            System.out.print(arr[j] + " ");
        }
    }    

    private static int[] getNextGreaterElementArray(int[] arr){
        int n = arr.length;

        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];

        st.push(n - 1);
        nge[n - 1] = n;

        for(int i = n - 2;i >= 0;i--){
            while(st.isEmpty() == false && arr[st.peek()] <= arr[i]){
                st.pop();
            }

            nge[i] = st.isEmpty() ? n : st.peek();
            
            st.push(i);
        }

        return nge;
    }

    public static void printWindowMaximumNaive(int[] arr,int k){
        for(int i = 0;i <= arr.length - k;i++){
            int max = arr[i];
            for(int j = i;j <= i + k - 1;j++){
                max = Math.max(arr[j],max);
            }
            System.out.print(max + " ");
        }
    }
}