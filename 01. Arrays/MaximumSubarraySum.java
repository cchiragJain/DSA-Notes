import java.util.Scanner;

public class MaximumSubarraySum {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = takeArrayInput();

        int sum = subarraySumNaive(arr);

        System.out.println("Naive : " + sum);

        sum = subarraySumEfficient(arr);

        System.out.println("Kadane Algo : " + sum);

    }

    public static int subarraySumEfficient(int[] arr) {
        // This is implementation of KADANE ALGORITHM
        // Refer Notes / Pepcoding video
        // taking cbest and obest as 0 will not work in the case of negative numbers
        int cbest = arr[0];
        int obest = arr[0];

        for (int i = 0; i < arr.length; i++) {
            // >=0 islie kyuki agar negative number hua toh aur ghataega sum ko islie new start karlo
            if (cbest >= 0)
                cbest += arr[i];
            else
                cbest = arr[i];

            obest = Math.max(obest, cbest);
        }

        return obest;
    }

    public static int subarraySumNaive(int[] arr) {
        // add elements while traversing to the next elements and compare max at the end
        int maximum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                // k vaala lagane ki jarurat nahi h because j mein bhi traversal hota hain and har baar comparison kar rahe h
                sum += arr[j];
                maximum = Math.max(maximum, sum);
            }
        }

        return maximum;
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
