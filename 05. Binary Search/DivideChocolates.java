import java.util.Scanner;

public class DivideChocolates {
    static Scanner sc = new Scanner(System.in);

    // this one is opposite of split array largest sum
    // in this we are maximising the minimum sum
    public static void main(String[] args) {
        int[] arr = takeArrayInput();
        System.out.println("Enter k");
        int k = sc.nextInt();

        System.out.println(splitArray(arr, k));
    }

    public static int splitArray(int[] arr, int k) {
        // incrementing k because doing k cuts will divide it into (k + 1) pieces
        k++;

        int low = minArray(arr);
        int high = sumOfArray(arr);
        int ans = low;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossible(arr, mid, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int[] arr, int limit, int k) {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum >= limit) {
                // ek subarray ban gayi
                count++;

                // agli subarray ke liye sum 0 se start hoga
                sum = 0;
            }
        }

        return count >= k;
    }

    public static int minArray(int[] arr) {
        int minimum = Integer.MAX_VALUE;
        for (int val : arr)
            minimum = Math.min(minimum, val);

        return minimum;
    }

    public static int sumOfArray(int[] arr) {
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
