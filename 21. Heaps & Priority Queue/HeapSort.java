import java.util.*;

// REFER NOTES
// T.C -> O(N LOG N)
// NOT STABLE
public class HeapSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < arr.length;i++){
            arr[i] = sc.nextInt();
        }

        heapSort(arr);

        for(int val : arr){
            System.out.print(val + " ");
        }
    }

    // MAX HEAP use karke increasing order mein hoga
    // MIN HEAP use karke decreasing order mein hoga
    public static void heapSort(int[] arr){
        int n = arr.length;

        // build a max heap for the given array
        // changes the original array only
        buildHeap(arr);

        // the first node will have the higheest value of the heap
        // swap it at the end of heap (array) and reduce the size of the array in the heapify call to maintain the heap strucutre. 
        // jab 1 se n - 1 vaale idx hojaaega toh first bhi ho jaaega no need to call for it again
        for(int i = n - 1;i > 0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // size khaali i consider hoga fir
            maxHeapify(arr,i,0);
        }
    }
    
    // similar to building a min heap
    // T.C -> O(N)
    private static void buildHeap(int[] arr){
        for(int i = (arr.length/2 - 1);i >=0;i--){
            maxHeapify(arr,arr.length,i);
        }
    }

    private static void maxHeapify(int[] arr,int n,int i){
        // int n = arr.length;

        int lt = (2 * i) + 1;
        int rt = (2 * i) + 2;

        int largest = i;

        if(lt < n && arr[lt] > arr[i]){
            largest = lt;
        }

        if(rt < n && arr[rt] > arr[largest]){
            largest = rt;
        }

        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            maxHeapify(arr,n,largest);
        }
    }
}