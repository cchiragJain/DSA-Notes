import java.util.Scanner;

public class LowerUpperBound {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = takeArrayInput();
        System.out.println("enter element");
        int x = sc.nextInt();

        System.out.println("Lower Bound : " + lowerBound(arr, x));
        System.out.println("Upper Bound : " + upperBound(arr, x));

    }

    public static int lowerBound(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;

        int ans = arr.length;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static int upperBound(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;

        int ans = arr.length;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
                ans = mid;
                // ho sakta h piche bhi answer ho
                high = mid - 1;
            } else {
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
