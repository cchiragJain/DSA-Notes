import java.util.Scanner;

public class PrefixSumAlgo {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = takeArrayInput();
        int[] prefixSumArray = createPrefixSumArray(arr);

        // give queries
        System.out.println("Enter no. of queries you want to perform?");
        int queries = sc.nextInt();

        // running the loop query times
        for (int i = 0; i < queries; i++) {
            System.out.println("Enter value of l & r");
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(getSumUsingPrefixSumArray(prefixSumArray, l, r));
        }
    }

    // USING PREFIX SUM
    public static int getSumUsingPrefixSumArray(int[] prefixSumArray, int l, int r) {
        // O(1) time lega yeh har query ke liye

        return l > 0 ? prefixSumArray[r] - prefixSumArray[l - 1] : prefixSumArray[r];
    }

    // CREATING PREFIX SUM ARRAY
    public static int[] createPrefixSumArray(int[] arr) {
        int[] prefixSumArray = new int[arr.length];
        prefixSumArray[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSumArray[i] = arr[i] + prefixSumArray[i - 1];
        }
        return prefixSumArray;
    }

    // NAIVE METHOD
    public static int getSumNaive(int[] arr, int l, int r) {
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += arr[i];
        }
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