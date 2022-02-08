import java.util.Scanner;

public class ArrayRotateByK {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = takeArrayInput();
        rotateArrayByOne(arr);

        System.out.println("Enter value of K ");
        int k = sc.nextInt();

        rotateArrayNaive(arr, k);
        printArray(arr);

        System.out.println("Enter new k ");
        k = sc.nextInt();

        rotateArrayBest(arr, k);
        printArray(arr);

    }

    public static void rotateArrayBest(int[] arr, int k) {
        // this will make sure that we are not doing stuff again and again
        k = k % arr.length;
        // handling cases of left rotation
        if (k < 0)
            k = k + arr.length;

        // O(n) and O(1) space
        int n = arr.length;
        reverseArray(arr, 0, n - k);
        reverseArray(arr, n - k, n);
        reverseArray(arr, 0, n);
    }

    public static void reverseArray(int[] arr, int low, int high) {
        high--;
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    public static void rotateArrayNaive(int[] arr, int k) {
        // this will make sure that we are not doing stuff again and again
        k = k % arr.length;
        // handling cases of left rotation
        if (k < 0)
            k = k + arr.length;

        // O(k*n)
        for (int i = 0; i < k; i++) {
            rotateArrayByOne(arr);
        }
    }

    public static void rotateArrayByOne(int[] arr) {
        // O(n)
        int size = arr.length;
        int temp = arr[size - 1];
        for (int i = size - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
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
