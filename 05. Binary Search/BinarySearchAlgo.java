import java.util.*;

public class BinarySearchAlgo {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = takeArrayInput();
        System.out.println("Enter element to find");
        int element = sc.nextInt();

        System.out.println(binarySearch(arr, element));
    }

    public static int binarySearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                return mid;
            }

            // element is not on the right half
            else if (arr[mid] > x) {
                high = mid - 1;
            }

            // element is not on the left half
            else {
                low = mid + 1;
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
