import java.util.*;

/* 
    Contains ->
        1. Count distinct elements in array
        2. Frequency of array elements
        3. Intersection & Union of arrays
        4. Pair with given sum
        5. Subarray with 0 sum
        6. Subarray with given sum
        7. Length of largest Subarray with given sum
        8. Longest subarray with equal 0 & 1
*/
public class HashMapQuestions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* take array input */
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < arr.length;i++){
            arr[i] = sc.nextInt();
        }

        // System.out.println(countDistinctElements(arr));
        // arrayFrequency(arr);
        // System.out.println(intersection(new int[]{10,15,20,5,30,5},new int[]{30,5,30,80}));
        // System.out.println(union(new int[]{15,20,5,15},new int[]{15,15,15,20,10}));
        // System.out.println(hasPair(arr,100));
        // System.out.println(hasSubarrayWithZeroSum(arr));
        // System.out.println(hasSubarrayWithSum(arr,22));
        System.out.println(longestSubarrayWithSum(arr,4));

    }

    /* ---------------COUNT DISTINCT ELEMENTS------------------------ */
    public static int countDistinctElements(int[] arr){
        /* EFFICIENT T.C -> O(N) & S.C -> O(N) */
        HashSet<Integer> hs = new HashSet<>();
        // add array elements to the hashset
        for(int val:arr){
            hs.add(val);
        }
        return hs.size();


        /* NAIVE T.C -> O(n^2)
        int count = 0;

        for(int i = 0;i < arr.length;i++){
            boolean flag = false;
            // traverse till (i - 1) index & check if the current element was present before or not
            // if element present set flag to true and break the loop this should not be counted in our final result
            for(int j = 0;j < i;j++){
                if(arr[i] == arr[j]){
                    flag = true;
                    break;
                }
            }

            if(flag == false){
                count++;
            }
        }

        return count;
        */
    }

    /* --------------FREQUENCY OF ARRAY ELEMENTS--------------------- */
    public static void arrayFrequency(int[] arr){
        // EFFICIENT T.C -> O(N) & S.C -> O(N)
        HashMap<Integer,Integer> hm = new HashMap<>();
        // make a frequency map
        for(int key : arr){
            // getOrDefault if already present gets the value or else uses the default value provided which will be 0 in here
            hm.put(key,hm.getOrDefault(key,0) + 1);
        }

        for(int key:hm.keySet()){
            System.out.println(key + "->" + hm.get(key));
        }

        /* NAIVE T.C -> O(n^2) 
        for(int i = 0;i < arr.length;i++){
            boolean flag = false;
            // need to check if already seen or not
            for(int j = 0;j < i;j++){
                if(arr[j] == arr[i]){
                    flag = true;
                    break;
                }
            }

            if(flag == true){
                // this element has already been printed before no need to print again
                continue;
            }

            // each will have a freq of 1
            int freq = 1;
            // iterate from the next element
            for(int j = i + 1;j < arr.length;j++){
                if(arr[j] == arr[i]){
                    freq++;
                }
            }

            System.out.println(arr[i] + "->" + freq);
        } */
    }

    /* ------------------INTERSECTION OF ARRAYS----------------------- 
        Given 2 array return the no of common elements
    */
    public static int intersection(int[] arr1,int[] arr2){
        // BEST using single set T.C -> O(M+N) S.C -> O(M) 
        int res = 0;
        HashSet<Integer> hs = new HashSet<>();

        // add to a set
        for(int val:arr1){
            hs.add(val);
        }

        for(int val:arr2){
            if(hs.contains(val)){
                res++;
                // remove the value from set so for another occurence in this second array it would not be counted
                hs.remove(val);
            }
        }

        return res;
        /* EFFICIENT using 2 sets T.C -> O(M + N) S.C -> O(M + N)
        int res = 0;
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();

        // add values of arr1 & arr2 to a set
        for(int val:arr1){
            hs1.add(val);
        }
        for(int val:arr2){
            hs2.add(val);
        }

        for(int val:hs1){
            if(hs2.contains(val)) res++;
        }

        return res; 
        */

        /* NAIVE T.C -> O(N^2)
        int res = 0;
        for(int i = 0;i < arr1.length;i++){
            // check if already present in the same array or not
            boolean flag = false;
            for(int j = 0;j < i;j++){
                if(arr1[j] == arr1[i]){
                    flag = true;
                    break;
                }
            }

            if(flag == true){
                continue;
            }

            // check if present in other array
            for(int j = 0;j < arr2.length;j++){
                if(arr2[j] == arr1[i]){
                    res++;
                    // need to break since could be present multiple times
                    break;
                }
            }
        }

        return res;
        */
    }

    /* -----------------UNION OF TWO ARRAYS--------------------------
        Given 2 arrays count the no of distinct elements in them
     */

    public static int union(int[] arr1,int[] arr2){
        // EFFICIENT -> T.C -> O(M + N) S.C -> O(M + N)
        HashSet<Integer> hs = new HashSet<>();
        for(int val:arr1){
            hs.add(val);
        }
        for(int val:arr2){
            hs.add(val);
        }

        return hs.size();
        /* 
        NAIVE T.C -> O(m * m + n*(m + n))
        res = 0;
        dist[];
        for every in arr1
            checkPresence(dist);
            if already present do nothing 
            else if not present add to dist
            res++;
        do same for arr2
         */
    }

    /* ----------------PAIR WITH GIVEN SUM--------------------------
        Given array and a sum find if a pair with the given sum exists in the array
     */
    public static boolean hasPair(int[] arr,int sum){
        // EFFICIENT T.C -> O(N) S.C -> O(N)
        HashSet<Integer> hs = new HashSet<>();

        for(int val:arr){
            if(hs.contains(sum - val)){
                return true;
            }
            hs.add(val);
        }

        return false;

        /* NAIVE T.C -> O(N^2) S.C ->O(1)
        for(int i = 0;i < arr.length;i++){
            for(int j = i + 1;j < arr.length;j++){
                if(arr[i] + arr[j] == sum){
                    return true;
                }
            }
        }

        return false;
        */
    }

    /* ----------------SUBARRAY WITH ZERO SUM----------------------
        Given array return true if there exists a subarray with sum = 0
        ex, subarrays of [10,20,30] are 
        [10],[10,20],[10,20,30],[20],[20,30],[30]
        subarray needs to have contigous elements only
     */

    public static boolean hasSubarrayWithZeroSum(int[] arr){
        /* Efficient T.C -> O(N) S.C -> O(N)
            uses the concept of prefix sum 
            calculate the prefix sum and keep on adding it to a set
            if value already exists in the set then that means the current subarray has a sum of 0
            ex. [1,4,13,-3,-10,5]
            prefix sum will be = 1 -> 5 -> 18 -> 15 -> 5 ..
            getting the same prefix sum means the subarray b/w 13 -> -10 has a sum of 0 to be able to have 5 + 0 = 5
        */
        HashSet<Integer> hs = new HashSet<>();
        hs.add(0); // to handle cases with prefix sum as 0 ex. [-3,2,1]
        int preSum = 0;
        for(int i = 0;i < arr.length;i++){
            preSum += arr[i];
            if(hs.contains(preSum)){
                return true;
            }
            hs.add(preSum);
        }

        return false;

        /* Naive T.C -> O(N^2)
        for(int i = 0;i < arr.length;i++){
            int subarraySum = 0;
            for(int j = i;j < arr.length;j++){
                subarraySum += arr[j];
                if(subarraySum == 0){
                    return true;
                }
            }
        }

        return false;
        */
    }

    /* ----------------SUBARRAY WITH GIVEN SUM---------------------- 
        similar to previous but sum is given and not 0
    */
    public static boolean hasSubarrayWithSum(int[] arr,int sum){
        // efficient T.C -> O(N) S.C -> O(N)
        HashSet<Integer> hs = new HashSet<>();
        int preSum = 0;
        for(int val : arr){
            preSum += val;
            if(preSum == sum){
                // to handle cases in which subarray begin with index 0
                // ex. [2,3,4] sum = 9
                // there is nothing previous to compare to
                // could also just add a value of 0 to the set
                return true;
            }
            // similar to has subarray with 0 sum
            if(hs.contains(preSum - sum)){
                return true;
            }
            hs.add(preSum);
        }
        return false;
        /* 
        NAIVE T.C -> O(n^2)
        for(int i = 0;i < arr.length;i++){
            curr_sum = 0;
            for(j = i;j<arr.length;j++){
                curr_sum += arr[i];
                if(curr_sum == sum)
                    return true; 
            }
        }
        */
    }

    /* ----------------LONGEST SUBARRAY WITH GIVEN SUM---------------- 
        Given array and a sum return the length of the largest subarray with given sum
        ex. [8 3 1 5 -6 6 2 2]
    */
    public static int longestSubarrayWithSum(int[] arr,int sum){
        // Efficient T.C -> O(N) S.C -> O(N)
        // <Presum,Index>
        HashMap<Integer,Integer> hm = new HashMap<>();
        // hm.put(0,-1); // to handle single elements at start == sum
        int preSum = 0;
        int length = 0;
        for(int i = 0;i < arr.length;i++){
            preSum += arr[i];

            if(preSum == sum){ 
                // to handle cases where the subarray starts from 0 index since there is nothing before it to be compared to 
                length = i + 1;
            }

            // if presum is already present then that means the current subarray has sum = 0 and no point in updating the previous value since we need a longer subarray overall and 0 sum will increase the length.
            if(hm.containsKey(preSum) == false){
                // need to put everything since need length of largest
                hm.put(preSum,i);
            }

            int key = preSum - sum;
            if(hm.containsKey(key)){
                length = Math.max(length,i - hm.get(key));
            }
        }

        return length;
        /* NAIVE T.C -> O(N^2) 
        int length = 0;
        for(int i = 0;i < arr.length;i++){
            int currSum = 0;
            int currLength = 0;
            for(int j = i;j < arr.length;j++){
                currSum += arr[j];
                currLength++;
                // makes a subarray equal to sum
                if(currSum == sum){
                    // update the length
                    length = Math.max(length,currLength);
                }
            }
        }

        return length;
        */
    }

    /* -----------LONGEST SUBARRAY WITH EQUAL NUMBER OF 0 & 1--------- */
    public static int longestSubarrayWithEqual01(int[] arr){
        // EFFICIENT T.C -> O(N) & S.C -> O(N)
        for(int i = 0;i < arr.length;i++){
            // convert 0 to -1
            if(arr[i] == 0){
                arr[i] = -1;
            }
        }
        // now find largest subarray with sum 0
        int res = longestSubarrayWithSum(arr,0);
        return res;
        /* NAIVE T.C -> O(N^2)
            int res = 0;
            for(int i = 0;i < arr.length;i++){
                int count_0 = 0;
                int count_1 = 0;

                for(int j = i;j < arr.length;j++){
                    if(arr[j] == 0) count_0++;
                    else count_1++;

                    if(count_0 == count_1){
                        res = Math.max(res,count_0 + count_1);
                    }
                }
            }

            return res;
         */
    }
}