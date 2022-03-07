import java.util.*;
/* Contains -> 
        1. K largest elements
        2. Sort k sorted array
        3. Purchase Maximum
        4. K Closest elements
        5. Merge K Sorted lists
        6. Median of a stream
*/

public class HeapQuestions {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int[] arr = new int[n];
        // for(int i = 0;i < arr.length;i++){
        //     arr[i] = sc.nextInt();
        // }

        // kLargest(arr,3);
        // sortKSorted(arr,2);
        // printKClosest(arr,35,3);
        // List<List<Integer>> arr = new ArrayList<>();
        // List<Integer> a1 = new ArrayList<Integer>(); 
        // a1.add(10); 
        // a1.add(20);
        // a1.add(30);
        // arr.add(a1); 
  
        // List<Integer> a2 = new ArrayList<Integer>(); 
        // a2.add(5);
        // a2.add(15);
        // arr.add(a2); 
  
        // List<Integer> a3 = new ArrayList<Integer>(); 
        // a3.add(1); 
        // a3.add(9); 
        // a3.add(11);
        // a3.add(18);
        // arr.add(a3);

        // System.out.println(mergeKSortedList(arr));
    }

    /* -------------------------K LARGEST ELEMENTS---------------------------- 
        Given array and a k value print the k largest elements from the array
        IN ASCENDING ORDER ONLY
    */
    public static void kLargest(int[] arr,int k){
        // T.C -> O(n log k) S.C -> O(K)
        // n log k n ka toh loop hain aur har time pe k elements hi hoge toh uska poll aur add log k hi hoga
        // Doint it this way since need to print in ascending order
        // If that was not the case just use a maxheap pq and keep printing the top k-- elements which will have T.C of O(k log n)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // highest priority chotti value ko milegi

        // Peek pe hamesha min value rehni hain aur vohi nikalit rahegi agar bada mil gaya toh
        for(int i = 0;i < k;i++){
            pq.add(arr[i]);
        }

        // at any moment we will only have the k largest elements seen so far in the pq
        for(int i = k;i < arr.length;i++){
            if(pq.peek() < arr[i]){
                // agar peek chotti h toh usko nikal aur current ko add karde
                pq.poll();
                pq.add(arr[i]);
            }
        }

        // aakgri mein khaali max hi bachege
        System.out.println(pq); 

        /* Naive toh sort karke last ke k print kardo */
    }

    /* -------------------------SORT A K SORTED ARRAY--------------------------
        Given an array which is k sorted means any i should lie in the range i - k to i + k
        Sort it
        Ex. [9,8,7,18,19,17] k = 2
        O/P [7,8,9,17,18,19]
    */
    public static void sortKSorted(int[] arr,int k){
        /* Navie would just be to ignore k and sort the array in O(N log n) time */

        // S.C O(k) achieve karni h varna maxhead mein add karke saare list mein add kardete poll ko
        // agar inplace karna h toh ek array ka index variable rakh aur har bar index++ pe pq.poll() karde

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 0 ki range 0 se k tak hogi isie <=k
        for(int i = 0;i <= k;i++){
            pq.add(arr[i]);
        }

        // ab min element nikalte raho aur naya daalte raho
        for(int i = k + 1;i < arr.length;i++){
            System.out.print(pq.poll() + " ");
            pq.add(arr[i]);
        }

        // bache kuche elements ko bhi nikal do
        while(pq.isEmpty() == false){
            System.out.print(pq.poll() + " ");
        }
    }

    /* ---------------------PURCHASING MAXIMUM ITEMS---------------------------
        Given array consisting of costs and a sum value return the maximum items that could be purchases of the sum
        Ex. -> [20,10,5,30,100] sum = 35
        O/P -> 3
                Can purchase 20 10 5 which will have a sum of 35
        [1,12,5,111,200] sum = 10
        O/P -> 2 
                Can purchase 1 and 5 
    */
    public static int purchaseMaximumItems(int[] arr,int sum){
        // BETTER METHOD WOULD BE TO USE a heap and then do the same steps as naive and then the T.C -> O(res log n) where res can be much smaller than n
        // T.C -> O(res log n) S.C -> O(N) since using priority queueu
        // if allowed to make changes to the array can write our own buildHeap function which will take O(N) time and O(1) space
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i < arr.length;i++){
            pq.add(arr[i]);
        }

        int res = 0;
        
        while(sum >= 0){
            sum-= pq.poll();
            if(sum >= 0){
                res++;
            }
        }

        return res;

        /* 
        NAIVE METHOD T.C -> O(N logn) S.C -> O(1)
        S.C can be O(N) if not allowed to modify the original array

        Sort the array keep a counter variable for each arr[i] subtract it from the sum and if sum >= 0 (means can buy) increase coutn
        Arrays.sort(arr);
        int res = 0;

        for(int i = 0;i < arr.length;i++){
            sum-= arr[i];
            if(sum >= 0){
                res++;
            }else if(sum < 0){
                break;
            }
        } 

        return res;
        */
    }


    /* --------------------------K CLOSEST ELEMENT----------------------------- 
        Given arr a value and k find the k closest elements of value in array
        Ex. -> [10,15,7,3,4] val = 8 k = 2
        O/P -> 7 10
    */
    public static void printKClosest(int[] arr,int x,int k){
        // T.C -> O(Klogk)
        // array ke values mein se val subtract kardege toh closest value less value vaali hogi

        // k smallest hi h yeh bas
        // pq mein hum closest difference store kar rahe index ke saath
        // smallest difference rakh rahe h bas iske andar at any moment
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0;i < k;i++){
            pq.add(new Pair(Math.abs(arr[i] - x),i));
        }
        
        for(int i = k;i < arr.length;i++){
            int diff = Math.abs(arr[i] - x);
            if(pq.peek().diff > diff){
                pq.poll();
                pq.add(new Pair(diff,i));
            }
        }

        while(k-- > 0){
            System.out.println(pq.poll().idx);
        }

        /* NAIVE  T.C -> Theta(nk) S.C -> Theta(n) 
        boolean[] visited = new int[n];
        int minDiff = Integer.MAX_VALUE;
        int minDiffIdx = 0;

        // i ke times chalega aur har iteration mein ith closest nikalega
        // jaha pe bhi visited pe false hoga aur min diff purane vaale se kam h udhar mark kar dega uspe min diff mark kardo mindiffidx banado
        // har i loop mein agla closest nikal jaaega aur pichla closest consider nahi hoga kyuki voh visisted mark ho jaaega  
        for(int i = 0;i < k;i++){
            for(int j = 0;j < arr.length;j++){
                if(visisted[j] == false && Math.abs(x - arr[j]) <= minDiff)){
                    // update minDiff
                    minDiff = Math.abs(x - arr[j]);
                    // update minDiffIdx
                    minDiffIdx = j;
                }
            }

            System.out.println(arr[minDiffIdx]);
            visisted[minDiffIdx] = true;
        }
        */
    }

    /* -------------------------MERGE K SORTED ARRAYS-------------------------
        Given k list of lists where each list is sorted merge them into a sorted array
        Merge sort mein do hi hoti h bas
    */
    public static List<Integer> mergeKSortedList(List<List<Integer>> arr){
        // refer pepcoding video if can't dry run
        List<Integer> res = new ArrayList<>();

        PriorityQueue<Triplet> pq = new PriorityQueue<>();

        // Har list ka pehla jana daal do
        for(int i = 0;i < arr.size();i++){
            pq.add(new Triplet(i,0,arr.get(i).get(0)));
        }

        // Har vakt top pe sabse min val vaala element hi hoga
        // Ek time mein pq mein at max k elements hi rahega
        while(pq.isEmpty() == false){
            Triplet p = pq.poll();
            res.add(p.val);

            // is list ka dataIdx bad gaya agli baar yeh agle vaala consider karega
            p.dataIdx++;

            // agar yeh naya dataIdx list ke andar hi h list ke end tak nahi phucha h toh pq add kardo 
            if(p.dataIdx < arr.get(p.listIdx).size()){
                // p ki value hi change kardo bas dataidx toh bad hi gaya h aur listIdx same hi rahega
                p.val = arr.get(p.listIdx).get(p.dataIdx);
                // pq mein add kardo agli baar min check ho jaaega
                pq.add(p);
            }
        }
        
        return res;
       /*  
        Better solution using merge function
        T.C -> O(n*k^2) S.C -> O(n*k^2)
        List<Integer> res = new ArrayList<>();
        
        // pehli list add karde
        for(int val : arr.get(0)){
            res.add(val);
        }

        // aage ki k list saari merge karta ja ek ek karke
        for(int i = 1;i < arr.size();i++){
            res = mergeTwoSortedLists(res,arr.get(i));
        }
        
        return res; 
        
        */
        /* NAIVE 
            T.C -> O(kn log kn)
            Saari ek hi 1d list mein daalke sort maardo
            Collections use karna padega kyuki arraylist h  
        
        List<Integer> res = new ArrayList<>();
        // O(kn) where n is the maximum number of elements in the list
        for(List<Integer> list : arr){
            for(int x : list){
                res.add(x);
            }
        }

        // O(kn log kn) kn elements ho jaaege
        Collections.sort(res);

        return res;
        */
    }

    /* private static List<Integer> mergeTwoSortedLists(List<Integer> list1,List<Integer> list2){
        int i = 0;
        int j = 0;
        // int k = 0;

        List<Integer> res = new ArrayList<>(); 

        while(i < list1.size() && j < list2.size()){
            if(list1.get(i) < list2.get(j)){
                res.add(list1.get(i));
                i++;
            } else{
                res.add(list2.get(j));
                j++;
            }
            // k++;
        }

        while(i < list1.size()){
            res.add(list1.get(i));
            i++;
        }

        while(j < list2.size()){
            res.add(list2.get(j));
            j++;
        }

        return res;
    } */

    /* -------------------------MEDIAN OF A STREAM-------------------------------
        Given an array or a stream of numbers find the median
        MEDAIN ke liye ascending order hona chaiye
        Ex. -> arr[] = [25,7,10,15,20]
        Ek ek karke number aarahe assume karle
        O/P -> 25,16,10,12.5,15
    */
    public static void medianOfStream(int[] arr,int n){
        // T.C -> O(N log n) S.C -> O(N)
        PriorityQueue<Integer> g = new PriorityQueue<Integer>();
        PriorityQueue<Integer> s = new PriorityQueue<Integer>(Collections.reverseOrder());
        s.add(arr[0]);
        System.out.print(arr[0]+" ");
        for(int i = 1;i < n;i++){
            int x = arr[i];
            // size ya toh bada hoga s ka ya barabar 
            // agar s ka bada toh g mein dalega x ke hissab se
            // fir answer mean hoga kyuki barabar elements ho gye
            // varna agar barabar h toh s mein hi daal na h kisi hisaab se aur answer s ki peek hi hoga
            // if size is greater should go in the second heap 
            // there can be 2 cases of value of x
            if(s.size()>g.size()) {
                if(s.peek()>x){
                    g.add(s.poll());
                    s.add(x);
                }else g.add(x);
                System.out.print(((double)(s.peek()+g.peek())/2)+" ");
            } else{
                if(x<=s.peek()){
                    s.add(x);
                }else{
                    g.add(x);
                    s.add(g.poll());
                }
                System.out.print(s.peek()+" ");
            }
        }
        /* NAIVE T.C -> O(N^2)
        USE ARRAYLIST RATHER THAN A ARRAY
        Har vakt ek sorted array maintain rakho aur usmiein insert aur uske size ko update karte jaao uske uss sorted array ka median nikal do har baari
        int n = arr.length;
        double[] temp = new double[n];
        int size = 0;

        for(int i = 0;i < n;i++){
            // temp ek sorted array maintain kar rahi h
            temp[i] = arr[i];

            // j temp ka max hogya temp.lenght mein 0 vaale bhi include hoge j pe last element dala
            int j = i;

            // temp ka size increase karde abh tak ka
            size++;

            // agar aage vaale element bada toh usko piche karde
            // piche ki toh sorted h hi
            // normal sort maarege toh 0 bhi aajaaege
            while(j > 0 && arr[j] < arr[j - 1]){
                double t = temp[j];
                temp[j] = temp[j - 1];
                temp[j - 1] = t;
            }
            
            // agar odd elements h toh mid vaala hoga varna even pe toh mid ke 2 ka average
            if(size % 2 != 0){
                System.out.println(temp[size/2]);
            } else {
                System.out.println((temp[size/2] + temp[(size - 1)/2])/2);
            }
        }
        */
    }
}

// PAIR PRIORITY QUEUE KO PAIR KA COMPARISON SIKHANE KE LIYE YEH IMPLEMENT KARNI PADEGI
// INTEGER TOH KARNA JAANTI HAIN
// KONSA PAIR UPAR AANA CHAIYE
// COMPARETO KO OVERRIDE KAR RAHE
class Pair implements Comparable<Pair>{
    int diff;
    int idx;
    Pair(int diff,int idx){
        this.diff = diff;
        this.idx = idx;
    }

    /* compareTo vaala dekhta h agar value positive h toh this ko bada maana jaata h varna agar value chotti toh other ko bada mana jaata h */
    public int compareTo(Pair p){
        // agar diff same h 2 pair ka toh jiska idx bada h voh upars
        if(this.diff == p.diff){
            return this.idx - p.idx;
        } 
        // varna jiska diff bada voh upar
        else {
            return this.diff - p.diff;
        }
    }
}

// compareTo upar se dkh le
class Triplet implements Comparable<Triplet>{
    int listIdx;
    int dataIdx;
    int val;

    Triplet(int listIdx,int dataIdx,int val){
        this.listIdx = listIdx;
        this.dataIdx = dataIdx;
        this.val = val;
    }
    
    // jiski value chotti usko rakhegi
    public int compareTo(Triplet other){
        return this.val - other.val;
    }
}