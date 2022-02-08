import java.util.Scanner;

public class ArrayReverse {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = takeArrayInput();
        reverseArray(arr);
        printArray(arr);
    }

    public static void reverseArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            swap(arr, low, high);
            low++;
            high--;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
