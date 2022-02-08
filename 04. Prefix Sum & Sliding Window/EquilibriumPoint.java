import java.util.Scanner;

public class EquilibriumPoint {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = takeArrayInput();

        // System.out.println(findEquilibriumPointNaive(arr));

        // System.out.println(findEquilibriumPoint(arr));

        System.out.println(findEquilibriumPointEfficient(arr));
    }

    public static int findEquilibriumPointEfficient(int[] arr) {
        int n = arr.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int lSum = 0;
        int rSum = sum;

        for (int i = 0; i < n; i++) {
            if (lSum == rSum - arr[i])
                return i;
            lSum += arr[i];
            rSum -= arr[i];
        }
        return -1;
    }

    public static int findEquilibriumPoint(int[] arr) {
        // This method still takes some extra space of O(n) with time complexity reduced to O(n) as well.
        int[] prefixSumArray = generatePrefixSumArray(arr);
        int[] suffixSumArray = generateSuffixSumArray(arr);

        System.out.println("prefix sum rray");
        printArray(prefixSumArray);
        System.out.println("suffix sum array");
        printArray(suffixSumArray);

        if (arr.length == 1)
            return 0;

        // This condition is checked because corner elements have sum as 0
        if (prefixSumArray[prefixSumArray.length - 2] == 0) {
            return prefixSumArray.length - 1;
        }
        if (suffixSumArray[1] == 0) {
            return 0;
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if (prefixSumArray[i - 1] == suffixSumArray[i + 1])
                return i;
        }
        return -1;
    }

    public static int[] generatePrefixSumArray(int[] arr) {
        int[] prefixSumArray = new int[arr.length];
        prefixSumArray[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSumArray[i] = arr[i] + prefixSumArray[i - 1];
        }
        return prefixSumArray;
    }

    public static int[] generateSuffixSumArray(int[] arr) {
        int n = arr.length;
        int[] suffixSumArray = new int[n];
        suffixSumArray[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSumArray[i] = suffixSumArray[i + 1] + arr[i];
        }
        return suffixSumArray;
    }

    public static int findEquilibriumPointNaive(int[] arr) {
        // O(n^2) complexity
        for (int i = 0; i < arr.length; i++) {
            int lSum = 0;
            int rSum = 0;
            for (int j = 0; j < i; j++)
                lSum += arr[j];
            for (int j = i + 1; j < arr.length; j++)
                rSum += arr[j];

            System.out.println(i + " " + lSum + " " + rSum);
            if (rSum == lSum)
                return i;
        }
        return -1;
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
