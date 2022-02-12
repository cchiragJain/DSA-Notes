import java.util.*;

/* 
    Contains ->
        1. Longest Common subarray in a binary array
        2. Longest consecutive subsequence
        3. Count distinct elements in every window of size k
 */

public class HashMapQuestions2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < arr.length;i++){
            arr[i] = sc.nextInt();
        }

        countDistinctInWindow(arr,4);
    }

    /* --------------------LONGEST COMMON SUBARRAY--------------------
        Given 2 binary arrays of same size return the length of the largest common subarray with same sum 
     */
    public static int longestCommonSubarray(int[] arr1,int[] arr2){
        // EFFICIENT T.C -> O(N) S.C -> O(N)
        /* compute a difference array
            if arr[i] = 0 then that means same elements in arr1 and arr2
            if arr[i] = 1 then that means there is a extra 1 in arr1 and to combat that there should be 1 in arr2
            if arr[i] = -1 then arr2 has a extra 1 ""
            in order for things to be equal the sum should be 0
         */

        int[] arr = new int[arr1.length];
        for(int i = 0;i < arr1.length;i++){
            arr[i] = arr1[i] - arr2[i];
        }

        // get length of largest subarray with sum 0
        HashMap<Integer,Integer> hm = new HashMap<>();
        int preSum = 0;
        int length = 0;

        for(int i = 0;i < arr.length;i++){
            preSum += arr[i];
            if(preSum == 0){
                // to handle cases where subarrays start with 0th index
                length = i + 1;
            }

            if(hm.containsKey(preSum)){
                // update length if this sum has already been seen before
                length = Math.max(length,i - hm.get(preSum));
            } else {
                hm.put(preSum,i);
            }
        }
        return length;

        /* NAIVE T.C -> O(N^2) 
        int length = 0;

        for(i = 0;i < arr1.length;i++){
            int sum1 = 0;
            int sum2 = 0;
            int currLength = 0;

            for(int j = i;j < arr1.length;j++){
                sum1 += arr1[j];
                sum2 += arr2[j];
                currLength++;

                if(sum1 == sum2){
                    length = Math.max(length,currLength);
                }
            }
        }

        return length;
        */
    }
    
    /* ----------------LONGEST CONSECUTIVE SUBSEQUENCE----------------
        Given an array, we need to find the longest subsequence that has consecutive elements. These consecutive elements may appear in any order in the subsequence.
     */
    public static int longestConsecutiveSubsequence(int[] arr){
        /* EFFICIENT T.C -> O(n) S.C -> O(N) */
        HashSet<Integer> set = new HashSet<>();

        // add values to a set will also take care of duplicates
        for(int val:arr){
            set.add(val);
        }

        int maxStreak = 0;

        /* this loop will be O(n + n) -> O(n) only
            the inner while loop will only run for those numbers which can form a sequence
            ex. if input = [1,2,3,4,5,5,6]
            while will only run for the 1st element and do n iterations for every array
        */

        // iterate through the set
        for(int val : set){
            // only care about those values that can a start a new sequence
            // if have a value less by -1 then can't start sequence from that number
            if(set.contains(val - 1) == false){
                int currentNum = val;
                int currentStreak = 1;

                // keep updating currentStreak if set contains a greater value by 1
                while(set.contains(currentNum + 1)){
                    currentStreak++;
                    currentNum++;
                }

                // update max Streak
                maxStreak = Math.max(currentStreak,maxStreak);
            }
        }

        return maxStreak;

        /* BETTER T.C -> O(n logn) 
            int maxStreak = 1;
            int currentStreak = 1;

            Arrays.sort(arr);

            for(int i = 0;i < arr.length - 1;i++){
                // if duplicate elements after sorting don't consider them
                if(arr[i] == arr[i + 1]){
                    continue;
                }

                // if current + 1 = next then they are consecutive and update the currentStreak

                if(arr[i] + 1 == arr[i + 1]){
                    currentStreak++;
                } else {
                    currentStreak = 1;
                }

                maxStreak = Math.max(currentStreak,maxStreak);
            }

            return maxStreak;
        */

        /* NAIVE T.C -> O(N^3)
            int maxStreak = 0;

            for(int i = 0;i < arr.length;i++){
                int currentNum = arr[i];
                int currentStreak = 1;

                // arrayContains does a linear search O(N)

                while(arrayContains(arr,currentNum + 1)){
                    currentStreak++;
                    currentNum++;
                }

                maxStreak = Math.max(currentStreak,maxStreak);
            }

            return maxStreak;
         */
    }
    
    /* ------------COUNT DISTINCT IN EVERY WINDOW OF SIZE K-------- 
        Given array and a window size of k count no. of distinct elements in every window
    */
    public static void countDistinctInWindow(int[] arr,int k){
        // Efficient T.C -> O(N) S.C -> O(N) do a dry run with a big array for why
        // follow acquire print remove
        int n = arr.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        // frequency map for the first k - 1 elements of the array
        for(int i = 0;i < k - 1;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0) + 1);
        }

        for(int i = k - 1,j = 0;i < n;i++){
            // acquire
            hm.put(arr[i],hm.getOrDefault(arr[i],0) + 1);

            // print
            System.out.println(hm.size());

            // remove
            int freq = hm.get(arr[j]);
            if(freq == 1){
                hm.remove(arr[j]);
            } else {
                hm.put(arr[j],freq - 1);
            }

            // next element to be removed
            j++;
        }

        /* NAIVE  T.C -> O(N^3)
        int n = arr.length;
        // traverse till the start of the last window
        for(int i = 0;i < n - k + 1;i++){
            int count = 0;
            // traverse current window
            for(int j = i;j < i + k;j++){
                // check if current element present previously
                boolean flag = false;
                for(int p = j - 1;p >= i;p--){
                    if(arr[p] == arr[j]){
                        flag = true;
                        break;
                    }
                }

                // if flag remains false means first occurence
                if(flag == false){
                    count++;
                }
            }
            System.out.println((i + 1) + " window count is ->" + count);
        }
        */
    }
}