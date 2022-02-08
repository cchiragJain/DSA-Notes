import java.util.*;

public class MinimumInSortedRotated {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = takeArrayInput();

        System.out.println("Minimim without duplicates : " + findMin(arr));

        System.out.println("Minimum with duplicates : " + findMinInDuplicatesArray(arr));
    }

    public static int findMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;

            // agar mid chotta hain aur uske agge ke saare sorted honge toh aage ka discard kar sakte hain
            if (arr[mid] < arr[high]) {
                high = mid;
            }

            // agar mid bada hain aur usse piche ke sorted hain toh uske aage ke hi elements mein se honga minimum
            else {
                low = mid + 1;
            }
        }

        return arr[high];
    }

    public static int findMinInDuplicatesArray(int[] arr) {
        // agar equal hua toh comparison nahi kar paaege
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            // agar chotta hain toh uske aage vaale minimum toh nahi ho sakte
            if (arr[mid] < arr[high]) {
                high = mid;
            }
            // agar bada h toh uske piche vaale aur voh toh nhi ho sakte
            else if (arr[mid] > arr[high]) {
                low = mid + 1;
            }
            // agar last element aur mid equal h
            // agar duplicate minimum element hain toh voh apne aap consider ho jaaega
            else {
                high--;
            }
        }

        return arr[high];
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
