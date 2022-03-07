import java.util.*;
// MaxHeap is pretty similar just reverse the conditions

// REFER NOTEBOOK NOTES FOR HEAP defintions
public class MinHeap {
    int[] arr;
    int size;
    int capacity;

    public MinHeap(int capacity){
        this.capacity = capacity;
        this.size = 0;

        arr = new int[this.capacity];
    }

    public int left(int i){
        return (2 * i + 1);
    }

    public int right(int i){
        return (2 * i + 2);
    }

    public int parent(int i){
        return ((i - 1)/2);
    }

    // O(log n) H
    public void insert(int val){
        if(this.size == this.capacity){
            return;
        }

        // put value at end
        arr[++this.size - 1] = val;

        int i = this.size - 1;
        // keep swapping the element if it less than parent (should be greater than parent for min heap property)
        while(i != 0 && arr[i] < arr[parent(i)]){
            // swap array elements
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;

            // update i to parent to check for next swap
            i = parent(i);
        }
    }

    // T.C -> O(log n) H-> height S.C -> O(H)
    // heapify given a index put it at the correct position in the binary heap
    // heapify assumes that only the given node may be violating the property other nodes will be completely fine
    // heapify leaf nodes ko consider hi nahi karta kyuki uske bina bhi kaam chal jaaat hain
    // uske upar vaala node hua toh voh swap kardega
    public void minHeapify(int i){
        int lt = left(i);
        int rt = right(i);

        int smallest = i;
        
        // calculate the smallest of left current and right
        if(lt < size && arr[lt] < arr[i]){
            smallest = lt;
        }
        if(rt < size && arr[rt] < arr[smallest]){
            smallest = rt;
        }

        // if smallest got updated 
        if(smallest != i){
            // swap with the smaller value
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            // call to check this smallest index if whether this at the current index or not
            minHeapify(smallest);
        }
    }

    // T.C -> O(log n)
    // remove the minimum element from a minheap and returns it
    // the min element will be the first element only
    public int extractMin(){
        if(this.size == 0){
            return Integer.MAX_VALUE;
        }

        if(this.size == 1){
            this.size--;
            return arr[0];
        }

        // swap with the last element 
        int temp = arr[0];
        arr[0] = arr[this.size - 1];
        arr[this.size - 1] = temp;

        // reduce the size so now this wont be counted when doing other operations
        this.size--;

        // the last element which was put at the top can now be anything so put it at its correct position
        minHeapify(0);

        // return the removed element
        return temp; // return arr[this.size];
    }

    // UPDATE value at the given index
    // T.C -> O(log n)
    public void decreaseKey(int i,int val){
        if(i >= this.size){
            return;
        }

        // update the value
        arr[i] = val;  

        // keep swapping until not at the correct position in heap
        // should be at the point where arr[i] is greater than its parent
        while(i != 0 && arr[i] < arr[parent(i)]){
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;

            i = parent(i);
        }
    }

    public void delete(int i){
        // this will put the value at top of the heap 
        // the min value that is possible
        decreaseKey(i,Integer.MIN_VALUE);

        // now remove the this element since it will be the min value
        extractMin();
    }

    // REFER NOTEBOOK
    // T.C -> O(N) can prove it mathematically looks O(Nlogn) though
    public void buildHeap(){
        for(int i = this.size/2 - 1;i >= 0;i--){
            minHeapify(i);
        }
    }
}