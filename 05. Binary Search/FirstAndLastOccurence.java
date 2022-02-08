import java.util.Scanner;

public class FirstAndLastOccurence {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int[] arr = takeArrayInput();
        int x = sc.nextInt();

        int firstOccurence = firstOccurence(arr, x);
        int lastOccurence = lastOccurence(arr, x);

        System.out.println("First Occurence : " + firstOccurence);

        System.out.println("Last Occurence : " + lastOccurence);

        if (firstOccurence != -1) {
            int count = lastOccurence - firstOccurence + 1;
            // can also do upperbound - lowerbound as well
            System.out.println(count);
        }
    }

    public static int firstOccurence(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // if found search for it in the left in the next iteration
            if (arr[mid] == x) {
                ans = mid;
                high = mid - 1;
                continue;
            }

            // normal binary search
            // if not at mid search for it on the left
            if (arr[mid] > x) {
                high = mid - 1;
            }
            // search for it on the right
            else if (arr[mid] < x) {
                low = mid + 1;
            }

        }
        return ans;
    }

    public static int lastOccurence(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // if element found search for it in the right part again
            if (arr[mid] == x) {
                ans = mid;
                low = mid + 1;
            }

            if (arr[mid] > x) {
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            }
        }

        return ans;
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