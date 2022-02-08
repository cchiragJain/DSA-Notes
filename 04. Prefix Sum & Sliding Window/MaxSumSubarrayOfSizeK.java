import java.util.*;

public class MaxSumSubarrayOfSizeK {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = takeArrayInput();

        System.out.println("Enter value of k");
        int k = sc.nextInt();

        System.out.println(findMaxSumOfKSizeSubarray(arr, k));
    }

    public static int findMaxSumOfKSizeSubarray(int[] arr, int k) {
        int n = arr.length;
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        int windowSum = maxSum;

        for (int i = k; i < n; i++) {
            // add current element
            windowSum += arr[i];
            // remove first element of last window
            windowSum -= arr[i - k];

            maxSum = Math.max(windowSum, maxSum);
        }

        return maxSum;
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
