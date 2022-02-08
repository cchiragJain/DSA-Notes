import java.util.Scanner;

public class FindPeakElement {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = takeArrayInput();

        // naive approach toh linear search hi hogi
        // yah toh find element which is greater than previous and greater
        // than the next element by looping from the second element
        // OR
        // just return the maximum element of the array
        // since it will always be the peak since
        // no consecutive duplicates can be there

        System.out.println(findPeak(arr));
    }

    public static int findPeak(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            // if this condition is true can eliminate the right part and peak will be for sure in the left part
            if (arr[mid] > arr[mid + 1]) {
                high = mid;
            }
            // agar aisa nahi h toh uss element ke aage ka hi hoga peak
            else {
                low = mid + 1;
            }
        }
        return arr[low];
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
