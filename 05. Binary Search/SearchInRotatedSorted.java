import java.util.Scanner;

public class SearchInRotatedSorted {
    // Naive toh linear search hi hoga O(n)
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = takeArrayInput();

        System.out.println("Enter element");
        int x = sc.nextInt();

        System.out.println(findInRotatedSorted(arr, x));
    }

    public static int findInRotatedSorted(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                return mid;
            }

            // if left part is sorted
            if (arr[low] <= arr[mid]) {
                // check if it is belongs in the left part or not
                if (x >= arr[low] && x <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // or if right part is sorted
            else {
                // check if belongs in right part
                if (x >= arr[mid] && x <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
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
