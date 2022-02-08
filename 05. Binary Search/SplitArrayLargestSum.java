import java.util.Scanner;

public class SplitArrayLargestSum {

    // in this we are minimising the maximum sum

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = takeArrayInput();
        System.out.println("Enter m");
        int m = sc.nextInt();
        System.out.println(splitArray(arr, m));
    }

    public static int splitArray(int[] arr, int m) {
        int low = maxOfArray(arr);
        int high = arraySum(arr);

        // worst case (m = 1) pe answer high hoga
        // not necessary required condition
        int ans = high;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossible(arr, mid, m)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int[] arr, int limit, int m) {
        // number of subarrays by keeping limit is that possible
        int sum = 0;
        // ek na ek toh banegi hi
        int count = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > limit)
                return false;

            if (sum + arr[i] > limit) {
                count++;
                // for next subarray it will start from current element only
                sum = arr[i];
            } else {
                sum += arr[i];
            }

        }

        return count <= m;
    }

    public static int maxOfArray(int[] arr) {
        int maximum = Integer.MIN_VALUE;

        for (int val : arr)
            maximum = Math.max(val, maximum);

        return maximum;
    }

    public static int arraySum(int[] arr) {
        int sum = 0;

        for (int val : arr)
            sum += val;

        return sum;
    }

    public static int[] takeArrayInput() {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int val : arr)
            System.out.print(val + " ");
        System.out.println();
    }
}
