import java.util.Scanner;

public class MinimumLengthOfSubarraySum {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = takeArrayInput();

        int target = sc.nextInt();

        System.out.println(findMinLength(arr, target));

    }

    public static int findMinLength(int[] arr, int target) {
        int low = 1;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (maxSubarraySumOfSizeK(arr, mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high;

    }

    public static int maxSubarraySumOfSizeK(int[] arr, int k) {
        int maxSum = 0;

        // calculate sum till k ( 1st window )
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        // make sures to check for 1st window
        int windowSum = maxSum;

        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i];
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
